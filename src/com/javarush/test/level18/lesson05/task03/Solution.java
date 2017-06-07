package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();

        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);
        FileOutputStream file3 = new FileOutputStream(name3);

        int secondFileLength;
        while (file1.available() > 0) {
            if (file1.available() % 2 == 0) {
                secondFileLength = file1.available() / 2;
            }
            else
                secondFileLength = file1.available() /2+1;
            byte[] secondBuffer = new byte[secondFileLength];
            byte[] thirdBuffer = new byte[file1.available()/2];

            file2.write(secondBuffer, 0, file1.read(secondBuffer));
            file3.write(thirdBuffer, 0, file1.read(thirdBuffer));
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();

    }
}
