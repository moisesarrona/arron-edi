package com.moisesarrona;

import com.moisesarrona.controller.Test;
import com.moisesarrona.controller.Converter;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        Converter converter = new Converter();

        System.out.println("Json to Object");
        System.out.println(converter.jsonFileToObject(test.getPathJson()));
        System.out.println(converter.jsonStringToObject(test.getStrJson()));

        System.out.println("Json to EDI");
        System.out.println(converter.jsonFileToEdi(test.getPathJson()));
        //System.out.println(converter.jsonStringToEdi(test.getStrEdi()));

        //System.out.println("Object to Json");
        //System.out.println(converter.objectToJson(test.getObjectEdi()));


        //System.out.println("Edi to Object");
        //System.out.println(converter.ediFileToObject(test.getPathEdi()));

    }

}