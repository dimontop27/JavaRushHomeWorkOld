package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSpaceBar = 0;
        int allSymols = 0;
        double result = 0;
        if (args.length > 0) {
            FileInputStream fileInput = new FileInputStream(args[0]);
            while (fileInput.available() > 0) {
                int data = fileInput.read();
                allSymols++;
                if (data == Integer.valueOf(' ')) {
                    countSpaceBar++;
                }

            }
            fileInput.close();
            result = (double) countSpaceBar / allSymols * 100;
            System.out.println(result);

        }
    }
}