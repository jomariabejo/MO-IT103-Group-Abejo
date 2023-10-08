package com.jomariabejo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static LocalDate convertStringToDate(String dateString) {
        // Define a formatter for the input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        try {
            return LocalDate.parse(dateString, formatter);
        } catch (Exception e) {
            // Handle parsing exceptions if needed
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }
}
