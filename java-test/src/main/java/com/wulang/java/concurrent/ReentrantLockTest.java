package com.wulang.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        reentrantLock.lock();
        try {

        }finally {
            reentrantLock.unlock();
        }
    }
}
