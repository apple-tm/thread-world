package com.example.thread02.sync;

/**
 * 测试对象锁的唯一性
 *
 * 1.test1 test2 方法加锁，test1 test2 没法并发执行
 * 2.test1 test2 方法不加锁，test1 test2 可以并发执行
 * 3.证明加锁的对象：唯一内置锁的正确性
 * 4.说明不同线程只能异步访问内置加锁方法，并且不同线程也不能并发访问不同的加锁方法
 * 5.使用不同对象的锁会并发，说明 synchronzied 修饰普通方法是使用的对象内置锁（一个对象一个，多个对象多个锁，所以多个线程获得多个不同的锁可以并发）
 * 6.static 方法被 synchronized 修饰，应为类锁是所有对象就有一个，不能并发
 */
public class SynchronziedLock implements Runnable {

    @Override
    public void run() {
        test1();
        test2();
    }

    public static synchronized void test1() {
        System.out.println(Thread.currentThread().getName()+"执行了 test1");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void test2() {
        System.out.println(Thread.currentThread().getName()+"执行了 test2");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronziedLock synchronziedLock = new SynchronziedLock();
        SynchronziedLock synchronziedLock2 = new SynchronziedLock();

        Thread t1 = new Thread(synchronziedLock, "t1");
        Thread t2 = new Thread(synchronziedLock2, "t2");
        t1.start();
        t2.start();
    }
}
