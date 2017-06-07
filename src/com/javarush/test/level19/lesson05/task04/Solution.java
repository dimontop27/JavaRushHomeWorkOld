package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
       reader.close();
        BufferedReader in = new BufferedReader(new FileReader(filename1));
        BufferedWriter out = new BufferedWriter(new FileWriter(filename2));


        while (in.ready()){
            String str = in.readLine();
            str = str.replace(".", "!");
            out.write(str);

        }
        in.close();
        out.close();
    }
}
