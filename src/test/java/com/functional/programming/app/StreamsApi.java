package com.functional.programming.app;

import com.functional.programming.app.streamsapi.Item;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
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

    @Test
    public  void testIntStreamCollectors(){
        List<Item> items = IntStream.rangeClosed(1, 6)
                                .mapToObj(i-> {
                                    return  new Item();
                                })
                                .collect(Collectors.toList());
        Set<Integer> itemsIds = items.stream().map(Item::getId).collect(Collectors.toCollection(TreeSet::new));
        itemsIds.stream().forEach(System.out::println);
    }

    @Test
    public  void testIntStreamCollectorsWithFunction(){
        List<Item> items = IntStream.rangeClosed(1, 6)
                                .mapToObj(i-> {
                                    return  new Item();
                                })
                                .collect(Collectors.toList());

        Map<String, Item> itemsMap = items.stream().collect(Collectors.toMap(item -> item.getName().toLowerCase(),
                                                                                        Function.identity()));
        System.out.println("Keys:");
        itemsMap.keySet().stream().forEach(System.out::println);

        System.out.println("\nValues:");
        itemsMap.values().stream().map(item -> item.getName()).forEach(System.out::println);
    }
}
