package com.hencoder.a17_thread_interaction;

public class Main {
    public static void main(String[] args) {
//        runThreadInteractionDemo();
//        runWaitDemo();
        runCustomizableThreadDemo();
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
