package com.moisesarrona.tool;

import java.util.List;

public interface UtilityI {

    public String readFile(String path);

    public List<String> getClassEdi(String packageName, Boolean path);

    public Object setFieldClassEdi(String packageName, String[] elements);

    public List<String> getAllClassEdi(Boolean path);

}
