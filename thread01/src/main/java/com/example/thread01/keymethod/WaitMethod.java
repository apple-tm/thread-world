package com.example.thread01.keymethod;

import java.util.Date;

/**
 * 1.wait()的作用是让当前执行 wait（）的线程进入等待状态(当前线程释放锁进入锁对象的等待池)，同时让其他线程获得锁执行。
 * 2.notify()和notifyAll()的作用，则是唤醒当前对象上的等待线程；notify()是唤醒（随机）单个线程，而notifyAll()是唤醒所有的线程
 * 3.wait(long timeout)让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的notify()方法或 notifyAll() 方法，或者超过指定的时间量”，当前线程被唤醒(进入“就绪状态”)。
 * 4.注意：线程本身作为同步锁时，a线程调用 wait 让a线程在a线程对象的等待池等待，如果没有其他线程调用a线程的 notify 释放锁，会造成死锁
 */
public class WaitMethod {

    public static void main(String[] args) {
        Thread thread1 = new Thread1("thread1");

        System.out.println("初始化thread1作为同步锁，一个线程拿到锁执行同步代码块，其他线程等待锁被释放，竞争到锁后执行:"+thread1);
        synchronized (thread1) {
            try {
                System.out.println("start线程thread1，当前线程为"+Thread.currentThread().getName());
                thread1.start();
                System.out.println(Thread.currentThread().getName()+" 线程调用thread1的wait()使当前执行线程释放锁，除当前线程开始等待其他所有线程开始竞争，"+ new Date());
                // 线程调用了对象的 wait()方法，那么线程（注意是主动调用的线程）便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。
                // wait 后当前线程（main）不会继续执行直到 锁对象 notify，注意
                thread1.wait();
                System.out.println(Thread.currentThread().getName()+" 执行同步代码块结束，"+ new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class Thread1 extends Thread {
    public Thread1(String threadName) {
        super(threadName);
    }
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Thread1开始执行 run:" + this);
            try {
//                没有线程执行当前对象的 notify 会导致死锁
                this.wait();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"调用 notify 唤醒在本线程对象上等待线程");
            // a线程调用了对象的 wait()方法，那么a线程（注意是主动调用的线程）便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。
            // 其他非 a 线程调用了对象的 notifyAll()方法（唤醒所有 wait 线程）或 notify()方法（只随机唤醒一个 wait 线程）
            // 被唤醒的的线程（锁对象的等待池中的线程）便会进入该对象的锁池中，锁池中的线程会去竞争该对象锁。
            this.notify();
        }
    }
}
