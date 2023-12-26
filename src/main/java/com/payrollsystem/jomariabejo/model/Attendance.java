package com.payrollsystem.jomariabejo.model;

import com.payrollsystem.jomariabejo.utils.CsvUtils;

import java.util.ArrayList;

public class Attendance {
    public static ArrayList<Attendance> records = new ArrayList<>();
    private int employee_number;
    private String last_name;
    private String first_name;
    private String date;
    private String time_in;
    private String time_out;

    public Attendance(int employeeNumber, String lastName, String firstName,
                      String date, String timeIn, String timeOut) {
        this.employee_number = employeeNumber;
        this.last_name = lastName;
        this.first_name = firstName;
        this.date = date;
        this.time_in = timeIn;
        this.time_out = timeOut;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getDate() {
        return date;
    }

    public String getTime_in() {
        return time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    @Override
    public String toString() {
        return "Attendance{"
                + "employee_number=" + employee_number + ", lName='" + last_name + '\''
                + ", fName='" + first_name + '\'' + ", date=" + date + ", timeIn=" + time_in
                + ", timeOut=" + time_out + '}';
    }

    public String toCommaSeparatedValue() {
        return getEmployee_number() + "," + getLast_name() + "," + getFirst_name() + "," + getDate() + "," + getTime_in() + "," + getTime_out();
    }

    public static void addAllAttendanceRecord() {
        CsvUtils.addAllAttendanceRecord();
    }

    public static void clearAttendanceRecord() {
        records.clear();
    }

    public String getFullName() {
        return first_name + " " + last_name;
    }

    public String toCommaSeparatedValueString () {
        return (String.valueOf(employee_number)
                + ","
                + last_name
                + ","
                + first_name
                + ","
                + date
                + ","
                + time_in
                + ","
                + time_out);
    }
}
