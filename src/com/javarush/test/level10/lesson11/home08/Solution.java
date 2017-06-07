package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList <String>[] str = new ArrayList[3];
        ArrayList<String> one = new ArrayList<String>();
        one.add("seasoi");
        ArrayList<String> two = new ArrayList<String>();
        two.add("fdfsd");
        ArrayList<String> three = new ArrayList<String>();
        three.add("fdffffsd");

        str[0]=one;
        str[1]=two;
        str[2]=three;

        return str;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}