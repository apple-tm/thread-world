package com.example.thread02.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 1.支持非公平锁（默认）和公平锁（相对公平）
 * 2.读锁共享临界区（共享资源）、写锁互斥
 */
public class ReentrantReadWriteLockDemo1 {

    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void test1() {
        // 写锁
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        // 读锁
        ReentrantReadWriteLock.ReadLock readLock =  reentrantReadWriteLock.readLock();
        try {
            writeLock.lock();
            readLock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            readLock.unlock();
        }
    }
}
