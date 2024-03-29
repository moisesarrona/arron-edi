package com.moisesarrona.arronedi;

import com.moisesarrona.arronedi.controller.Converter;
import com.moisesarrona.arronedi.tool.Test;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        Converter converter = new Converter();

        /* --- Json --- */
        System.out.println("--- Json ---");
        System.out.println("Json to Object");
        System.out.println(converter.jsonFileToObject(test.getPathJson()));
        System.out.println(converter.jsonStringToObject(test.getStrJson()));

        System.out.println("Json to EDI");
        System.out.println(converter.jsonToEdi(test.getPathJson(), true));
        System.out.println(converter.jsonToEdi(test.getStrJson(), false));

        /* --- Object --- */
        System.out.println();
        System.out.println("--- Object ---");
        System.out.println("Object to Json");
        System.out.println(converter.objectToJson(test.getObjectEdi()));

        System.out.println("Object to EDI");
        System.out.println(converter.objectToEdi(test.getObjectEdi()));

    }
    
}