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
    }
    @Test
    public void shouldReturnSumOfTwoCommaSeparatedNumbers(){
        assertEquals(3,StringCalculator.add("1,2"));
    }


}
