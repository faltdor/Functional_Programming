package com.functional.programming.app;

public class FunctionalInterface {

    @java.lang.FunctionalInterface
    protected interface BinaryIntOp {
        double compute(int operator1, int operator2);
    }

    public static void main(String args[]){
                                                            //lambda
        BinaryIntOp sum = (int operator1, int operator2) -> operator1 + operator2;
        BinaryIntOp sub = (int operator1, int operator2) -> operator1 - operator2;
        BinaryIntOp mul = (int operator1, int operator2) -> operator1 * operator2;
        BinaryIntOp div = (operator1, operator2) -> operator1 / operator2;

        final int operator1 =  5;
        final int operator2 =  2;

        System.out.println("Addition:   " + sum.compute(operator1,operator2));
        System.out.println("Subtraction:   " +  sub.compute(operator1,operator2));
        System.out.println("Multiplication:   " +   mul.compute(operator1,operator2));
        System.out.println("Division:   " +   div.compute(operator1,operator2));
    }
}
