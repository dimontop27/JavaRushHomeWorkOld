package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader filereader = new BufferedReader(new InputStreamReader(System.in));
        String filename = filereader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        int min = Integer.MAX_VALUE;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if (data < min)
                min = data;
        }
        System.out.println(min);
        inputStream.close();

    }
}
