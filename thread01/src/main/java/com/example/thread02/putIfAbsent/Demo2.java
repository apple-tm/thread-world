package com.example.thread02.putIfAbsent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @param <E>
 */
public class Demo2<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    /**
     * list 属于共享变量（已被加锁）
     * 但是集合的同步锁和 putIfAbsent 的锁不一定是同一把，list 的实现方法可能不使用内置锁 this，而使用客户端锁
     *
     * @param x
     * @return
     */
    public  boolean putIfAbsent(E x) {
        synchronized(list) {
            boolean absent = list.contains(x);
            if (!absent) list.add(x);
            return absent;
        }

    }
}
