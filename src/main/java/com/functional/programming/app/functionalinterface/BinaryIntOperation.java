package com.functional.programming.app.functionalinterface;

@java.lang.FunctionalInterface
public interface BinaryIntOperation {
    double compute(int operator1, int operator2); //FI only accept 1 abstract method.
}

//Higher Order Functions: Functions that take a (reference to) function as an argument.