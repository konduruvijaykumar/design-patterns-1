package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonEnumDemo {
    public static void main(String[] args) {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        instance1.doStuff();
        System.out.println("instance1 :: " + instance1);
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        instance2.doStuff();
        System.out.println("instance2 :: " + instance2);
        if (instance1 == instance2) {
            System.out.println("Both instances of SingletonEnum are same... ");
        }
    }
}
