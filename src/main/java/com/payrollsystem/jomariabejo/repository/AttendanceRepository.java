package com.payrollsystem.jomariabejo.repository;

import com.payrollsystem.jomariabejo.model.Attendance;

import java.util.ArrayList;

public interface AttendanceRepository {
    void createAttendance(Attendance attendance);

    void createMultipleAttendance(ArrayList<Attendance> attendances);

    String[] readAttendance(String[] attendanceDetails);

    Attendance readAttendance(Attendance attendance);
    boolean isAttendanceExist(String[] arrAttendance);

    boolean isAttendanceExist(Attendance attendance);

    void updateAttendance(int rowLine, Attendance newAttendance);

    void deleteAttendance(int rowToDelete);


    void deleteMultipleAttendance(ArrayList<Integer> rowsToDelete);
}
