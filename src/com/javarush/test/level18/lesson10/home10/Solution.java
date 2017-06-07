package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listNames = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) {
                break;
            }
            listNames.add(s);
        }
        reader.close();

        String[] fileName = listNames.get(0).split("\\.");
        File file = new File(fileName[0] + "." + fileName[1]);
        file.createNewFile();
        ArrayList<Integer> parts = new ArrayList<>();
        for (String name : listNames) {
            String[] sName = name.split("part");
            parts.add(Integer.parseInt(sName[1]));
        }
        Collections.sort(parts);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName[0] + "." + fileName[1]));
        for (int name : parts) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName[0] + "." + fileName[1] + "." + "part" + name));
            while (bis.available() > 0) {
                bos.write(bis.read());
            }
            bis.close();
        }
    bos.close();
    }
}

