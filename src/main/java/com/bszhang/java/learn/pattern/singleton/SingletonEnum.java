package com.bszhang.java.learn.pattern.singleton;

public enum SingletonEnum {
    SINGLETON_ENUM;
    private String key = "key";
    private String value = "value";

    public void doSomething() {
        System.out.println(key + ": " + value);
    }

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.SINGLETON_ENUM;
        instance.doSomething();
    }
}
