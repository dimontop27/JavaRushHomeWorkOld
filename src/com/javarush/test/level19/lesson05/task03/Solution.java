package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
 /*       String filename1 = reader1.readLine();
       String filename2 = reader1.readLine();
        FileReader reader = new FileReader("F:\\2.txt");
        FileWriter writer = new FileWriter("D:\\1.txt");
        List<Character> list = new ArrayList<>();

        char ch = 0;
        while (reader.ready()) {
            ch = (char) reader.read();
            list.add(ch);
        }
        for (Character s : list) {
            if (Character.isDigit(s))
                writer.write((int) s+ " ");
        }

        reader.close();
        reader.close();
        writer.close();
    }*/
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new FileReader(sc.nextLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(sc.nextLine()));
        sc.close();
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = in.readLine()) != null)
            sb.append(s + " ");
        in.close();
        String[] words = sb.toString().split(" ");
        for (String str: words) {
            try {
                Integer.parseInt(str);
                out.write(str + " ");
            } catch (NumberFormatException e) {}
        }
        out.close();
    }
}
