package org.tests.practice7primitiveinterfaces;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Test2 {
    public static void main(String [] args){

        UnaryOperator<Integer> u = i-> i*2;
        System.out.println(u.apply(3));

        IntUnaryOperator u2 = i-> i+i;
        System.out.println(u2.applyAsInt(1));

        BinaryOperator<String> o = (s1,s2) -> s1+s2;
        System.out.println(o.apply("Hola", " Fer"));

        IntBinaryOperator o2 = (i1,i2)-> i1*i2;
        System.out.println(o2.applyAsInt(5,5));
    }

}
