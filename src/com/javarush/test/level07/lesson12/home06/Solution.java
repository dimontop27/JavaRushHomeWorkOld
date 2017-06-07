package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human gf1 = new Human("Михаил", true, 80, null, null);
        Human gf2 = new Human("Сергей", true, 90, null, null);
        Human gm1 = new Human("Наталья", false, 60, null, null);
        Human gm2 = new Human("Виктория", false, 70, null, null);
        Human father = new Human("Дмитрий", true, 40, gf1, gm1);
        Human mother = new Human("Ирина", false, 42, gf2, gm2);
        Human ch1 = new Human("Р1", true, 1, father, mother);
        Human ch2 = new Human("Р2", true, 2, father, mother);
        Human ch3 = new Human("Р3", true, 3, father, mother);



        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString()); //напишите тут ваш код
    }

    public static class Human
    {
       String name; //напишите тут ваш код
        boolean sex;
        int age;
        Human father;
        Human mother;
        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
