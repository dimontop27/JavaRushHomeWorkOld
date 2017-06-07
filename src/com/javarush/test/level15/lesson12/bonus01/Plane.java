package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Ариорх on 27.02.2016.
 */
public class Plane implements Flyable
{
   public int passangers =5;

    public Plane(int passangers) {
        this.passangers = passangers;
    }
    @Override
    public void fly()
    {

    }
}
