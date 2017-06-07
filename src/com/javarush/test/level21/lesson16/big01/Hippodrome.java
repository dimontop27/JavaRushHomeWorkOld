package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    public static Hippodrome game;
    public static ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        game.horses.add(new Horse("Lucky", 3, 0));
        game.horses.add(new Horse("Spirit", 3, 0));
        game.horses.add(new Horse("Desteny", 3, 0));

        game.run();
        game.printWinner();

    }
    public Horse getWinner() {
        int indexOfHorseMaxDist = 0;
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > horses.get(indexOfHorseMaxDist).getDistance())
                indexOfHorseMaxDist = i;
        }
        return horses.get(indexOfHorseMaxDist);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
            System.out.println();
            System.out.println();
        }

    }


}