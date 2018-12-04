package com.bszhang.java.learn.thread.lock.spin;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLockV2 {
    // 1
    private AtomicInteger serviceNum = new AtomicInteger();
    // 0
    private AtomicInteger ticketNum = new AtomicInteger();
    private ThreadLocal<Integer> ticketNumberHolder = new ThreadLocal<Integer>();

    public void lock() {
        // 1
        // 2
        int currentTicketNum = ticketNum.incrementAndGet();
        // 1
        // 2
        ticketNumberHolder.set(currentTicketNum);
        // 1 != 1
        // 2 != 1
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
    }

    public void unlock() {
        // 2
        Integer currentTickNum = ticketNumberHolder.get();
        serviceNum.compareAndSet(currentTickNum, currentTickNum + 1);
    }
}
