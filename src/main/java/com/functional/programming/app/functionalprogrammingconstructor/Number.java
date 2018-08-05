package com.functional.programming.app.functionalprogrammingconstructor;

public class Number {

    private int value;

    public boolean isOdd() {
        return  (this.value & 0x1) > 0;
    }

    public void dump(){
        System.out.format("Value: %2d (Parity %s)\n",
                        getValue(),
                (isOdd() ? "Odd": "Even"));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}