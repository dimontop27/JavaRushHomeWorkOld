package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream firstFile = new FileInputStream(reader.readLine());
        FileOutputStream secondFile = new FileOutputStream(reader.readLine());
        while (firstFile.available() > 0) {
            byte[] buffer = new byte[firstFile.available()];
            firstFile.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--)
                secondFile.write(buffer[i]);
        }
        /*byte[]bufer = new byte[firstFile.available()];   решение
        for (int i = firstFile.read(bufer); i>0; i--)
            secondFile.write(bufer[i-1]);
        reader.close();
        firstFile.close();
        secondFile.close();*/
    }
}
