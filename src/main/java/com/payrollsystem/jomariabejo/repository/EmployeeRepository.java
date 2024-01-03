package com.payrollsystem.jomariabejo.repository;

import com.payrollsystem.jomariabejo.model.Employee;

import java.io.IOException;
import java.util.ArrayList;

public interface EmployeeRepository {
    void createEmployee(Employee employee);

    void createMultipleEmployee(ArrayList<Employee> employees);

    String getEmployeeByID(int employeeID) throws IOException;

    String[] readEmployee(String[] employeeDetails);

    Employee readEmployee(Employee employee);

    boolean isEmployeeExist(String employeeNumber);

    void updateEmployee(int rowLine, String[] Employee);

    void deleteEmployee(int employeeRowDelete);

    void deleteMultipleEmployee(ArrayList<Integer> rowsToDelete);

    void clearAllEmployees();
}
