package com.example.test.fx123;

import com.example.fx123.Attendance;
public class SamplePopulatingAttendanceRecord {
    public static void main(String[] args) {
        // Call the method to add all attendance records
        attendance.addAllAttendanceRecord();

        // Verify the size of the attendance record
        int attendanceRecordSize = attendance.records.size();
        int expectedSize = 2175;

        // Check if the size matches the expected value
        boolean sizeMatches = (attendanceRecordSize == expectedSize);

        // Print the result
        System.out.println("Attendance record size: " + attendanceRecordSize);
        System.out.println("Expected size: " + expectedSize);
        System.out.println("Size matches: " + sizeMatches);
    }
}
