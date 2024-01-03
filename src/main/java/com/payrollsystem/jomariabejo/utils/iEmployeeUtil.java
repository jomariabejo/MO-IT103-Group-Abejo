package com.payrollsystem.jomariabejo.utils;

import com.payrollsystem.jomariabejo.data.CSVFileNames;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class iEmployeeUtil implements iStringUtil {
    public void createEmployeeLeave(String [] employeeLeaveDetails) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.LEAVE_CSV, true));
        writer.write(toCommaSeparatedValue(employeeLeaveDetails));
        writer.newLine();
        writer.close();
    }
}
