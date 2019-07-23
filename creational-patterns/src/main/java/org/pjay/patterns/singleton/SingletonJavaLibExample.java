package org.pjay.patterns.singleton;

/**
 * @author vijayk
 */
public class SingletonJavaLibExample {
    public static void main(String[] args) {
        Runtime oneRuntimeInstance = Runtime.getRuntime();
        oneRuntimeInstance.gc();
        System.out.println("oneRuntimeInstance :: " + oneRuntimeInstance);
        Runtime anotherRuntimeInstance = Runtime.getRuntime();
        System.out.println("anotherRuntimeInstance :: " + anotherRuntimeInstance);
        if (anotherRuntimeInstance == oneRuntimeInstance) {
            System.out.println("Both instances of runtime are same... ");
        }
    }
}
