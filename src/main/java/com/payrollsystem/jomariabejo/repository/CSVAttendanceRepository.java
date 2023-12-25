package com.payrollsystem.jomariabejo.repository;

import com.payrollsystem.jomariabejo.data.CSVFileNames;
import com.payrollsystem.jomariabejo.model.Attendance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVAttendanceRepository implements AttendanceRepository {

    /**
     * Adds a new attendance entry to the CSV file.
     *
     * @param attendance The new attendance to be added
     */
    @Override
    public void createAttendance(Attendance attendance) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(CSVFileNames.ATTENDANCE_CSV, true));
            bw.write(attendance.toCommaSeparatedValueString());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves attendance data from the specified array of attendance details.
     *
     * @param attendanceDetails An array containing attendance information.
     * @return The attendance data found on the specified row.
     */
    @Override
    public String[] readAttendance(String[] attendanceDetails) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            br.readLine(); // This will read the first line and skip it.

            String line;
            int currentLine = 1;
            /**
             *  Scan through each row of the CSV file to see if the attendance is present.
             *  Returns the attendance if found in the row of csv; otherwise, returns null.
             */
            while ((line = br.readLine()) != null) {
                String[] lineInfo = line.split(",");

                if (Arrays.equals(attendanceDetails, lineInfo)) {
                    return attendanceDetails;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // The csv does not contain the attendance.
    }

    /**
     * Reads the CSV data and checks if the specified attendance exists.
     *
     * @param attendance The attendance to be searched for in the CSV data.
     * @return True if the attendance exists in the CSV data; otherwise, false.
     */
    @Override
    public Attendance readAttendance(Attendance attendance) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            br.readLine(); // This will read the first line and skip it.

            String line;
            /**
             *  Scan through each row of the CSV file to see if the attendance is present.
             *  Returns the attendance if found in the row of csv; otherwise, returns null.
             */
            while ((line = br.readLine()) != null) {
                String[] attendanceInfo = line.split(",");
                if (hasMatchingAttendance(attendance, attendanceInfo)) {
                    return attendance;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // The csv does not contain the attendance.
    }

    /**
     * Checks whether the specified attendance, structured as a String array, exists in the CSV data.
     *
     * @param arrAttendance The String array representing attendance data to be searched.
     * @return True if the attendance exists in the CSV; otherwise, false.
     */

    @Override
    public boolean isAttendanceExist(String[] arrAttendance) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            br.readLine(); // This will read the first line and skip it.

            String line;
            while ((line = br.readLine()) != null) {
                String[] attendanceArray = line.split(",");
                if (Arrays.equals(attendanceArray, arrAttendance)) {
                    return true; // Attendance exist
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false; // Attendance does not exist
    }

    /**
     * Checks whether the specified attendance exists in the CSV data.
     *
     * @param attendance The attendance to be searched for.
     * @return True if the attendance exists; otherwise, false.
     */

    @Override
    public boolean isAttendanceExist(Attendance attendance) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            br.readLine(); // This will read the first line and skip it.

            String line;
            while ((line = br.readLine()) != null) {
                String[] attendanceArray = line.split(",");
                if (hasMatchingAttendance(attendance, attendanceArray)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false; // Attendance does not exist
    }

    /**
     * Checks if the provided Attendance object matches the given array of attendance Strings.
     *
     * @param attendance   The Attendance object to compare.
     * @param arrAttendance An array of Strings representing attendance data.
     * @return True if the Attendance object matches the array; otherwise, false.
     */
    public boolean hasMatchingAttendance(Attendance attendance, String[] arrAttendance) {
        String employeeNumber = String.valueOf(attendance.getEmployee_number());
        String firstName = attendance.getFirst_name();
        String lastName = attendance.getLast_name();
        String date = attendance.getDate();
        String timeIn = attendance.getTime_in();
        String timeOut = attendance.getTime_out();
        return employeeNumber.equals(arrAttendance[0]) && firstName.equals(arrAttendance[2]) && lastName.equals(arrAttendance[1]) && date.equals(arrAttendance[3]) && timeIn.equals(arrAttendance[4]) && timeOut.equals(arrAttendance[5]);
    }

    /**
     * Updates the CSV line data by locating the specific row and replacing it with newAttendance.
     *
     * @param rowLine       The specific row line number of csv to be modified.
     * @param newAttendance The updated attendance data that will replace the old attendance.
     */
    @Override
    public void updateAttendance(int rowLine, Attendance newAttendance) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV));
            StringBuilder output = new StringBuilder();
            String line;
            int currentLine = 0;

            while ((line = reader.readLine()) != null) {
                if (currentLine == rowLine) {
                    // Update the specific row with new attendance data
                    output.append(newAttendance).append("\n");
                } else {
                    output.append(line).append("\n");
                }
                currentLine++;
            }
            reader.close();

            FileWriter writer = new FileWriter(CSVFileNames.ATTENDANCE_CSV);
            writer.write(output.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a single attendance entry from the CSV Attendance based on the specified 'rowToDelete'.
     *
     * @param rowToDelete The line number to be deleted.
     */
    @Override
    public void deleteAttendance(int rowToDelete) {
        List<String> lines = new ArrayList<>();
        /**
         *  Reads data from a file, excluding the specified row to delete,
         *  and adds the remaining data to the 'lines' list.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine != rowToDelete) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        /**
         * Writes the 'lines' data to the Attendance CSV file.
         * Handles exceptions that might occur during the write operation.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.ATTENDANCE_CSV))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }

    @Override
    public void deleteMultipleAttendance(ArrayList<Integer> rowsToDelete) {
        List<String> lines = new ArrayList<>();
        /**
         *  Reads data from a file, excluding the specified row to delete,
         *  and adds the remaining data to the 'lines' list.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.ATTENDANCE_CSV))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                for (int i = 0; i < rowsToDelete.size(); i++) {
                    /**
                     * Ang gusto kong mangyari is
                     */
                    if (rowsToDelete.get(i) == currentLine) {
                        rowsToDelete.remove(i);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        /**
         * Writes the 'lines' data to the Attendance CSV file.
         * Handles exceptions that might occur during the write operation.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.ATTENDANCE_CSV))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }
}
