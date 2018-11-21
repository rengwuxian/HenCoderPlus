package com.hencoder.a16_thread_synchronization;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Synchronized3Demo implements TestDemo {

    private int x = 0;
    private int y = 0;
    private volatile int a = 0;
    private String name;
    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private void count(int newValue) {
        writeLock.lock();
        try {
            x = newValue;
            y = newValue;
        } finally {
            writeLock.unlock();
        }
    }

    private void minus(int delta) {
        synchronized (monitor1) {
            x -= delta;
            y -= delta;
        }
    }

    private void print() {
        readLock.lock();
        try {
            System.out.println("values: " + x + ", " + y);
        } finally {
            readLock.unlock();
        }
    }

    private void setName(String newName) {
        synchronized (monitor2) {
            name = newName;
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
