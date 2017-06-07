package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        BufferedReader filereader = new BufferedReader(new FileReader(fn));
        ArrayList<Integer> list = new ArrayList<>();
        String num;
        while ((num = filereader.readLine()) != null)
        {
            list.add(Integer.parseInt(num));
        }
        Collections.sort(list);
        for (Integer even : list)
        {
            if (even % 2 == 0)
            {
                System.out.println(even);
            }


        }
    }
}
