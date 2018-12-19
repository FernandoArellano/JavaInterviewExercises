package org.tests.practice9streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {
    public static void main(String [] args){

        List<Integer> list = new ArrayList<>();
        list.add(10);list.add(2);list.add(0);list.add(20);list.add(5);
        System.out.println(list);
        Stream<Integer> stream = list.stream();
        List<Integer> newList = stream.filter(i->i<15).collect(Collectors.toList());
        System.out.println(newList);

        //toArray from stream
        Integer[] array = newList.stream().toArray(Integer[]::new);
        for(Integer i: array){
            System.out.println(i);

        }


        List<String> lista = new ArrayList<>();
        lista.add("Fer");lista.add("Adriana");lista.add("Mariana");lista.add("Zazil");lista.add("Lidia");
        System.out.println(lista);
        List<String> newLista = new ArrayList<>();
        newLista = lista.stream().filter(s-> s.contains("a")).collect(Collectors.toList());
        System.out.println(newLista);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Fer", 32));students.add(new Student("Zazil", 27));students.add(new Student("Eric", 30));students.add(new Student("Jesus", 28));
        System.out.println(students);

        List<Student> newStudents = new ArrayList<>();
        newStudents = students.stream().filter(e-> e.age<30).collect(Collectors.toList());
        System.out.println(newStudents);
    }
}

class Student{
    String name;
    int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return this.name + " : " + this.age;
    }
}
