package com.example.thread02.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

    private final static ReentrantLock lock1 = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(
                ()->{
                    if (lock1.tryLock()) {
                        System.out.println("获得锁");
                    } else {
                        System.out.println("没有获得锁");
                        return;
                    }
                }
        ).start();

    }
}
