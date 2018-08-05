package com.functional.programming.app;

import com.functional.programming.app.functionalprogrammingconstructor.Number;
import com.functional.programming.app.functionalprogrammingconstructor.NumsFiller;
import com.functional.programming.app.functionalprogrammingconstructor.NumsMaker;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class FunctionalProgrammingConstructorTest {

    @Test
    public void testConstructorReference(){
        int total = 25;
        NumsMaker numsMaker = Number[]::new; //Constructor Refrence.
        Number[] numbers = numsMaker.makeNumbers(total);

        NumsFiller numsFiller = (array, limit) -> {
            Random random = new Random();
            for (int i = 0; i < limit; i++) {
                array[i] = new Number();
                array[i].setValue(random.nextInt(100));
            }
        };

        numsFiller.populate(numbers, total);
        Arrays.asList(numbers).stream().filter(n -> n.isOdd()).forEach(Number::dump);
    }

}
