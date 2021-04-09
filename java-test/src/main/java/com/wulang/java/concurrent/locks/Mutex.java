package com.wulang.java.concurrent.locks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Here is a non-reentrant mutual exclusion lock class that
 * uses the value zero to represent the unlocked state,
 * and one to represent the locked state.
 * While a non-reentrant lock does not strictly require recording of the current owner thread,
 * this class does so anyway to make usage easier to monitor.
 * It also supports conditions and exposes one of the instrumentation methods
 */
public class Mutex implements Lock, java.io.Serializable {

    public static void main(String[] args) throws Exception {
        conditionTest();
    }

    private static void conditionTest(){
        Mutex lock = new Mutex();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                condition.signal();
                System.out.println("1");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        lock.lock();
        try {
            System.out.println("2 before");
            condition.await();
            System.out.println("2 after");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void testOrder(){
        Mutex lock = new Mutex();
        createThread(lock,1);
        createThread(lock,2);
        createThread(lock,3);
        createThread(lock,4);
        createThread(lock,5);
        createThread(lock,6);
        createThread(lock,7);

        lock.lock();
        try {
            Thread.sleep(8000);
            System.out.println("0");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void createThread(Lock lock, int second) {
        new Thread(() -> {
            try {
                Thread.sleep(second * 1000);
                lock.lock();
                System.out.println(second);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    // Our internal helper class
    private static class Sync extends MyAQS {
        // Reports whether in locked state
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // Acquires the lock if state is zero
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // Releases the lock by setting state to zero
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition() {
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    // The sync object does all the hard work. We just forward to it.
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
