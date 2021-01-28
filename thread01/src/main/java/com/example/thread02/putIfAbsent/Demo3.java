package com.example.thread02.putIfAbsent;

import java.util.*;

/**
 *装饰器模式(增强)
 *
 * 1.和原需增强类实现相同接口
 * 2.增强类定义需增强类的引用、构造函数传入一个需增强类的对象赋值给需增强类的引用
 * 3.
 * */
public class Demo3<T> implements List<T> {

    private final List<T> list;

    public static void main(String[] args) {
        Demo3<String> demo3 = new Demo3(new ArrayList());
        boolean b1 = demo3.putIfAbsent("abc");
        boolean b2 = demo3.putIfAbsent("abc");

        System.out.println(b1);
        System.out.println(b2);
    }

    public Demo3(List<T> list) {
        this.list = list;
    }

    /**
     *
     * @param t
     * @return true 代表获得设置成功（不存在就 add，返回 true 代表该标识在 list 中首次插入成功了，这样 list 具有去重的功能了）
     */
    public synchronized boolean putIfAbsent(T t) {
        boolean absent = list.contains(t);
        if (!absent) list.add(t);
        return !absent;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
