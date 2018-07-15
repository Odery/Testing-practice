package com.vakamisu.testing.tdd;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
    }

    private static boolean isDivisible(final int year, final int by) {
        return year % by == 0;
    }
}
