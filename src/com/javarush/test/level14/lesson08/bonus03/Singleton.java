package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Ариорх on 24.02.2016.
 */
public class Singleton
{

        static Singleton instance ;

        private Singleton(){}

        static Singleton getInstance(){
            if (instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }

