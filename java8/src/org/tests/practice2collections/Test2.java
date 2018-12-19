package org.tests.practice2collections;

import java.util.*;

public class Test2 {

    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(1);

        System.out.println(list);

        Collections.sort(list, (o1, o2) -> (o1>o2)?1 : (o1<o2)?-1:0);

        System.out.println(list);


        Map<Integer, String> map = new TreeMap<Integer, String>((o1,o2) -> (o1<o2)?-1: (o1>o2)?1:0);
        map.put(300,"Fer");
        map.put(600, "Mama");
        map.put(100, "Zazil");

        System.out.println(map);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(10,"Fer"));
        employees.add(new Employee(30,"Mama"));
        employees.add(new Employee(1,"Zazil"));

        Collections.sort(employees, (e1,e2) -> (e1.eno> e2.eno)?1 : (e1.eno<e2.eno)?-1:0);
        System.out.println(employees);
    }
}

class Employee{
    int eno;
    String ename;

    Employee(int eno, String ename){
        this.eno = eno;
        this.ename = ename;
    }

    @Override
    public String toString() {
        return eno +":" +ename;
    }
}

