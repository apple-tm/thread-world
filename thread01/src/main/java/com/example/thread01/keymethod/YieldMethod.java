package com.example.thread01.keymethod;

/**
 * Thread.yield(): 让别的线程执行，但是不确保真正让出
 */
public class YieldMethod implements Runnable {

    @Override
    public void run() {
        Thread.yield();
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new YieldMethod();
        Thread thread1 = new Thread(runnable, "top1");
        Thread thread2 = new Thread(runnable, "top2");

        thread1.start();
        thread2.start();

    }
}
