package com.moisesarrona.controller;

import com.google.gson.Gson;
import com.moisesarrona.segments.body.Body;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

}
