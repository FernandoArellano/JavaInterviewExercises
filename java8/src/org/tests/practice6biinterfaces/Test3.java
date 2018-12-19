package org.tests.practice6biinterfaces;

import java.util.function.BiConsumer;

public class Test3 {
    public static void main(String[] args){
        BiConsumer<String, String> consumer = (s1,s2) -> System.out.println(s1+s2);
        consumer.accept("Hola ", "Fer");
    }
}
