package com.example.thread02.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * 1.支持非公平锁（默认）和公平锁（相对公平）
 * 2.互斥锁
 */
public class ReentrantLockDemo1 {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void test1() {
        reentrantLock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
