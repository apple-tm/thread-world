package com.example.thread02.sync;

/**
 * synchronized 是可重入锁，获得锁后调用其他同步方法无需再获得锁
 */
public class ReentrantLock implements Runnable {

    @Override
    public void run() {
        test2();
    }

    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName()+"执行了 test1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName()+"执行了 test2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(reentrantLock, "t1").start();
        reentrantLock.test1();
    }
}
