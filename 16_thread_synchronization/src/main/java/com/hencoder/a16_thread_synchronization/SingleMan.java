package com.hencoder.a16_thread_synchronization;

class SingleMan {
    private static SingleMan ourInstance;

    private SingleMan() {
    }

    static synchronized SingleMan newInstance() {
        if (ourInstance == null) {
            synchronized (SingleMan.class) {
                if (ourInstance == null) {
                    ourInstance = new SingleMan();
                }
            }
        }
        return ourInstance;
    }
}
