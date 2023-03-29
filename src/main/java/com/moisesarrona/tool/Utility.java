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
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utility implements UtilityI {

    @Override
    public String readFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }

            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: ", e);
        }
    }

    @Override
    public List<String> getClassEdi(String packageName, Boolean path) {
        String packagePath = packageName.replace(".", "/");
        File packageDir = new File("src/main/java/" + packagePath);
        File[] files = packageDir.listFiles();

        assert files != null;
        return Arrays.stream(files).map((file) -> {
            if (file.isFile() && file.getName().endsWith(".java"))
                return path? packageName + "." + "[" + file.getName().substring(0, file.getName().length() - 5) + "]" :
                        file.getName().substring(0, file.getName().length() - 5);
            return "";
        }).collect(Collectors.toList());

    }

    @Override
    public Object setFieldClassEdi(String packageName, String[] elements){
        try {
            Class<?> cls = Class.forName(packageName);
            Constructor<?> constructor = cls.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Field[] fields = cls.getDeclaredFields();

            IntStream.range(0, Math.min(fields.length, elements.length))
                    .forEach(i -> {
                        try {
                            fields[i].setAccessible(true);
                            fields[i].set(instance, null);
                            if (i + 1 < elements.length) {
                                Class<?> fieldType = fields[i].getType();
                                if (fieldType == Integer.class) {
                                    Integer value = Integer.parseInt(elements[i + 1]);
                                    fields[i].set(instance, value);
                                } else if (fieldType == Boolean.class) {
                                    Boolean value = Boolean.parseBoolean(elements[i + 1]);
                                    fields[i].set(instance, value);
                                } else if (fieldType == String.class) {
                                    fields[i].set(instance, elements[i + 1]);
                                }
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Error in set attributes: ", e);
                        }
                    });

            return instance;

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error reading class, declaring constructor or instancing constructor, : ", e);
        }
    }

    @Override
    public List<String> getAllClassEdi(Boolean path) {
        List<String> packages = new ArrayList<>();
        packages.add("com.moisesarrona.segments.heading");
        packages.add("com.moisesarrona.segments.detail");
        packages.add("com.moisesarrona.segments.summary");

        return packages.stream()
                .flatMap(packag -> getClassEdi(packag, path).stream())
                .collect(Collectors.toList());
    }

}
