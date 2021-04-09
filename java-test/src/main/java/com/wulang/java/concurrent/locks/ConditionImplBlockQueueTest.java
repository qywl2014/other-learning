package com.wulang.java.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionImplBlockQueueTest {
    public static void main(String[] args) throws Exception {
        System.out.println("start...");
        MyBlockQueue myBlockQueue = new MyBlockQueue(3);

        new Thread(()->{
            try {
                Thread.sleep(5000);
                System.out.println(myBlockQueue.take());
                System.out.println(myBlockQueue.take());
                System.out.println(myBlockQueue.take());
                System.out.println(myBlockQueue.take());

                System.out.println(myBlockQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        myBlockQueue.put("1");
        System.out.println("put 1 success");
        myBlockQueue.put("2");
        System.out.println("put 2 success");
        myBlockQueue.put("3");
        System.out.println("put 3 success");
        myBlockQueue.put("4");
        System.out.println("put 4 success");

        new Thread(()->{
            try {
                Thread.sleep(10000);
                myBlockQueue.put("5");
                System.out.println("put 5 success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class MyBlockQueue {
        private Lock lock = new ReentrantLock();
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();
        private Object[] items;
        private int putIndex = 0;
        private int takeIndex = 0;
        private int size = 0;

        public MyBlockQueue(int size) {
            items = new Object[size];
        }

        public void put(Object o) throws InterruptedException {
            lock.lock();
            try {
                if (size == items.length) {
                    notFull.await();
                }
                items[putIndex] = o;
                putIndex++;
                putIndex = putIndex % items.length;
                size++;
                if (size == 1) {
                    notEmpty.signal();//java doc demo 每次都进行signal
                }
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                if (size == 0) {
                    notEmpty.await();
                }
                Object o = items[takeIndex];
                takeIndex++;
                takeIndex = takeIndex % items.length;
                size--;
                if (size == items.length - 1) {
                    notFull.signal();//java doc demo 每次都进行signal
                }
                return o;
            } finally {
                lock.unlock();
            }
        }
    }
}
