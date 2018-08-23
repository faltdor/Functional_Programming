package com.functional.programming.app.string;

import org.junit.Test;

import java.util.stream.Stream;

public class StringMiscellanea {

    /**
     * String Methods
     * ChartAt.
     * getChars
     * equals
     * equalsIgnoreCase
     * compareTo
     * StartWith
     * EndsWith
     * indexOf
     * lastIndexOf
     * Substring
     * concat
     * valueOf
     * replace
     * toUpperCase
     * toLowerCase
     * trim
     * toCharArray
     */

    private String text = "Hello Wold with String";

    @Test
    public void testChartAt(){
        System.out.printf("%c", text.charAt(1));
    }

}
