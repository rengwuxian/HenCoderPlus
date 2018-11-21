package com.hencoder.a16_thread_synchronization;

public class Synchronized1Demo implements TestDemo {

    private int x = 0;
    private int y = 0;

    private synchronized void count(int newValue) {
        x = newValue;
        y = newValue;
        if (x != y) {
            System.out.println("x: " + x + ", y:" + y);
        }
    }

    @Override
    public void runTest() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }.start();
    }
}
