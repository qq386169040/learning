package com.bszhang.java.learn.thread.atomic;

import java.util.concurrent.atomic.*;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicTest test = new AtomicTest();
        test.testAtomicInteger();
        test.testAtomicIntegerArray();
        test.testAtomicReference();
        test.testAtomicIntegerFieldUpdater();
    }

    private void testAtomicInteger() {
        int temValue = 0;
        AtomicInteger i = new AtomicInteger(0);

        temValue = i.getAndSet(3);
        System.out.println("temValue:" + temValue + "; i:" + i);

        temValue = i.getAndIncrement();
        System.out.println("temValue:" + temValue + "; i:" + i);

        temValue = i.getAndDecrement();
        System.out.println("temValue:" + temValue + "; i:" + i);

        temValue = i.getAndAdd(5);
        System.out.println("temValue:" + temValue + "; i:" + i);
    }

    private void testAtomicIntegerArray() {
        int temValue = 0;
        int[] nums = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }

        temValue = i.getAndSet(0, 2);
        System.out.println("temValue:" + temValue + "; i:" + i);

        temValue = i.getAndIncrement(0);
        System.out.println("temValue:" + temValue + "; i:" + i);

        temValue = i.getAndAdd(0, 5);
        System.out.println("temValue:" + temValue + "; i:" + i);
    }

    private void testAtomicReference() {
        AtomicReference<Person> ar = new AtomicReference<Person>();
        Person person = new Person("SC", 22);
        ar.set(person);

        Person updatePerson = new Person("Daisy", 20);
        ar.compareAndSet(person, updatePerson);

        System.out.println(ar);
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private void testAtomicIntegerFieldUpdater() {
        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
        User user = new User("Java", 22);
        System.out.println(user);
        System.out.println(a.getAndIncrement(user));
        System.out.println(user);
        System.out.println(a.get(user));
        System.out.println(user);
    }


}

class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
