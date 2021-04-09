package com.wulang.java.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {
        System.out.println(1);
        LockSupport.unpark(Thread.currentThread());
        System.out.println(2);
        LockSupport.unpark(Thread.currentThread());
        System.out.println(3);
        LockSupport.park();
        System.out.println(4);
        LockSupport.park();
        System.out.println(5);
    }
}
