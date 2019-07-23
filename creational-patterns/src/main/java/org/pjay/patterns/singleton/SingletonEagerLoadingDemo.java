package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonEagerLoadingDemo {
    public static void main(String[] args) {
        SingletonEagerLoading instance1 = SingletonEagerLoading.getInstance();
        System.out.println("instance1 :: " + instance1);
        SingletonEagerLoading instance2 = SingletonEagerLoading.getInstance();
        System.out.println("instance2 :: " + instance2);
        if (instance1 == instance2) {
            System.out.println("Both instances of SingletonEagerLoading are same... ");
        }
    }
}
