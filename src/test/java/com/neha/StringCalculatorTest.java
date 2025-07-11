package com.neha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    @Test
    public void shouldHandleNewlineAsDelimiter(){
        assertEquals(20,StringCalculator.add("10\n2,8"));
    }
    @Test
    public void shouldHandleAnyCustomDelimiter() {
        assertEquals(10, StringCalculator.add("//;\n1;2;3;4"));
        assertEquals(12, StringCalculator.add("//#\n1#2#9"));
    }
    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("3,4,-8");
        });
        assertEquals("Negative numbers not allowed: -8", e.getMessage());
    }
    @Test
    public void shouldIgnoreNumberBiggerThen1000(){
        assertEquals(2017,StringCalculator.add("1,2,1000,10,1000,4"));
        assertEquals(21,StringCalculator.add("10,2000,1001,11"));
    }
    @Test
    public void shouldHandleDelimiterWithAnyLength(){
        assertEquals(19,StringCalculator.add("//[***]\n10***1***8"));
    }
    @Test
    public void shouldHandleTwoTypeOfDiffrentDelimiterWithAnyLength(){
        assertEquals(6,StringCalculator.add("//[*][%]\n1*2%3"));
}
  @Test
    public void shouldHandleAnyNumberOfDelimiterWithAnyLength(){
        assertEquals(13,StringCalculator.add("//[#][%][*]\n1*2%3%4#3"));
  }
    @Test
    public void shouldHandleSingleCharCustomDelimiterWithoutBrackets() {
        assertEquals(6, StringCalculator.add("//;\n1;2;3")); // already covered maybe, but re-validates fallback case
    }

    @Test
    public void shouldThrowExceptionForMalformedDelimiter() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("//[***\n1***2***3");
        });
    }
    @Test
    public void shouldHandleOnlyNegativeNumbers() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("-1,-2,-3");
        });
        assertEquals("Negative numbers not allowed: -1, -2, -3", e.getMessage());
    }


}
