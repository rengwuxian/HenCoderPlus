package com.hencoder.javatests;

public class CustomizableThreadDemo implements TestDemo {
    private CustomizableThread thread = new CustomizableThread();

    @Override
    public void runTest() {
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.looper.setTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a new task!!");
            }
        });
        thread.looper.quit();
    }

    class CustomizableThread extends Thread {
        Looper looper = new Looper();

        @Override
        public void run() {
            looper.loop();
        }
    }

    class Looper {
        private boolean quit;
        private Runnable task;

        void quit() {
            quit = true;
        }

        synchronized void setTask(Runnable newTask) {
            task = newTask;
        }

        public void loop() {
            while (!quit) {
                synchronized (this) {
                    if (task != null) {
                        task.run();
                        task = null;
                    }
                }
            }
        }
    }
}
