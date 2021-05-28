package com.example.thread3.ABA;

import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {

    private static AtomicInteger index = new AtomicInteger(10);

    public static void main(String[] args) {
        new Thread(() -> {
            boolean b1 = index.compareAndSet(10,11);
            System.out.println(Thread.currentThread().getName()+"b1:"+b1+":"+index.get());
            boolean b2 = index.compareAndSet(11,10);
            System.out.println(Thread.currentThread().getName()+"b2:"+b2+":"+index.get());
        }, "t1").start();

        new Thread(() -> {
            boolean b3 = index.compareAndSet(10,12);
            System.out.println(Thread.currentThread().getName()+"b3:"+b3+":"+index.get());
        }, "t2").start();
    }
}
