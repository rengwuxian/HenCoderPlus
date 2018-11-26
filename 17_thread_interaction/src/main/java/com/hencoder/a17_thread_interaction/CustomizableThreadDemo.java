package com.hencoder.a17_thread_interaction;

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
                System.out.println("hahahahaha");
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.looper.quit();
    }

    class CustomizableThread extends Thread {
        Looper looper = new Looper();
    }

    class Looper {
        private Runnable task;
        private boolean quit;

        synchronized void setTask(Runnable task) {
            this.task = task;
        }

        synchronized void quit() {
            quit = true;
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
