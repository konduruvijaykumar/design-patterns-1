package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonNotThreadSafe {
    // private static SingletonNotThreadSafe singletonNotThreadSafe = null;
    private static volatile SingletonNotThreadSafe singletonNotThreadSafe = null;

    // private SingletonNotThreadSafe() {}
    private SingletonNotThreadSafe() {
        // Avoid creating object using reflection by throwing runtime exception
        if (null != singletonNotThreadSafe) {
            throw new RuntimeException("Use getInstance() method to create object of SingletonNotThreadSafe");
        }
    }

    public static SingletonNotThreadSafe getInstance() {
        if (null == singletonNotThreadSafe) {
            singletonNotThreadSafe = new SingletonNotThreadSafe();
        }
        return singletonNotThreadSafe;
    }
}
