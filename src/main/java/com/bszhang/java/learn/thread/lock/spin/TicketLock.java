package com.bszhang.java.learn.thread.lock.spin;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    // 1
    private AtomicInteger serviceNum = new AtomicInteger();
    // 0
    private AtomicInteger ticketNum = new AtomicInteger();

    public int lock() {
        // 1
        // 2
        int currentTicketNum = ticketNum.incrementAndGet();
        // 1 != 1
        // 2 != 1
        // 2 != 2
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
        return currentTicketNum;
    }

    public void unlock(int ticketNum) {
        // 2
        serviceNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
