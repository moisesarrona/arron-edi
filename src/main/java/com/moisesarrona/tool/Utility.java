package com.moisesarrona.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author moisesarrona
 * @version 0.1
 */
public class Utility implements UtilityI {

    /**
     * Read any file and build and return string
     *
     * @author moisesarrona
     * @param path: file location
     * @return reader: file content
     */
    @Override
    public String readFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line.trim());
                line = reader.readLine();
            }

            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: ", e);
        }
    }

    /**
     * Get packages from path and return name packages
     *
     * @author moisesarrona
     * @param path: packages location.
     * @return packageNames: String collection Set<String>
     */
    @Override
    public Set<String> getPackages(Path path) {
        Set<String> packageNames = new HashSet<>();

        try {
            Files.walk(path)
                    .filter(Files::isDirectory)
                    .forEach(dir -> {
                        Path packagePath = path.relativize(dir);
                        Path fullPath = path.resolve(packagePath);
                        String fullPackageName = fullPath.toString()
                                .replace(File.separator, ".")
                                .replace("src.main.java.", "");
                        packageNames.add(fullPackageName);
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e);
        }

        return packageNames;
    }

    /**
     * Get classes from packages
     *
     * @param packageName: packages name in format com.moisesarrona.segments
     * @param includePath: add path true or no include path false
     * @return classNames: String collection List<String>
     */
    @Override
    public List<String> getClassEdi(String packageName, Boolean includePath) {
        String packagePath = packageName.replace(".", "/");
        File packageDir = new File("./src/main/java/" + packagePath);
        File[] files = packageDir.listFiles();

        List<String> classNames = new ArrayList<>();
        if (files != null) {
            classNames = Arrays.stream(files)
                    .filter(file -> file.isFile() && file.getName().endsWith(".java"))
                    .map(file -> {
                        String className = packageName + "." + file.getName().substring(0, file.getName().length() - 5);
                        try {
                            Class.forName(className);
                            return includePath ? className : file.getName().substring(0, file.getName().length() - 5);
                        } catch (ClassNotFoundException e) {
                            // El archivo no es una clase, se omite
                            //return null;
                            throw new RuntimeException("Error in class: " + e);
                        }
                    })
                    //.filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return classNames;
    }

    @Override
    public List<String> getFieldClass(String packageName) {
        try {
            Class<?> cls = Class.forName(packageName);
            Constructor<?> constructor = cls.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Field[] fields = cls.getDeclaredFields();
            Arrays.stream(fields).forEach(item -> {
                System.out.println(item.getName());
            });
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
