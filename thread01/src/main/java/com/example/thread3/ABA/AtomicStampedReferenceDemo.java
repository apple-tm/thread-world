package com.example.thread3.ABA;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA （AB 同时删除节点，但是删除的不是同一个对象）
 * 1.线程 A 删除了节点 x
 * 2.线程 C 在节点 X 原地址上新增了 节点 Y
 * 3.线程 B 删除了节点 X ，其实删除了节点 Y，导致逻辑问题
 */
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<Integer> asr = new AtomicStampedReference(10,1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号："+stamp);

            boolean b1 = asr.compareAndSet(10, 11, asr.getStamp(), asr.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+b1+"第二次版本号："+asr.getStamp());

            boolean b2 = asr.compareAndSet(11, 10, asr.getStamp(), asr.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+b2+"第三次版本号："+asr.getStamp());
        }, "t1").start();

        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号："+stamp);
            boolean b3 = asr.compareAndSet(10, 12, asr.getStamp(), asr.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+b3+"是否修改成功：当前版本号"+asr.getStamp());
            System.out.println(Thread.currentThread().getName()+"实际值："+asr.getReference());
        }, "t2").start();
    }
}
