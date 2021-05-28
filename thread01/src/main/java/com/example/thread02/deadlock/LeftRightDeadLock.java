package com.example.thread02.deadlock;

public class LeftRightDeadLock {

    public final Object left = new Object();
    public final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (right) {
                System.out.println("leftRight");
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (left) {
                System.out.println("rightLeft");
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock();
        new Thread(() -> {
            leftRightDeadLock.leftRight();
        }).start();
        new Thread(() -> {
            leftRightDeadLock.rightLeft();
        }).start();
    }
}
