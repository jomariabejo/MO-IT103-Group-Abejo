package com.payrollsystem.jomariabejo.utils;

import java.text.SimpleDateFormat;

public class BirthdayChecker {
    public static boolean isStringBirthday(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy");
        sdf.setLenient(false); // Set lenient to false to enforce strict date parsing

        try {
            // Parse the inputDate string into a Date object
            Date date = sdf.parse(inputDate);

            // If parsing is successful, return true
            return true;
        } catch (ParseException e) {
            // If parsing fails, return false
            return false;
        }
    }
}
