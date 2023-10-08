package com.jomariabejo.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {
    public static Date convertLocalDateToDate(LocalDate localDate) {
        try {
            // Create a SimpleDateFormat with the desired date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Parse the LocalDate to a formatted string
            String formattedDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Parse the formatted string to a Date object
            return sdf.parse(formattedDate);
        } catch (ParseException e) {
            // Handle the exception if parsing fails
            e.printStackTrace();
            return null; // Return null or handle the error appropriately in your application
        }
    }
}
