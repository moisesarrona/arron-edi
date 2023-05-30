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

public class Converter {

    public Body jsonFileToObject(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Body.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    public Body jsonStringToObject(String json) {
        Gson gson = new Gson();
        if (json.isEmpty())
            throw new NullPointerException("Value is equals to null");
        return gson.fromJson(json, Body.class);
    }

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
                //repeated value replacement
                .replaceAll("~{2,}", "~").replaceAll("\\*{2,}", "*")
                .replaceFirst("\\*", "");

    }

    public String objectToJson(Body body) {
        Gson gson = new Gson();
        if (body == null)
            throw new NullPointerException("Value is equals to null");
        return gson.toJson(body);
    }

}
