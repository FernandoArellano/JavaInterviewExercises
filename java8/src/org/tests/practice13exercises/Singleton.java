package org.tests.practice13exercises;

public class Singleton {

    private static final Singleton singleton;

    static{
        singleton = new Singleton();
    }

    private Singleton(){
    }

    public static Singleton getSingleton(){
        return singleton;
    }
}
