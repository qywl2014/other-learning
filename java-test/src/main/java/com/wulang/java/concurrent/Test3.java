package com.wulang.java.concurrent;

import java.lang.ref.WeakReference;

public class Test3 {
    private static Object lock = new Object();

    public static void main(String[] args) {
        new WeakReference<>(new Object());
        synchronized (lock) {
            int a = 2 + 3;
            System.out.println(a);
        }
        new Test3().add();
    }

    private synchronized void add() {
        System.out.println(1);
    }
}
