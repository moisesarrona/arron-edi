package com.moisesarrona.controller;

import com.google.gson.Gson;
import com.moisesarrona.segments.body.Body;
import com.moisesarrona.tool.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import com.moisesarrona.tool.Global;

/**
 * @author moisesarrona
 * @version 0.1
 */
public class Converter {

    /**
     *
     * @author moisesarrona
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
     *
     * @param json json content
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

                                if (index == fields.length -1) {
                                    ediContent.append(value.toString()).append("~");
                                } else {
                                    ediContent.append(value.toString()).append("*");
                                }

                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        });

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

}
