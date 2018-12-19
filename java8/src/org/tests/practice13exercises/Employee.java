package org.tests.practice13exercises;

public class Employee implements Comparable<Employee> {
    public int age;
    public int eno;
    public String name;

    public Employee(int age, int eno, String name){
        this.age = age;
        this.eno = eno;
        this.name = name;
    }

    public String toString(){
        return this.name + ": " +this.age + " : " + this.eno;
    }

    @Override
    public int compareTo(Employee o) {
        return this.eno - o.eno;
    }
}
