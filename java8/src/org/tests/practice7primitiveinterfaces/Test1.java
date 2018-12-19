package org.tests.practice7primitiveinterfaces;

import java.util.Date;
import java.util.function.*;

public class Test1 {
    public static void main(String [] args){
        IntPredicate p = i->i%2==0;
        System.out.println(p.test(10));
        System.out.println(p.test(11));

        LongPredicate p2 = i -> Math.sqrt(i)>10;
        System.out.println(p2.test((long) 2.0000));
        System.out.println(p2.test((long) 25555.0000));

        DoublePredicate p3 = d -> d>10;
        System.out.println(p3.test(23.34));
        System.out.println(p3.test(3.3));

        IntFunction<Integer> f1 = i-> i*2;
        System.out.println(f1.apply(4));

        DoubleFunction<String> f2 = d-> {
            String r="No";
            if(d>10){
                r="Big Number";}return r;};
        System.out.println(f2.apply(3.4));
        System.out.println(f2.apply(13.4));

        LongFunction<String> f3 = d-> "Number: " + d;
        System.out.println(f3.apply(50));

        ToDoubleFunction<Integer> f5 = i-> i+.04;
        System.out.println(f5.applyAsDouble(5));

        ToLongFunction<Integer> f6 = i-> (long)Math.random()*i;
        System.out.println(f6.applyAsLong(5));

        IntToDoubleFunction f4 = i-> Math.sqrt(i);
        System.out.println(f4.applyAsDouble(4));

        BiFunction<Integer,Integer,Integer> f7 = (i,j)-> i+j;
        System.out.println(f7.apply(5,2));

        ToDoubleBiFunction<Integer,Integer> f8 = (a,b)-> Math.sqrt(a+b);
        System.out.println(f8.applyAsDouble(5,1));

        IntConsumer c = i-> System.out.println(i);
        c.accept(3);

        ObjIntConsumer<Date> c2 = (o,i)->System.out.println(o.toString() + " : " +i);
        c2.accept(new Date(), 5);

        DoubleSupplier s = ()-> Math.random()*2;
        System.out.println(s.getAsDouble());
    }
}
