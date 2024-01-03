package com.payrollsystem.jomariabejo.utils;

import com.payrollsystem.jomariabejo.model.Attendance;
import com.payrollsystem.jomariabejo.model.Employee;
import com.payrollsystem.jomariabejo.data.CSVFileNames;
import com.payrollsystem.jomariabejo.model.Leave;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvUtil {

    public static void addAllEmployee() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));

        reader.readLine(); // This will read the first line and skip it.

        String line;

        while ((line = reader.readLine()) != null) {

            ArrayList<String> employeeProcessedData = new ArrayList();

            // Split the line into an array using comma as delimiter
            String[] rowData = line.split(",");

            // Declare a boolean as flag that our concatenator is close
            boolean concatOpen = false;
            /**
             * Declare a string builder for modifying string content.
             * Think of it like a dark room and we have a small bag(string) and large bag(string builder).
             * Then we start to get things, we put small things(string) to small bag,
             * meanwhile we put large things inside the larger bag(modified string).
             *
             * We use flag(concatOpen)to determine whether the string needs to be modified.
             * We continue to modify large things(modified string) until we're satisfied.
             */
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < rowData.length; i++) {
                String string = rowData[i];

                if (concatOpen) {
                    /**
                     * Verify whether the string has double quotes (") at the end of it.
                     * If it does, close concatOpen and append the string.
                     */
                    if (iBooleanUtils.isTrailingCharDoubleQuote(string)) {
                        concatOpen = false;

                        stringBuilder.append(string);

                        employeeProcessedData.add(stringBuilder.toString());
                        // Reset the StringBuilder for reuse.
                        stringBuilder.setLength(0);
                    } else {
                        stringBuilder.append(string);
                    }
                } else {
                    if (iBooleanUtils.isFirstCharDoubleQuote(string) || iBooleanUtils.isFirstCharWhitespace(string)) {
                        stringBuilder.append(string + ",");
                        concatOpen = true;
                    } else {
                        employeeProcessedData.add(string);
                    }
                }
            }

            /**
             * Adds a new employee to the records using processed data.
             * The Employee object is instantiated with specific data fields extracted from 'employeeProcessedData'.
             * Ensure correct data types are used and any necessary conversions are applied.
             */

            Employee.records.add(
                    new Employee(
                            employeeProcessedData.get(0),    // Employee number
                            employeeProcessedData.get(1),    // Last name
                            employeeProcessedData.get(2),    // First name
                            employeeProcessedData.get(3).replaceAll("^\"|\"$", ""),    // Remove double quotes just from the beginning and end of the Birthday
                            employeeProcessedData.get(4).replaceAll("^\"|\"$", ""),    // Remove double quotes just from the beginning and end of the Address
                            employeeProcessedData.get(5),    // Phone Number
                            employeeProcessedData.get(6),    // SSS #
                            employeeProcessedData.get(7),    // Philhealth #
                            employeeProcessedData.get(8),    // TIN #
                            employeeProcessedData.get(9),    // Pagibig #
                            employeeProcessedData.get(10),   // Status
                            employeeProcessedData.get(11),   // Position
                            employeeProcessedData.get(12),   // Immediate Supervisor
                            IntegerUtil.fixInteger(employeeProcessedData.get(13)),     // Basic Salary
                            IntegerUtil.fixInteger(employeeProcessedData.get(14)),     // Rice Subsidy
                            IntegerUtil.fixInteger(employeeProcessedData.get(15)),     // Phone Allowance
                            IntegerUtil.fixInteger(employeeProcessedData.get(16)),     // Clothing Allowance
                            IntegerUtil.fixInteger(employeeProcessedData.get(17)),     // Gross Semi-monthly rate
                            Float.parseFloat(employeeProcessedData.get(18))            // Hourly Rate
                    )
            );
        }
    }


    public static void addAllAttendanceRecord() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));

            // This will read the first line and skip it.
            br.readLine();

            String line;

            // Continue reading the CSV file until all rows are read.
            while ((line = br.readLine()) != null) {


                // Split the line by commas to separate items
                String[] rowData = line.split(","); // Separate items using a comma as the delimiter.

                // Create a new ArrayList to store processed attendance data
                ArrayList<String> attendanceProcessedData = new ArrayList<String>();

                // Add the elements from rowData into attendanceProcessedData
                Collections.addAll(attendanceProcessedData, rowData);

                // Add new attendance to record
                Attendance.records.add(
                        new Attendance(
                                Integer.parseInt(String.valueOf(attendanceProcessedData.get(0))), //Employee #
                                String.valueOf(attendanceProcessedData.get(1)), //Last name
                                String.valueOf(attendanceProcessedData.get(2)), // First name
                                String.valueOf(attendanceProcessedData.get(3)), // Date
                                String.valueOf(attendanceProcessedData.get(4)), // Time in
                                String.valueOf(attendanceProcessedData.get(5))) // Time out
                );
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void addAllLeaves() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.LEAVE_CSV));
            br.readLine(); // This will read the first line and skip it.
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");

                Leave newLeave = new Leave(Integer.valueOf(arr[0]), arr[1], arr[2], arr[3], arr[4]);

                Leave.RECORDS.add(newLeave);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateByLineNumber(String filePath, int lineNumber, String[] newData) {
        List<String> updateLine = new ArrayList<>();

        int currentLineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = lineNumber - 1;
            while ((line = br.readLine()) != null) {
                if (currentLineNumber == row) {
                    StringBuilder updatedLineBuilder = new StringBuilder();
                    for (String data : newData) {
                        updatedLineBuilder.append(data).append(",");
                    }
                    String updatedLine = updatedLineBuilder.toString().trim(); // Trim trailing tab
                    updateLine.add(updatedLine);
                } else {
                    updateLine.add(line);
                }
                currentLineNumber++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : updateLine) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file: " + e.getMessage());
        }
    }

    public static int findLineNumberByEmployeeNumber(String filepath, String employeeNumber) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int lineNumber = 1;
            if (filepath.contains("Attendance Record")) {
                if (Attendance.records.isEmpty()) Attendance.addAllAttendanceRecord();
                while ((line = reader.readLine()) != null) {
                    lineNumber++;

                    String[] columns = line.split("\t");

                    if (columns.length > 0 && columns[0].equals(employeeNumber)) {
                        System.out.println("Employee number found at line " + lineNumber);
                        reader.close();
                        return lineNumber; // found
                    }
                }
            } else if (filepath.contains("Employee Details")) {
                if (Employee.records.isEmpty()) Employee.addAllEmployees();
                int[] employeesNumber = Employee.arrEmployeeNumbers();
                System.out.println("employees number length = " + employeesNumber.length);
                if (Employee.records.isEmpty()) addAllEmployee();
                for (int i = 0; i < employeesNumber.length; i++) {
                    lineNumber++;
                    if (Integer.parseInt(employeeNumber) == employeesNumber[i]) {
                        System.out.println("Employee number found at line " + lineNumber);
                        reader.close();
                        return lineNumber; // found
                    }
                }
            }
            return 0; // not found
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteEmployeeRecordByLineNumber(String filepath, int lineNumber) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine != lineNumber) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }

    public static void updateAttendanceCSVViaOldStringtoNewString(String oldString, String newString) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Employee #,Last Name,First Name,Date,Time-in,Time-out")) {
                updatedLines.add("Employee #,Last Name,First Name,Date,Time-in,Time-out");
            } else if (line.equals(oldString)) {
                StringBuilder updatedLineBuilder = new StringBuilder();
                for (String data : newString.split(",")) {
                    updatedLineBuilder.append(data).append(",");
                }
                String updatedLine = updatedLineBuilder.toString().trim(); // Trim trailing tab
                int lastCommaIndex = updatedLine.lastIndexOf(",");
                // remove the last comma
                String output = updatedLine.substring(0, lastCommaIndex) + updatedLine.substring(lastCommaIndex + 1);
                updatedLines.add(output);
            } else {
                updatedLines.add(line);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.ATTENDANCE_CSV))) {
            for (String writeLine : updatedLines) {
                writer.write(writeLine);
                writer.newLine();
            }
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file: " + e.getMessage());
        }
    }
}