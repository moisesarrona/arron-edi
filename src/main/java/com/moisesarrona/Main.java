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



    }

}