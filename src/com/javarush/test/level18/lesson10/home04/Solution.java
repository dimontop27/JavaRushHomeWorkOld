package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fileBuffer = new FileInputStream(fileName1);
        byte[] buffer = new byte[fileBuffer.available()];
        int data = 0;
        while (fileBuffer.available() > 0) {
            data = fileBuffer.read(buffer);
        }
        fileBuffer.close();

        FileInputStream file2 = new FileInputStream(fileName2);
        FileOutputStream file1 = new FileOutputStream(fileName1);
        while (file2.available() > 0) {
            byte[] file2Buffer = new byte[file2.available()];
            int cont = file2.read(file2Buffer);
            file1.write(file2Buffer, 0, cont);
            file1.write(buffer, 0, data);
        }
        reader.close();
        file1.close();
        file2.close();
    }
}
