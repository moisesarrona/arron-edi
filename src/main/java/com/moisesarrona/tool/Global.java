package com.moisesarrona.tool;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Global {
    public static final String PATH_HEAD = "com.moisesarrona.segments.body.Head";
    public static final String PATH_DETAIL = "com.moisesarrona.segments.body.Detail";
    public static final String PATH_SUMMARY = "com.moisesarrona.segments.body.Summary";
    public static final String PATH_BODY_EDI = "./src/main/java/com/moisesarrona/segments";

    public static Path getPackagePath() {
        return Paths.get("src", "main", "java", "com", "moisesarrona", "segments");
    }
}
