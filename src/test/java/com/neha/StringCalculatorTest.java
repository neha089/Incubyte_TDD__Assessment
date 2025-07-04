package com.neha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0,StringCalculator.add(""));

    }

}
