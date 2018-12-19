package org.tests.practice6biinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Test1 {
    public static void main(String[] args){
        BiPredicate<Integer, Integer> p = (a,b) -> (a+b)%2==0;
        System.out.println(p.test(10,20));
        System.out.println(p.test(10,21));

        BiFunction<Integer, Integer, Integer> f = (a,b) -> a*b;
        System.out.println(f.apply(2,5));

        BiFunction<String, Integer, Student> f2 = (s, i) -> new Student(s,i);
        List<Student> lista = new ArrayList<Student>();
        lista.add(f2.apply("Fer", 10));
        lista.add(f2.apply("Fer2", 110));
        lista.add(f2.apply("Fer3", 101));
        lista.add(f2.apply("Fer4", 1011));
        System.out.println(lista);

    }
}

class Student{
    public String name;
    public int number;
    public Student(String name, int number){
        this.name = name;
        this.number = number;
    }
    public String toString(){
        return this.name + " : " + this.number;
    }

}
