package com.moisesarrona.controller;

import com.moisesarrona.segments.body.*;
import com.moisesarrona.segments.detail.*;
import com.moisesarrona.segments.heading.*;
import com.moisesarrona.segments.summary.*;
import com.moisesarrona.tool.Utility;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Test {

    final String pathJson = "./edi/edi.json";
    final String pathEdi = "./edi/edi.x12";

    public String getStrJson () {
        Utility utility = new Utility();
        return utility.readFile(pathJson);
    }

    public String getStrEdi () {
        Utility utility = new Utility();
        return utility.readFile(pathEdi);
    }

}
