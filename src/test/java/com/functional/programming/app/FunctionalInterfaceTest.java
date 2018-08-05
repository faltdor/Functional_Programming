package com.functional.programming.app;

import com.functional.programming.app.functionalinterface.BinaryIntOperation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalInterfaceTest {

    private final int operator1 =  5;
    private final int operator2 =  2;

    @Test
    public void testAddition(){
        BinaryIntOperation sum = (int operator1, int operator2) -> operator1 + operator2;
        double result = sum.compute(operator1,operator2);
        assertThat(result).isEqualTo(7.0);
        System.out.println("Addition:   " + result);
    }

    @Test
    public void testSubtraction(){
        BinaryIntOperation sub = (int operator1, int operator2) -> operator1 - operator2;
        double result = sub.compute(operator1,operator2);
        assertThat(result).isEqualTo(3.0);
        System.out.println("Subtraction:   " + result);
    }

    @Test
    public void testMultiplication(){
        BinaryIntOperation mult = (int operator1, int operator2) -> operator1 * operator2;
        double result = mult.compute(operator1,operator2);
        assertThat(result).isEqualTo(10.0);
        System.out.println("Multiplication:   " + result);
    }

    @Test
    public void testDivision(){
        BinaryIntOperation div = (int operator1, int operator2) -> operator1 / operator2;
        double result = div.compute(operator1,operator2);
        assertThat(result).isEqualTo(2.0);
        System.out.println("Division:   " + result);
    }
}