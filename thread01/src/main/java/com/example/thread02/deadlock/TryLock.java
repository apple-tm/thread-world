package com.example.thread02.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

    private final static ReentrantLock lock1 = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(
                ()->{
                    if (lock1.tryLock()) {
                        System.out.println(Thread.currentThread().getName()+"获得锁");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()+"没有获得锁");
                        return;
                    }
                }
        , "t1").start();

        new Thread(
                ()->{
                    if (lock1.tryLock()) {
                        System.out.println(Thread.currentThread().getName()+"获得锁");
                    } else {
                        System.out.println(Thread.currentThread().getName()+"没有获得锁");
                        return;
                    }
                }
        ,"t2").start();

    }
}
