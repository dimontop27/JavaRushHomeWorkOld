package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(firstFileName);
        FileInputStream file2 = new FileInputStream(secondFileName);
        FileInputStream file3 = new FileInputStream(thirdFileName);
        while (file2.available() > 0) {
            byte[] buffer = new byte[file2.available()];
            int count = file2.read(buffer);
            file1.write(buffer, 0, count);
        }
        while (file3.available() > 0) {
            byte[] buffer = new byte[file3.available()];
            int count = file3.read(buffer);
            file1.write(buffer, 0, count);
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
