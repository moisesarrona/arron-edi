package com.moisesarrona.tool;

import java.nio.file.Path;
import java.util.Set;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface UtilityI {

    public String readFile(String path);

    public Set<String> getPackages(Path path);

    public List<String> getClassEdi(String packageName, Boolean includePath);

}
