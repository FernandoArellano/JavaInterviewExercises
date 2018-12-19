package org.tests.practice9streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStream {
    public static void main(String [] args){
        List<Integer> list = new ArrayList<>();
        list.add(10);list.add(2);list.add(0);list.add(20);list.add(5);
        System.out.println(list);
        Stream<Integer> stream = list.stream();
        List<Integer> newList = stream.map(i-> i+5).collect(Collectors.toList());
        System.out.println(newList);

        List<String> lista = new ArrayList<>();
        lista.add("Fer");lista.add("Adriana");lista.add("Mariana");lista.add("Zazil");lista.add("Lidia");
        System.out.println(lista);
        List<String> newLista = lista.stream().map(s->{
            StringBuffer sb = new StringBuffer(s);
            return sb.reverse().toString();
        }).collect(Collectors.toList());
        System.out.println(newLista);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Fer", 32));students.add(new Student("Zazil", 27));students.add(new Student("Eric", 30));students.add(new Student("Jesus", 28));
        System.out.println(students);

        List<Student> newStudents = new ArrayList<>();
        newStudents = students.stream().map(e-> {
            e.name+="."; return e;
        }).collect(Collectors.toList());
        System.out.println(newStudents);

        System.out.println("Number of studends older than 30:" + students.stream().filter(e-> e.age>30).count());
    }
}

