package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonNotThreadSafeDemo {
    public static void main(String[] args) {
        SingletonNotThreadSafe instance1 = SingletonNotThreadSafe.getInstance();
        System.out.println("instance1 :: " + instance1);
        SingletonNotThreadSafe instance2 = SingletonNotThreadSafe.getInstance();
        System.out.println("instance2 :: " + instance2);
        if (instance1 == instance2) {
            System.out.println("Both instances of SingletonNotThreadSafe are same... ");
        }
    }
}
