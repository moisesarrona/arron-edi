package com.moisesarrona.tool;

import java.util.List;

public interface UtilityI {

    public String readFile(String path);

    public List<String> getClassEdi(String packageName, Boolean path);

    public List<String> getAllClassEdi(Boolean path);

    public List<String> getAllPackages();

    public Object setFieldClassEdi(String packageName, String[] elements);


}
