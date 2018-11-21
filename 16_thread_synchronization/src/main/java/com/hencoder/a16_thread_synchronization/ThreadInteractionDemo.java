package com.hencoder.javatests;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class ThreadInteractionDemo implements TestDemo {

    @Override
    public void runTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    if (Thread.interrupted()) {
                        // 收尾
                        return;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // 收尾
                        return;
                    }
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}