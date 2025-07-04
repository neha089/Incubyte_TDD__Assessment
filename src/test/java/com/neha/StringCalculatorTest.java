package com.neha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0,StringCalculator.add(""));

    }
    @Test
    public void shouldReturnNumberForSingleInput(){
        assertEquals(1,StringCalculator.add("1"));
        assertEquals(30,StringCalculator.add("30"));

    }
    @Test
    public void shouldReturnSumOfTwoCommaSeparatedNumbers(){
        assertEquals(3,StringCalculator.add("1,2"));
        assertEquals(30,StringCalculator.add("10,20"));
        assertEquals(300,StringCalculator.add("100,200"));



    }
    @Test
    public void shouldReturnSumOfMultipleCommaSeparatedNumbers(){
        assertEquals(6,StringCalculator.add("1,2,3"));
        assertEquals(69,StringCalculator.add("10,50,9"));
        assertEquals(699,StringCalculator.add("100,500,99"));


    }


}
