package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {

    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            String string = "";
            while (true) {
                string = (String) queue.poll();
                System.out.println(string);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
