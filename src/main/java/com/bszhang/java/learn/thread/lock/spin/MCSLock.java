package com.bszhang.java.learn.thread.lock.spin;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class MCSLock {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isLocked = true;
    }

    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<MCSNode>();

    private volatile MCSNode queue;

    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "queue");

    public void lock() {
        MCSNode currentNode = new MCSNode();
        NODE.set(currentNode);
        MCSNode preNode = UPDATER.getAndSet(this, currentNode);
        if (preNode != null) {
            preNode.next = currentNode;
            while (currentNode.isLocked) {
            }
        }
    }

    public void unlock() {
        MCSNode currentNode = NODE.get();
        if (currentNode.next == null) {
            if (UPDATER.compareAndSet(this, currentNode, null)) {
                return;
            } else {
                while (currentNode.next == null) {
                }
            }
        } else {
            currentNode.next.isLocked = false;
            currentNode.next = null;
        }
    }
}
