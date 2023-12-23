package com.payrollsystem.jomariabejo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateChecker {
    public static boolean isStringBirthday(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy");
        sdf.setLenient(false); // Set lenient to false to enforce strict date parsing

        try {
            // Parse the inputDate string into a Date object
            sdf.parse(inputDate.replaceAll("\"", ""));

            // If parsing is successful, return true
            return true;
        } catch (ParseException e) {
            // If parsing fails, return false
            return false;
        }
    }
}
