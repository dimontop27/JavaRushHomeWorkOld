package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }
    public static int max (int a, int b){
        if (a>b) {return a;    }
        return b;}
    public static long max (long c, long d){if (c>d){return c;}return d; }
    public static double max (double e, double f) {if (e>f){return e;}return f;}

    //Напишите тут ваши методы
}
