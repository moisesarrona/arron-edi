package com.moisesarrona;

import com.moisesarrona.controller.Converter;
import com.moisesarrona.tool.Test;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        Converter converter = new Converter();

        System.out.println("Json to Object");
        System.out.println(converter.jsonFileToObject(test.getPathJson()));
        System.out.println(converter.jsonStringToObject(test.getStrJson()));

        System.out.println("Json to EDI");
        System.out.println(converter.jsonFileToEdi(test.getPathJson(), true));
        System.out.println(converter.jsonFileToEdi(test.getStrJson(), false));

        System.out.println("Object to Json");
        System.out.println(converter.objectToJson(test.getObjectEdi()));

        System.out.println("Object to EDI");
        System.out.println(converter.objectToEdi(test.getObjectEdi()));

    }

}