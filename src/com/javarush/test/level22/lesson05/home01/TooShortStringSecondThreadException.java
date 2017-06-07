package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    Throwable e;

    public TooShortStringSecondThreadException(Throwable e) {
        this.e = e;
    }
}
