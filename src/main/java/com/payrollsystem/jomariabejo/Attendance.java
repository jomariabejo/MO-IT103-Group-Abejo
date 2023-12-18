package com.payrollsystem.jomariabejo;

import java.util.ArrayList;

public class Attendance {
    public static ArrayList<Attendance> records = new ArrayList<>();
    private int employee_number;
    private String l_name;
    private String f_name;
    private String date;
    private String timeIn;
    private String timeOut;

    public Attendance(int employeeNumber, String lastName, String firstName,
                      String date, String timeIn, String timeOut) {
        this.employee_number = employeeNumber;
        this.l_name = lastName;
        this.f_name = firstName;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public String getL_name() {
        return l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getDate() {
        return date;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    @Override
    public String toString() {
        return "Attendance{"
                + "employee_number=" + employee_number + ", lName='" + l_name + '\''
                + ", fName='" + f_name + '\'' + ", date=" + date + ", timeIn=" + timeIn
                + ", timeOut=" + timeOut + '}';
    }

    public static void addAllAttendanceRecord() {
        CsvUtils.addAllAttendanceRecord();
    }

    public static void clearAttendanceRecord() {
        records.clear();
    }

    public String getFullName() {
        return f_name + " " + l_name;
    }

    public String toCommaSeparatedValueString () {
        return (String.valueOf(employee_number)
                + ","
                + l_name
                + ","
                + f_name
                + ","
                + date
                + ","
                + timeIn
                + ","
                + timeOut);
    }
}
