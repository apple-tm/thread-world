package com.example.thread02.sync;

public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行了");
    }
}
