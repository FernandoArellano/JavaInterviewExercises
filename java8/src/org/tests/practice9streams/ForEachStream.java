package org.tests.practice9streams;

import java.util.ArrayList;
import java.util.List;

public class ForEachStream {
    public static void main(String [] args){

        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        list.add(10);list.add(2);list.add(0);list.add(20);list.add(5);
        list.stream().filter(i->i>5).forEach(i-> newList.add(i));
        System.out.println(newList);

        List<String> lista = new ArrayList<>();
        List<String> newLista = new ArrayList<>();
        lista.add("Fer");lista.add("Adriana");lista.add("Mariana");lista.add("Zazil");lista.add("Lidia");
        lista.stream().filter(s-> s.length()>5).forEach(s->newLista.add(s));
        System.out.println(newLista);

        List<Student> students = new ArrayList<>();
        List<Student> newStudents = new ArrayList<>();
        students.add(new Student("Fer", 32));students.add(new Student("Zazil", 27));students.add(new Student("Eric", 30));students.add(new Student("Jesus", 28));
        students.stream().filter(s-> s.age>28).forEach(s-> newStudents.add(s));
        System.out.println(newStudents);
    }
}
