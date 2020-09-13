package com.wulang.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        reentrantLock.lock();
        try {

        }finally {
            reentrantLock.unlock();
        }
    }
}
