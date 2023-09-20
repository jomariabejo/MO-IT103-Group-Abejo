package com.jomariabejo.automation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSQL_INSERT_QUERY_FROM_CSV {
    /**
     * INSERT INTO Attendance (employeeNumber, lastName, firstName, date, timeIn, timeOut)
     * VALUES
     * (10001, 'Crisostomo', 'Jose', '2023-09-01', '08:00:00', '17:00:00'),
     * (10001, 'Crisostomo', 'Jose', '2023-09-02', '08:00:00', '17:00:00'),
     * (10001, 'Crisostomo', 'Jose', '2023-09-03', '08:00:00', '17:00:00'),
     * (10001, 'Crisostomo', 'Jose', '2023-09-04', '08:00:00', '17:00:00'),
     * (10001, 'Crisostomo', 'Jose', '2023-09-05', '08:00:00', '17:00:00');
     */


    public static void main(String[] args) throws IOException {
        // Replace the value path with the CSV path you have.
        String csv_path = "C:\\Users\\jomar\\IdeaProjects\\MO-IT103-Group-Abejo\\src\\main\\resources\\csv\\Original_MotorPH Employee Data - Attendance Record.csv";
        // We will use a common reader for the CSV called BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csv_path));
        // Declare line where we will store the data for each row of data.
        String line;

        boolean isFirstLine = true; // Flag to skip the header row
        System.out.println("INSERT INTO Attendance (employeeNumber, lastName, firstName, date, timeIn, timeOut)\n" + " VALUES");

        // Iterate the lines of the CSV
        while ((line = bufferedReader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false; // Skip the header row
                continue;
            }

            String[] col = line.split(",");
            String employeeID = col[0];
            String l_name = col[1];
            String f_name = col[2];
            String date = formatDate(col[3]);
            String time_in = formatTime(col[4]);
            String time_out = formatTime(col[5]);
            System.out.println("(" + employeeID + ",'" + l_name + "','" + f_name + "','" + date + "','" + time_in + "','" + time_out + "'),");
        }
        System.out.println(";");
    }


    /**
     * Converts the date format from mm/dd/yyyy (CSV format) to YYYY-MM-DD (SQL format).
     *
     * @param csvDate The date in mm/dd/yyyy format.
     * @return The date converted to YYYY-MM-DD format.
     */
    public static String formatDate(String csvDate) {
        try {
            // Create a SimpleDateFormat for the CSV date format
            SimpleDateFormat csvDateFormat = new SimpleDateFormat("MM/dd/yyyy");

            String[] dateParts = csvDate.split("/");
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Check if the year is in two-digit format (e.g., "22")
            if (year < 100) {
                // Determine the threshold for a two-digit year
                int threshold = 30; // Adjust this threshold as needed

                // Calculate the full year based on the threshold
                int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                int centuryThreshold = currentYear % 100 - threshold;
                year += (centuryThreshold < 0) ? (currentYear / 100) * 100 : ((currentYear / 100) + 1) * 100;
            }

            // Reconstruct the date with the corrected year
            String fixedDate = String.format("%02d/%02d/%04d", month, day, year);

            // Parse the CSV date string into a Date object
            Date dateProcessed = csvDateFormat.parse(fixedDate);

            // Create a SimpleDateFormat for the SQL date format
            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the Date object to YYYY-MM-DD format
            return sqlDateFormat.format(dateProcessed);
        } catch (ParseException e) {
            // Handle any parsing exceptions here
            e.printStackTrace();
            return null; // or throw an exception
        }
    }



    public static String formatTime(String time) {
        // Append ":00" to the input time to represent seconds
        return time + ":00";
    }


}
