package org.tests.practice4predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Test1 {
    public static void main(String [] args){
        Predicate<Integer> p = i-> i>10;
        System.out.println(p.test(100));
        System.out.println(p.test(10));

        Predicate<Integer> p2 = i-> i%2== 0;
        System.out.println(p2.test(10));
        System.out.println(p2.test(9));

        System.out.println(p.and(p2).test(12));
        System.out.println(p.and(p2).test(13));

        Predicate<Integer> p3 = p.or(p2);
        System.out.println(p3.test(11));
        System.out.println(p3.test(12));
        System.out.println(p3.test(9));


        String [] arreglo = {"Fer", "", null, "Zazil", null};
        ArrayList<String> list = new ArrayList<String>();
        Predicate<String> p4 = s -> s!= null && !s.isEmpty();
        for(String s: arreglo){
            if(p4.test(s)){
                list.add(s);
            }
        }
        System.out.println(list);

        String palabra = "Fernando";
        char [] palabraArray = palabra.toCharArray();
        int tamano = palabra.length();
        for(int i=0 ; i<tamano/2;i++){
            char temp = palabraArray[i];
            palabraArray[i] = palabraArray[tamano-i-1];
            palabraArray[tamano-i-1] = temp;
        }
        System.out.println(palabraArray);
    }

}
