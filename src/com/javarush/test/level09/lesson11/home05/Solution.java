package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        // Переводим предложение в массив знаков
        char[] chars = word.toCharArray();
        // Переменная хранящая гласные
        String vowel = "";
        // Переменная хранящая other
        String other = "";
        //Проходим по массиву знаков
        for(int i = 0; i < chars.length; i++){
            // Если гласная - записываем в переменную для гласных
            if(isVowel(chars[i])){
                vowel = vowel + chars[i] + " ";
            }
            // Если пробел - продолжаем
            else if(chars[i] == ' '){
                continue;
            }
            // Все что не подошло под первые 2 правила будут записаны в переменную other
            else{
                other = other + chars[i] + " ";
            }
        }
        System.out.println(vowel);
        System.out.println(other);
    }



    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
