package com.javarush.test.level25.lesson05.home01;



public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        setDaemon(true);
        this.target = target;
    }
    public void run(){
        State state = target.getState();
        System.out.println(state);
        while(state != state.TERMINATED){
            if(state != target.getState()){
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
