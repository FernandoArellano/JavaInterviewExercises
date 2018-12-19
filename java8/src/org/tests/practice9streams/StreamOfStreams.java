package org.tests.practice9streams;

import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String [] args){
        Integer [] arreglo = {3,5,7,8,10};
        Stream<Integer> stream = Stream.of(arreglo);
        stream.filter(i-> i>4).forEach(System.out::println);

        Stream<Integer> stream1 = Stream.of(9,99,999,9999,99999);
        stream1.map(i-> i*2).forEach(System.out::println);
    }

}
