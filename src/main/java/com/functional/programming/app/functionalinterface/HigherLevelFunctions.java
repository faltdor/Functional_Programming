package com.functional.programming.app.functionalinterface;

public class HigherLevelFunctions {

    /*
        Method apply is a Higher Level Function in that it take a (reference to) function as
        argument.
     */
    public double apply(BinaryIntOperation binaryIntOperation, int operator1, int operator2){
        return binaryIntOperation.compute(operator1, operator2);
    }
}
