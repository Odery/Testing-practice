package com.vakamisu.testing.tdd;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearTest {

    @Test
    public void leapYearAreDivisibleByFour() {
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour() {
        assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearAreNotDivisibleByOneHundred() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearAreDivisibleByFourHundred() {
        assertTrue(LeapYear.isLeapYear(2000));
    }
}
