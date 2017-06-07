package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException {
    Throwable e;

    public TooShortStringFirstThreadException(Throwable e) {
        this.e = e;
    }
}
