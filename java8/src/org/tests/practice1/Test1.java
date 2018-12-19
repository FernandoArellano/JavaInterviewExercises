package org.tests.practice1;

public class Test1 {

    public static void main(String[] args){
        Inter i = (a,b) -> System.out.println("Hello: " + (a+b));
        i.test(10,20);
    }
}
