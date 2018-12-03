package com.bszhang.java.learn.thread.lock.spin;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();

    public int lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
        return currentTicketNum;
    }

    public void unlock(int ticketNum) {
        serviceNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
