package org.tests.practice8twocolonoperator;

interface Inter{
    public void m1();
}

public class Test1 {

    public void m3(){
        System.out.println("Instance Test1 m3");
    }

    public static void m2(){
        System.out.println("Static Test1 m1");
    }

    public static void main(String [] args){

        Inter i = Test1::m2;
        i.m1();

        Test1 t = new Test1();
        i= t::m3;
        i.m1();

        i= Sample::new;
        i.m1();

    }
}

class Sample{
    public Sample(){
        System.out.println("Sample Constructor");
    }
}
