package com.moisesarrona.arronedi.controller;

import com.google.gson.Gson;
import com.moisesarrona.arronedi.segments.body.Body;
import com.moisesarrona.arronedi.tool.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import com.moisesarrona.arronedi.tool.Global;

/**
 * @author moisesarrona
 * @version 1.1
 */
public class Converter {

    /**
     * Convert json to Object
     *
     * @param path file location
     * @return A Body class with EDI content
     */
    public Body jsonFileToObject(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Body.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    /**
     * Convert to json to Object
     *
     * @param json json content
     * @return Body class with EDI content
     */
    public Body jsonStringToObject(String json) {
        Gson gson = new Gson();
        if (json.isEmpty())
            throw new NullPointerException("Value is equals to null");
        return gson.fromJson(json, Body.class);
    }

    /**
     * Convert Json to EDIx12
     *
     * @param json Json content
     * @param path is path true, isn't path false
     * @return A String with EDI content in format X12
     */
    public String jsonFileToEdi(String json, Boolean path) {
        Utility utility = new Utility();

        String jsonContent = path ? utility.readFile(json) : json;
        Path location = Global.getPackagePath();
        Set<String> packages = utility.getPackages(location);

        AtomicReference<String> jsonContentRef = new AtomicReference<>(jsonContent);
        packages.forEach(packag -> {
            List<String> clss = utility.getClassEdi(packag, true);
            clss.forEach(cls -> {
                List<String> fields = utility.getFieldClass(cls);
                fields.forEach(field -> {
                    if (!(cls.equals(Global.PATH_HEAD) || cls.equals(Global.PATH_DETAIL) ||
                            cls.equals(Global.PATH_SUMMARY))) {
                        jsonContentRef.set(jsonContentRef.get().replace(field, ""));
                    }
                });
            });
        });

        return jsonContentRef.get()
                .replaceAll(",", "").replaceAll("\\{", "")
                .replaceAll("}", "~").replaceAll(":", "*")
                .replaceAll("\\[", "").replaceAll("]", "")
                .replaceAll("\"(.*?)\"|\\s+", "$1")

                .replaceAll("~{2,}", "~").replaceAll("\\*{2,}", "*")
                .replaceFirst("\\*", "");
    }

    /**
     * Convert Object to Json
     *
     * @param body class with EDI content
     * @return A String with EDI content in format json
     */
    public String objectToJson(Body body) {
        Gson gson = new Gson();
        if (body == null)
            throw new NullPointerException("Value is equals to null");
        return gson.toJson(body);
    }

    /**
     * Convert Object to EDIx12
     *
     * @param body class with EDI content
     * @return A String with EDI content in format X12
     */
    public String objectToEdi(Body body) {
        Class<?> bodyClass = body.getClass();
        Field[] bodyFields = bodyClass.getDeclaredFields();

        StringBuilder ediContent = new StringBuilder();
        Arrays.stream(bodyFields).forEach(bodyField -> {
            bodyField.setAccessible(true);
            try {
                Object fieldValue = bodyField.get(body);
                Class<?> ediClass = bodyField.getType();
                Field[] ediFields = ediClass.getDeclaredFields();

                if (fieldValue instanceof List<?>)
                    ediContent.append(processList((List<?>) fieldValue));
                else
                    ediContent.append(processField(fieldValue, ediFields));

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        });

        return ediContent.toString();
    }

    /**
     * Process Detail list from Body class
     *
     * @param fieldValues Detail list
     * @return A String with Detail values
     */
    public String processList(List<?> fieldValues) {
        StringBuilder ediContent = new StringBuilder();
        fieldValues.forEach(fieldValue -> {
            Class<?> detailClass = fieldValue.getClass();
            Field[] detailFields = detailClass.getDeclaredFields();
            ediContent.append(processField(fieldValue, detailFields));
        });
        return ediContent.toString();
    }

    /**
     * Process fields get data from class edi
     *
     * @param fieldValue Fields from class edi
     * @param ediFields Class part body
     * @return A String with part body values
     */
    public String processField(Object fieldValue, Field[] ediFields) {
        StringBuilder ediContent = new StringBuilder();
        Arrays.stream(ediFields).forEach(ediField -> {
            ediField.setAccessible(true);
            try {
                Object ediFieldValue = ediField.get(fieldValue);
                ediContent.append(ediFieldValue.getClass().getSimpleName()).append("*");

                Class<?> clss = ediField.getType();
                Field[] fields = clss.getDeclaredFields();

                IntStream.range(0, fields.length).forEach(index -> {
                    Field field =fields[index];
                    field.setAccessible(true);
                    try {
                        Object value = field.get(ediFieldValue);

                        if (value != null) {
                            if (index == fields.length -1) {
                                ediContent.append(value.toString()).append("~");
                            } else {
                                ediContent.append(value.toString()).append("*");
                            }
                        }

                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        });
        return ediContent.toString();
    }

    public String ediToObject(String edi, Boolean path) {
        Utility utility = new Utility();

        String ediContent = path? utility.readFile(edi) : edi;
        String[] ediSegments = ediContent.split("~");
        Arrays.stream(ediSegments).forEach(segment -> {
            String[] ediElement = segment.split("\\*");
            System.out.println(Arrays.toString(ediElement));
        });

        return ediContent;
    }

}
