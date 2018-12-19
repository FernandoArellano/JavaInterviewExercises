package org.tests.practice3defaultstaticmethods;

interface Left{
    default void m1(){
        System.out.println("Left");
    }
}

interface Right{
    default void m1(){
        System.out.println("Right");
    }
}

public class Test implements Inter, Inter2{

    //own implementation
//    public void m1(){
//        System.out.println("Test class");
//    }

    //call Inter default method
    public void m1(){
        Inter.super.m1();
    }

    public static void m2(){
        System.out.println("Test m2");
    }

    public static void main(String [] args){
        Test t = new Test();
        t.m1();
        Test.m2();
        Inter.m2();
    }
}
