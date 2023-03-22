package com.moisesarrona.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility implements UtilityI {

    @Override
    public String readFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }

            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: ", e);
        }
    }

    @Override
    public List<String> getClassEdi(String packageName) {
        String packagePath = packageName.replace(".", "/");
        File packageDir = new File("src/main/java/" + packagePath);
        File[] files = packageDir.listFiles();

        assert files != null;
        return Arrays.stream(files).map((file) -> {
            if (file.isFile() && file.getName().endsWith(".java"))
                return file.getName().substring(0, file.getName().length() - 5);
            return "";
        }).collect(Collectors.toList());

    }

    @Override
    public Object setFieldClassEdi(String packageName, String className) {
        try {
            Class<?> cls = Class.forName(packageName + className);
            Constructor<?> constructor = cls.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Field[] fields = cls.getDeclaredFields();

            Arrays.stream(fields).forEach((field) -> {
                field.setAccessible(true);
                try {
                    field.set(instance, "P");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error setting values: ", e);
                }
            });

            return instance;

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error reading class, declaring constructor or instancing constructor, : ", e);
        }
    }

    @Override
    public List<String> getAllClassEdi() {
        String[] packages = {
            "com.moisesarrona.segments.heading",
            "com.moisesarrona.segments.detail",
            "com.moisesarrona.segments.summary"
        };

        List<String> clss = new ArrayList<>();
        Arrays.stream(packages).forEach((packag) -> {
            clss.addAll(getClassEdi(packag));
        });

        return clss;
    }

}
