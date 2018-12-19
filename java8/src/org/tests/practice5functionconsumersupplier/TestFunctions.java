package org.tests.practice5functionconsumersupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestFunctions {

    public static void main(String [] args){

        Function<String, Integer> f = s-> s.length();
        System.out.println(f.apply("Fernando"));

        Function<Integer, Integer> f2 = i-> i*i;
        System.out.println(f2.apply(15));

        Function<String, String> f3= s-> s.replaceAll(" ", "");
        System.out.println(f3.apply("Soy un buen programador"));

        Function<String, Integer> f4 = s-> s.length() - s.replaceAll(" ", "").length();
        System.out.println(f4.apply("Soy un buen programador je je"));

        List<Employee> list = new ArrayList<Employee>();
        populateList(list);

        System.out.println(list);

        Function<List<Employee>, Double> f5 = l-> {
            double salary=0;
            for(Employee e: l){
                salary += e.salary;
            }
            return salary;
        };
        System.out.println(f5.apply(list));

        Predicate<Employee> p = e-> e.salary<20000;

        Function<Employee, Employee> f6 = e-> {
            if(p.test(e)){
                e.salary += +477;
            }
            return e;
        };
        for(Employee e :  list){
            f6.apply(e);
        }

        System.out.println(list);

        Function<String, String> f7 = s-> s.toUpperCase();
        Function<String, String> f8 = s-> s.substring(0,8);

        Function f9 = f7.andThen(f8);

        System.out.println(f9.apply("Parangaricutirimicuaro"));

    }

    private static void populateList(List<Employee> list) {
        list.add(new Employee("Fer", 15000));
        list.add(new Employee("Fer2", 10000));
        list.add(new Employee("Fer3", 5000));
        list.add(new Employee("Fer4", 35000));
        list.add(new Employee("Fer5", 50000));
    }
}

class Employee{
    String name;
    double salary;
    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String toString(){
        return this.name + " : " + this.salary;
    }
}
