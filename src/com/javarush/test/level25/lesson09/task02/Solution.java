package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            /**
             * Method invoked when the given thread terminates due to the
             * given uncaught exception.
             * <p>Any exception thrown by this method will be ignored by the
             * Java Virtual Machine.
             *
             * @param t the thread
             * @param e the exception
             */
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String name = t.getName();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    stringBuilder.append('*');
                }
                String newName = stringBuilder.toString();
                String msg = e.getMessage().replaceAll(t.getName(),newName);
                e= new Exception(msg, e);
                System.out.println(e.getMessage());
                t.setName(newName);

            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}