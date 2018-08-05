package com.functional.programming.app;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsApi {

    @Test
    public  void testStreamOf(){
        Stream.of("BOB", "RAY","ANDREW")
                .filter(n -> n.endsWith("W"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    public  void testIntStreamRange(){
        IntStream
                .range(1, 65)
                .filter(i -> (i & 0x1) > 0 )
                .forEach(System.out::println);

    }

    @Test
    public  void testIntStreamMapToObject(){
        List<String> result = IntStream.range(1, 65)
                .filter(i -> (i & 0x1) > 0 )
                .mapToObj(i -> i + ": Odd")
                .collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }

    @Test
    public  void testIntStreamAverage(){
        double result = IntStream.range(1, 65)
                .filter(i -> (i & 0x1) == 0 )
                .average()
                .getAsDouble();
        System.out.println(result);
    }

    @Test
    public  void testIntStreamSum(){
        int result = IntStream.rangeClosed(1, 65)
                .filter(i -> (i & 0x1) == 0 )
                .sum();
        System.out.println(result);
    }
}
