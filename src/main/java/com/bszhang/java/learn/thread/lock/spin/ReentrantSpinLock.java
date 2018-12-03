package com.bszhang.java.learn.thread.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

public class ReentrantSpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    private int count;
    public void lock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) {
            count ++;
            return;
        }
        while (!cas.compareAndSet(null, current)) {
            // Do nothing
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) {
            if (count > 0) {
                count --;
            } else {
                cas.compareAndSet(current, null);
            }
        }
    }
}
