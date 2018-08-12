package com.functional.programming.app;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStreamTest {


    @Test
    public void testParallelStreamForkjoinPool(){
        System.out.println("Default Pool Size :" + ForkJoinPool.commonPool().getParallelism());

        IntStream.range(1, 1024)
                  .parallel()  //Partition the Data Streams for Parallel Processing.
                  .filter(i -> ((i & 0x1) > 0))
                  .forEach(System.out::println);

    }
}
