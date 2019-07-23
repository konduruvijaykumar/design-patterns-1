package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonThreadSafeDemo {
    public static void main(String[] args) {
        SingletonThreadSafe instance1 = SingletonThreadSafe.getInstance();
        System.out.println("instance1 :: " + instance1);
        SingletonThreadSafe instance2 = SingletonThreadSafe.getInstance();
        System.out.println("instance2 :: " + instance2);
        if (instance1 == instance2) {
            System.out.println("Both instances of SingletonThreadSafe are same... ");
        }
    }
}
