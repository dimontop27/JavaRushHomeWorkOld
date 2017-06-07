package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public static void main(String[] args){
        Cat Cat1 = new Cat();
        Cat1.age = 4;
        Cat1.weight = 5;
        Cat1.strength = Cat1.age + Cat1.weight;
        Cat another1Cat = new Cat();
        another1Cat.age = 15;
        another1Cat.weight = 20;
        another1Cat.strength = another1Cat.age + another1Cat.strength;
        Cat1.fight(another1Cat);
    }

    public Cat()
    {
            }

    public boolean fight(Cat anotherCat)
    {
          //напишите тут ваш код
        return (this.strength > anotherCat.strength);
    }
}
