package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        int a;
        int b=0;
        for (int i=0; i !=-1; i=a)
        {
            a = Integer.parseInt(reader.readLine());
            b += a;
        }
        System.out.println(b);
    }
         //напишите тут ваш код

}
