package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;


/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(reader.readLine());
        reader.close();
        load(fileProperties);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        if(props.size()>0)
            props.putAll(properties);
        props.store(outputStream, "");
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
     //   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        props.load(inputStream);
        for (String s : props.stringPropertyNames())
            properties.put(s, props.getProperty(s));
    }
}
