package org.tests.practice3defaultstaticmethods;

public interface Inter {

    default void m1(){
        System.out.println("Default Inter");
    }

    static void m2(){
        System.out.println("Static Inter");
    }
}
