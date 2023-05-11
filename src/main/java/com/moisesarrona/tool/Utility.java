package com.moisesarrona.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author moisesarrona
 * @version 0.1
 */
public class Utility implements UtilityI {

    /**
     * Read any file and build string
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
                sb.append(line);
                line = reader.readLine();
            }

            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: ", e);
        }
    }
}
