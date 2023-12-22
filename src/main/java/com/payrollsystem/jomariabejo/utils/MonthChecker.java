package com.payrollsystem.jomariabejo.utils;

import java.util.Arrays;
import java.util.Set;

public class MonthChecker {

    // Check if the input string contains a month name
    public static boolean isStringContainsMonth(String inputString) {
        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        return Arrays.stream(months).anyMatch(inputString::contains);
    }
}
