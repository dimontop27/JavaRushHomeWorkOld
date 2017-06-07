package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private String color;
    private int toll;

    public Dog(String name)
    {
        this.name = name;
    }

    public Dog (String name, int toll)
    {
        this.name = name;
        this.toll = toll;
    }

    public Dog(String name, int toll, String color)
    {
        this.name = name;
        this.toll = toll;
        this.color = color;
    }
}