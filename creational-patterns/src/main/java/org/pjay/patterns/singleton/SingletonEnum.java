package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public enum SingletonEnum {
    INSTANCE;

    public void doStuff() {
        System.out.println("SingletonEnum Object is :: " + this);
    }
}
