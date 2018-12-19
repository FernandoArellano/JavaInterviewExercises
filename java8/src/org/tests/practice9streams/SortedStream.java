package org.tests.practice9streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStream {
    public static void main(String [] args){

        List<Integer> list = new ArrayList<>();
        list.add(10);list.add(2);list.add(0);list.add(20);list.add(5);
        System.out.println(list);
        List<Integer> newList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(newList);
        List<Integer> uoList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(uoList);

        List<String> lista = new ArrayList<>();
        lista.add("Fer");lista.add("Adriana");lista.add("Mariana");lista.add("Zazil");lista.add("Lidia");
        System.out.println(lista);
        List<String> newLista = lista.stream().sorted().collect(Collectors.toList());
        System.out.println(newLista);
        List<String> uoLista = lista.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(uoLista);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Fer", 32));students.add(new Student("Zazil", 27));students.add(new Student("Eric", 30));students.add(new Student("Jesus", 28));
        System.out.println(students);

        List<Student> newStudents = students.stream().sorted((s1,s2)-> s2.name.compareTo(s1.name)).collect(Collectors.toList());
        System.out.println(newStudents);

        List<Student> uoStudents = students.stream().sorted((s1,s2)->s2.age-s1.age).collect(Collectors.toList());
        System.out.println(uoStudents);

        System.out.println("Min Value: " + students.stream().min((s1,s2)-> s1.name.compareTo(s2.name)).get());
        System.out.println("Max Value " + students.stream().max((s1,s2)-> s1.age - s2.age).get());
    }
}
