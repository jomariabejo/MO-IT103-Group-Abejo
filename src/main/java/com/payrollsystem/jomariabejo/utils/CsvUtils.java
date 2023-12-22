package com.payrollsystem.jomariabejo.utils;

import com.payrollsystem.jomariabejo.model.Attendance;
import com.payrollsystem.jomariabejo.model.Employee;
import com.payrollsystem.jomariabejo.data.CSVFileNames;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvUtils {

    public static void addAllEmployee() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));

        reader.readLine(); // This will read the first line and skip it.

        String line;

        while ((line = reader.readLine()) != null) {

            ArrayList<String> employeeProcessedData = new ArrayList();

            // Split the line into an array using comma as delimiter
            String[] rowData = line.split(",");

            // Declare a boolean as flag that our concatenator is open
            boolean concatOpen = false;
            /**
             * Declare a string builder for modifying string content.
             * Think of it like a dark room and we have a small bag(string) and large bag(string builder).
             * Then we start to get things, we put small things(unmodified string) to small bag,
             * meanwhile we put large things inside the larger bag(modified string).
             *
             * We use flag(concatOpen)to determine whether the string needs to be modified.
             * We continue to modify large things(modified string) until we're satisfied.
             */
            StringBuilder stringBuilder = new StringBuilder();

            for (int currentColumn = 0; currentColumn < rowData.length; currentColumn++) {
                String string = rowData[currentColumn];
                if (concatOpen) {
                    /**
                     * Verify whether the string has double quotes (") at the end of it.
                     * if it does, we will turn off the concatOpen
                     */
                    if (iBooleanUtils.isTrailingCharDoubleQuote(string)) {
                        concatOpen = false;

                        /**
                         * ⚠️ Since the comma serves as our delimiter to cut the row line into multiple strings,
                         * we'll include it once more to validate our birthday string.
                         *
                         *
                         * ✅ Check if the string contains a month.
                         * if it does, we will add a comma, otherwise, the string won't be changed.
                         */

                        boolean strHasMonth = MonthChecker.isStringContainsMonth(stringBuilder.toString());

                        if (strHasMonth) {
                            String year = string;
                            stringBuilder.append(", " + year);
                        } else {
                            stringBuilder.append(string);
                        }

                        employeeProcessedData.add(stringBuilder.toString());
                        // Reset the StringBuilder for reuse.
                        stringBuilder.setLength(0);
                    } else {
                        stringBuilder.append(string);
                    }
                } else {
                    if (iBooleanUtils.isFirstCharDoubleQuote(string) || iBooleanUtils.isFirstCharWhitespace(string)) {
                        stringBuilder.append(string);
                        concatOpen = true;
                    } else {
                        employeeProcessedData.add(string);
                    }
                }
            }
            employeeProcessedData.stream().forEach(System.out::println);
        }
    }


    public static void addAllAttendanceRecord() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            String line;
            boolean is_header = true;
            while ((line = br.readLine()) != null) {
                if (is_header) {
                    is_header = false;
                    continue;
                }
                String[] splitted_data = line.split(",");
                ArrayList<String> processedColumn = new ArrayList<String>();
                Collections.addAll(processedColumn, splitted_data);
                Attendance attendance = new Attendance(Integer.parseInt(String.valueOf(processedColumn.get(0))),
                        String.valueOf(processedColumn.get(1)),
                        String.valueOf(processedColumn.get(2)),
                        String.valueOf(processedColumn.get(3)),
                        String.valueOf(processedColumn.get(4)),
                        String.valueOf(processedColumn.get(5)));
                Attendance.records.add(attendance);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void updateByLineNumber(String filePath, int lineNumber, String[] newData) {
        List<String> updatedLines = new ArrayList<>();

        int currentLineNumber = 0; // pass over headers
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
                    updatedLines.add(updatedLine);
                } else {
                    updatedLines.add(line);
                }
                currentLineNumber++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : updatedLines) {
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
                int[] employeesNumber = Employee.employeeNumbers();
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
                if (currentLine != lineNumber) { // increment lineNumber to pass over headers
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            int add_new_line_counter = 0;
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
                add_new_line_counter++;
            }
            System.out.println("i = " + add_new_line_counter);
            System.out.println("Line deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }

    public static void updateAttendanceCSVViaOldStringtoNewString(String oldString, String newString) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
        String line;
        boolean isHeader = true;
        while ((line = br.readLine()) != null) {
            if (isHeader) {
                isHeader = false;
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


    public static String makeStringLengthToTwenty(String str) {
        int maxLength = 20;

        str = String.format("%-" + maxLength + "s", str);

        return str;
    }
}