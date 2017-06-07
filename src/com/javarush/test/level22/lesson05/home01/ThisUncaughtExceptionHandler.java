package com.javarush.test.level22.lesson05.home01;



public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return string.replaceFirst("%s", "RuntimeException")
                .replaceFirst("%s", e.getMessage())
                .replace("%s", t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return string.replaceFirst("%s", ((TooShortStringSecondThreadException) e).e.toString())
                .replaceFirst("%s", "TooShortStringSecondThreadException")
                .replace("%s", t.getName());
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return string.replaceFirst("%s", t.getName())
                .replaceFirst("%s", "TooShortStringFirstThreadException")
                .replace("%s", ((TooShortStringFirstThreadException) e).e.toString());
    }
}
