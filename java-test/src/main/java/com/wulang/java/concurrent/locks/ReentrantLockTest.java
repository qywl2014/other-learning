package com.wulang.java.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {
        signalIfNeedLockTest();
    }

    private static void signalIfNeedLockTest(){
        new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println("before await");
                condition.await();
                System.out.println("after await");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            reentrantLock.lock();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        condition.signal();
    }
}
