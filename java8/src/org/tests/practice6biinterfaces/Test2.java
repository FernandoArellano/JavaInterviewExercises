package org.tests.practice6biinterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Test2 {

    public static void main(String [] args){
        BiFunction<Employee, Timesheet, Double> f = (e, t) -> e.salary*t.workedDays;

        Employee e = new Employee("Fer", 10, 300.00);
        Timesheet t = new Timesheet(10, 22);

        System.out.println(f.apply(e,t));

        System.out.println(e);
        BiConsumer<Employee, Double> c = (em,d) -> e.salary = e.salary + d;
        c.accept(e, 4010.00);
        System.out.println(e);

    }
}

class Employee{
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public String toString(){
        return this.name + " : " + this.salary;
    }
}

class Timesheet{
    int id;
    int workedDays;
    public Timesheet(int id, int workedDays){
        this.id = id;
        this.workedDays = workedDays;
    }
}
