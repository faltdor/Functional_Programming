package com.functional.programming.app;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RamdonIntStreamTest {

    @Test
    public  void testGenerateRandomValues(){
        SecureRandom secureRandom = new SecureRandom();
        System.out.printf("%-6s%s%n", "inxex", "frecuency");
        secureRandom.ints(6_000_000,1, 7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((inxex, frecuency) -> {
                    System.out.printf("%-6d%d%n", inxex, frecuency);
                });
    }
}
