package org.tests.practice5functionconsumersupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestConsumer {
    public static void main(String [] args){
        Consumer<String> c = s-> System.out.println(s);
        c.accept("Hello Fer");

        List<Student> list = new ArrayList<Student>();
        populate(list);
        Predicate<Student> p = s-> s.marks>60;
        Consumer<List<Student>> c2 = l-> {
          for(Student s: l){
              if(p.test(s)) {
                  System.out.println(s);
              }
          }
        };
        c2.accept(list);
    }

    public static void populate(List<Student> l){
        l.add(new Student("Fer", 60));
        l.add(new Student("Fer2", 8));
        l.add(new Student("Fer3", 90));
        l.add(new Student("Fer4", 100));
        l.add(new Student("Fer5", 40));
        l.add(new Student("Fer6", 50));

    }
}

class Student{
    public String name;
    public int marks;
    public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public String toString(){
        return this.name + " : " + this.marks;
    }
}
