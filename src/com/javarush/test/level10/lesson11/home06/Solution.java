package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        int height;
        int weight;
        String name;
        int age;
        String surname;
        String middlename;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, String surname)
        {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, String middlename)
        {
            this.name = name;
            this.surname = surname;
            this.middlename = middlename;
        }

        public Human(String name, String surname, String middlename, int height, int weight, int age)
        {
            this.name = name;
            this.surname = surname;
            this.middlename = middlename;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String surname, String middlename, int height, int weight)
        {
            this.name = name;
            this.surname = surname;
            this.middlename = middlename;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String surname, String middlename, int height)
        {
            this.name = name;
            this.surname = surname;
            this.middlename = middlename;
            this.height = height;
        }

        public Human(String name, String surname, int age)
        {
            this.name = name;
            this.surname = surname;

            this.age = age;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;

        }

        public Human(String name,  int height, int weight, int age)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human( String surname, String middlename, int height, int weight, int age)
        {

            this.surname = surname;
            this.middlename = middlename;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
    }
}
