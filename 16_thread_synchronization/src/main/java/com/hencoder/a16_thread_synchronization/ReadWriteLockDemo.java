package com.hencoder.a16_thread_synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo implements TestDemo {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    private int x = 0;

    private void count() {
        writeLock.lock();
        try {
            x++;
        } finally {
            writeLock.unlock();
        }
    }

    private void print(int time) {
        readLock.lock();
        try {
            for (int i = 0; i < time; i++) {
                System.out.print(x + " ");
            }
            System.out.println();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void runTest() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 1: " + x);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                print(1);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                print(2);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                print(3);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                print(4);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                print(5);
            }
        }.start();
    }
}
