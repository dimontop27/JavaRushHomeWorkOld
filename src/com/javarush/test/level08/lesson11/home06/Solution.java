package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gf1 = new Human("GF1", true, 45);
        Human gf2 = new Human("GF2", true, 47);
        Human gm1 = new Human("GM1", false, 147);
        Human gm2 = new Human("GM2", false, 247);
        Human f = new Human("F", true, 32);
        Human m = new Human("M", true, 31);
        Human ch1 = new Human("CH1", true, 11);
        Human ch2 = new Human("CH2", false, 12);
        Human ch3 = new Human("CH3", true, 13);
        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());
        System.out.println(f.toString());
        System.out.println(m.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());

    }

    public static class Human
    {
      String name;  //напишите тут ваш код
        boolean sex;
        int age;
        ArrayList<Human> children= new ArrayList<Human>();
        public Human (String name, boolean sex,int age){
            this.name =name;
            this.sex=sex;
            this.age=age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
