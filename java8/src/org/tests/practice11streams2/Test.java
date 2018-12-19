package org.tests.practice11streams2;

/**
 * Streams
 * allMatch if all elements in the string return true to the predicate, it will return true
 * anyMatch if any of the elements return true to the predicate it will return true
 * noneMatch if none of the elements in the stream return true, it will return true
 * distinct it filter all distinct elements in a collection
 * findAny return Optional of the looked element, in parallel might return different element
 * FindFirst return Optional of the looked element, in parallel it will return same as not parallel
 * flatMap
 * forEachOrdered in parallel case will execute in the order way, for each not guarantee order
 * limit will return the number of elements specified in the arg, rest of the elements in the collection are ignored
 * skip will return the elements on the collection after skip the number of elements in the arg
 * peek for debugging purposes, allows to see the temporal result of an intermediate operation
 * mapToInt
 * reduce
 * boxed (IntStream) Returns a Stream consisting of the elements of this stream, each boxed to an Integer.
 * range(from, to) (IntStream) returns the list of numbers between that collection
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String []args){
        List<String> lista = new ArrayList<>();
        lista.add("Fer");lista.add("Adriana");lista.add("Mariana");lista.add("Zazil");lista.add("Lidia");
        System.out.println(lista);
        List<Student> students = new ArrayList<>();
        students.add(new Student("Fer", 32));students.add(new Student("Zazil", 27));students.add(new Student("Eric", 30));students.add(new Student("Jesus", 28));
        System.out.println(students);
        Predicate<Student> p1 = s-> s.age>30;
        Predicate<Student> p2 = s-> s.name.startsWith("F");
        Predicate<Student> p3 = s-> s.age>15;
        Predicate<Student> p4 = s-> s.age>35;

        Stream studentsStream = students.stream();

        //allMatch
        System.out.println(students.stream().allMatch(p1));
        System.out.println(students.stream().allMatch(p2));
        System.out.println(students.stream().allMatch(p3));

        //anyMatch
        System.out.println(students.stream().anyMatch(p1));
        System.out.println(students.stream().anyMatch(p2));
        System.out.println(students.stream().anyMatch(p3));
        System.out.println(students.stream().anyMatch(p4));

        //noneMatch
        System.out.println(students.stream().noneMatch(p1));
        System.out.println(students.stream().noneMatch(p2));
        System.out.println(students.stream().noneMatch(p3));
        System.out.println(students.stream().noneMatch(p4));

        //distinct
        List<String> abclist = new ArrayList<>();
        abclist.add("A");abclist.add("A");abclist.add("A");abclist.add("B");abclist.add("B");abclist.add("C");abclist.add("C");abclist.add("D");
        System.out.println(abclist);
        System.out.println(abclist.stream().distinct().collect(Collectors.toList()));

        //findFirst findAny
        Predicate<String> p5 = s-> s.equals("A");
        System.out.println(abclist.stream().filter(p5).findFirst().get());
        System.out.println(abclist.stream().filter(p5).findAny().get());

        //foreachOrdered
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);numeros.add(0);numeros.add(1);numeros.add(5);numeros.add(2);numeros.add(4);numeros.add(3);numeros.add(9);
        numeros.stream().parallel().forEach(System.out::print);
        System.out.println();
        numeros.stream().parallel().forEachOrdered(System.out::print);
        System.out.println();

        //limit skip
        numeros.stream().limit(3).forEach(System.out::print);
        System.out.println();
        numeros.stream().skip(2).forEach(System.out::print);
        System.out.println();

        //peek
        lista.stream().filter(s-> s.length()>3).peek(System.out::println).map(s->s.toUpperCase()).forEach(System.out::println);

        //Int Stream range
        List<Integer> n = IntStream.range(1,10).boxed().collect(Collectors.toList());
        System.out.println(n);
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
