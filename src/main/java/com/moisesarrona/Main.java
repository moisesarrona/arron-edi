package com.moisesarrona;

import com.moisesarrona.controller.Test;
import com.moisesarrona.controller.Converter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();

        Converter converter = new Converter();

        System.out.println("Json to Object");
        System.out.println(converter.jsonFileToObject(test.getPathJson()));
        System.out.println(converter.jsonStringToObject(test.getStrJson()));

        System.out.println("Edi to Object");
        System.out.println(converter.ediFileToObject(test.getPathEdi()));

    }

}