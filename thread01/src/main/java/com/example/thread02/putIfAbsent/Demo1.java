package com.example.thread02.putIfAbsent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @param <E>
 */
public class Demo1<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    /**
     * list 属于共享变量（已被加锁）
     * 但是集合的同步锁和 putIfAbsent 的锁不是同一把，操作时，各自独立，该方法对 list 不具有原子性
     * @param x
     * @return
     */
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = list.contains(x);
        if (!absent) list.add(x);
        return absent;
    }
}
