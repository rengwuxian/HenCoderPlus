package com.hencoder.a16_thread_synchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
//        thread();
//        runnable();
//        threadFactory();
//        executor();
//        callable();
        runSynchronized1Demo();
//        runSynchronized2Demo();
//        runSynchronized3Demo();
//        runReadWriteLockDemo();
//        runThreadInteractionDemo();
//        runWaitDemo();
//        runCustomizableThreadDemo();
    }

    /**
     * 使用 Thread 类来定义工作
     */
    static void thread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        };
        thread.start();
    }

    /**
     * 使用 Runnable 类来定义工作
     */
    static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void threadFactory() {
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-" + count.incrementAndGet());
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };

        Thread thread = factory.newThread(runnable);
        thread.start();
        Thread thread1 = factory.newThread(runnable);
        thread1.start();
    }

    static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }

    static void callable() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Done!";
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        try {
            String result = future.get();
            System.out.println("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static void runSynchronized1Demo() {
        new Synchronized1Demo().runTest();
    }

    static void runSynchronized2Demo() {
        new Synchronized2Demo().runTest();
    }

    static void runSynchronized3Demo() {
        new Synchronized3Demo().runTest();
    }

    static void runReadWriteLockDemo() {
        new ReadWriteLockDemo().runTest();
    }

    static void runThreadInteractionDemo() {
        new ThreadInteractionDemo().runTest();
    }

    static void runWaitDemo() {
        new WaitDemo().runTest();

    }

    static void runCustomizableThreadDemo() {
        new CustomizableThreadDemo().runTest();
    }
}
