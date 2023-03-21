package com.moisesarrona.tool;

import java.util.List;

public interface UtilityI {

    public String readFile(String path);

    public List<String> getClassEdi(String packageName);

    public Object setFieldClassEdi(String packageName, String className);

    public List<String> getAllClassEdi();

}
