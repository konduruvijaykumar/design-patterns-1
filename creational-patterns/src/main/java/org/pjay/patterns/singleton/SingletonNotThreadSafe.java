package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonNotThreadSafe {
    private static SingletonNotThreadSafe singletonNotThreadSafe = null;

    private SingletonNotThreadSafe() {
    }

    public static SingletonNotThreadSafe getInstance() {
        if (null == singletonNotThreadSafe) {
            singletonNotThreadSafe = new SingletonNotThreadSafe();
        }
        return singletonNotThreadSafe;
    }
}
