package com.bszhang.java.learn.pattern.singleton;

public class Singleton {

    private static Singleton starveInstance = new Singleton();

    private static Singleton syncInstance;

    private volatile static Singleton doubleCheckLockInstance;

    private Singleton() {

    }

    // synchronized
    public synchronized static Singleton getSyncInstance() {
        if (syncInstance == null) {
            syncInstance = new Singleton();
        }
        return syncInstance;
    }

    // double check
    public static Singleton getDoubleCheckLockInstanceInstance() {
        if (doubleCheckLockInstance == null) {
            synchronized (Singleton.class) {
                if (doubleCheckLockInstance == null) {
                    doubleCheckLockInstance = new Singleton();
                }
            }
        }
        return doubleCheckLockInstance;
    }

    public static Singleton getInnerClassInstantce() {
        return InnerClass.innerInstance;
    }

    private static class InnerClass {
        private static final Singleton innerInstance = new Singleton();
    }

    public enum SingleEnum {
        INSTANCE;
        public void singleOperation() {

        }
    }
}
