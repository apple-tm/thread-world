package com.example.thread01.keymethod;

public class SleepMethod2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("sleep 5000 ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
