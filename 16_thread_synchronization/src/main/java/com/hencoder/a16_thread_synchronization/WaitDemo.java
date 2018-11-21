package com.hencoder.javatests;

public class WaitDemo implements TestDemo {
    private String sharedString;

    private synchronized void initString() {
        sharedString = "Rengwuxian!";
        notifyAll();
    }

    private synchronized void printString() {
        while (sharedString == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("String: " + sharedString);
    }

    @Override
    public void runTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printString();
            }
        };
        thread.start();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initString();
                Thread.yield();
            }
        };
        thread1.start();
    }
}