package com.payrollsystem.jomariabejo.repository;

import com.payrollsystem.jomariabejo.data.CSVFileNames;
import com.payrollsystem.jomariabejo.model.Employee;
import com.payrollsystem.jomariabejo.utils.iStringUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVEmployeeRepository implements EmployeeRepository {

    /**
     * Adds a new employee entry to the CSV file.
     *
     * @param employee The new employee to be added
     */
    @Override
    public void createEmployee(Employee employee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.EMPLOYEE_DETAILS_CSV, true));

            String [] processedEmployeeData = {
                    employee.getId(),
                    employee.getLastName(),
                    employee.getFirstName(),
                    "\""+employee.getBirthday()+"\"",
                    "\""+employee.getAddress()+"\"",
                    employee.getPhoneNumber(),
                    employee.getSssNumber(),
                    employee.getPhilhealthNumber(),
                    employee.getTinNumber(),
                    employee.getPagibigNumber(),
                    employee.getStatus(),
                    employee.getPosition(),
                    employee.getImmediateSupervisor(),
                    iStringUtil.addDoubleQuotesIfStringHasComma(iStringUtil.addCommaToStrInt(String.valueOf(employee.getBasicSalary()))),
                    iStringUtil.addDoubleQuotesIfStringHasComma(iStringUtil.addCommaToStrInt(String.valueOf(employee.getRiceSubsidy()))),
                    iStringUtil.addDoubleQuotesIfStringHasComma(iStringUtil.addCommaToStrInt(String.valueOf(employee.getPhoneAllowance()))),
                    iStringUtil.addDoubleQuotesIfStringHasComma(iStringUtil.addCommaToStrInt(String.valueOf(employee.getClothingAllowance()))),
                    iStringUtil.addDoubleQuotesIfStringHasComma(iStringUtil.addCommaToStrInt(String.valueOf(employee.getGrossSemiMonthlyRate()))),
                    String.valueOf(employee.getHourlyRate())
            };
            writer.write(String.join(",",processedEmployeeData));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a new multiple employee entry to the CSV file.
     * @param employees The new employees to be added
     */
    @Override
    public void createMultipleEmployee(ArrayList<Employee> employees) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.EMPLOYEE_DETAILS_CSV, true));

            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                writer.write(employee.toCommaSeparatedValue());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds the details of an employee by their input employee number from the CSV.
     * @param inputEmployeeNumber The employee number to search for.
     * @return Details of the employee corresponding to the input number, or null if not found.
     * @throws IOException
     */
    @Override
    public String getEmployeeByID(int inputEmployeeNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));

        reader.readLine(); // This will read the first line and skip it.

        String line;

        while ((line = reader.readLine()) != null) {

            // Split the line into an array using comma as delimiter
            String[] rowData = line.split(",");
            int csvEmployeeNumber = Integer.parseInt(rowData[0]);

            if (csvEmployeeNumber == inputEmployeeNumber) {
                return line;
            }
        }
        return null;
    }

    @Override
    public String[] readEmployee(String[] employeeDetails) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));
            reader.readLine(); // This will read the first line and skip it.

            String line;

            /**
             *  Scan through each row of the CSV file to see if the employee is present.
             *  Returns the employee if found in the row of csv; otherwise, returns null.
             */

            while ((line = reader.readLine()) != null) {
                String[] lineInfo = line.split(",");

                if (Arrays.equals(employeeDetails, lineInfo)) {
                    return employeeDetails;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // The csv does not contain the employee.
    }

    @Override
    public Employee readEmployee(Employee employee) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));
            reader.readLine(); // This will read the first line and skip it.

            String line;
            /**
             *  Scan through each row of the CSV file to see if the employee is present.
             *  Returns the employee if found in the row of csv; otherwise, returns null.
             */
            while ((line = reader.readLine()) != null) {
                String[] employeeInfo = line.split(",");
                if (matchEmployeeRecords(employee, employeeInfo)) {
                    return employee;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // The csv does not contain the employee.
    }

    @Override
    public boolean isEmployeeExist(String inputEmployeeNumber) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));
            reader.readLine(); // This will read the first line and skip it.

            String line;
            while ((line = reader.readLine()) != null) {
                String [] csvEmployeeDetails = line.split(",");
                String csvEmployeeNumber = csvEmployeeDetails[0];

                if (csvEmployeeNumber.equals(inputEmployeeNumber))
                    return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean matchEmployeeRecords(Employee employee, String[] arrEmployee) {
        String employeeNumber = employee.getId();
        String lastName = employee.getLastName();
        String firstName = employee.getFirstName();
        String birthday = employee.getBirthday();
        String address = employee.getAddress();
        String phoneNumber = employee.getPhoneNumber();
        String sssNumber = employee.getSssNumber();
        String philhealthNumber = employee.getPhilhealthNumber();
        String tinNumber = employee.getTinNumber();
        String pagibigNumber = employee.getPagibigNumber();
        String status = employee.getStatus();
        String position = employee.getPosition();
        String immediateSupervisor = employee.getImmediateSupervisor();
        String basicSalary = String.valueOf(employee.getBasicSalary());
        String riceSubsidy = String.valueOf(employee.getRiceSubsidy());
        String phoneAllowance = String.valueOf(employee.getPhoneAllowance());
        String clothingAllowance = String.valueOf(employee.getClothingAllowance());
        String grossSemiMonthlyRate = String.valueOf(employee.getGrossSemiMonthlyRate());
        String hourlyRate = String.valueOf(employee.getHourlyRate());
        System.out.println("EMPLOYEE:");
        System.out.println(employee.toString());
        System.out.println("ARR EMPLOYEE");
        Arrays.stream(arrEmployee).forEach(System.out::println);
        return employeeNumber.equals(arrEmployee[0]) &&
                lastName.equals(arrEmployee[1]) &&
                firstName.equals(arrEmployee[2]) &&
                birthday.equals(arrEmployee[3]) &&
                address.equals(arrEmployee[4]) &&
                phoneNumber.equals(arrEmployee[5]) &&
                sssNumber.equals(arrEmployee[6]) &&
                philhealthNumber.equals(arrEmployee[7]) &&
                tinNumber.equals(arrEmployee[8]) &&
                pagibigNumber.equals(arrEmployee[9]) &&
                status.equals(arrEmployee[10]) &&
                position.equals(arrEmployee[11]) &&
                immediateSupervisor.equals(arrEmployee[12]) &&
                basicSalary.equals(arrEmployee[13]) &&
                riceSubsidy.equals(arrEmployee[14]) &&
                phoneAllowance.equals(arrEmployee[15]) &&
                clothingAllowance.equals(arrEmployee[16]) &&
                grossSemiMonthlyRate.equals(arrEmployee[17]) &&
                hourlyRate.equals(arrEmployee[18]);
    }

    @Override
    public void updateEmployee(int rowLine, String[] updatedEmployee) {
        List<String> updateLine = new ArrayList<>();

        int currentLineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            String line;
            int row = rowLine - 1;
            while ((line = br.readLine()) != null) {
                if (currentLineNumber == row) {
                    StringBuilder updatedLineBuilder = new StringBuilder();
                    for (String data : updatedEmployee) {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            for (String line : updateLine) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int employeeRowDelete) {
        List<String> lines = new ArrayList<>();
        /**
         *  Reads data from a file, excluding the specified row to delete,
         *  and adds the remaining data to the 'lines' list.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine != employeeRowDelete) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        /**
         * Writes the 'lines' data to the Employee CSV file.
         * Handles exceptions that might occur during the write operation.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }

    @Override
    public void deleteMultipleEmployee(ArrayList<Integer> rowsToDelete) {
        List<String> lines = new ArrayList<>();
        /**
         *  Reads data from a file, excluding the specified row to delete,
         *  and adds the remaining data to the 'lines' list.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                boolean isRowToDeleteFound = false; // Indicates whether the row to be deleted has been found.
                currentLine++;
                for (int i = 0; i < rowsToDelete.size(); i++) {
                    if (rowsToDelete.get(i) == currentLine) {
                        rowsToDelete.remove(i);
                        isRowToDeleteFound = true;
                        break;
                    }
                }
                if (!isRowToDeleteFound) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        /**
         * Writes the 'lines' data to the Employee CSV file.
         * Handles exceptions that might occur during the write operation.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileNames.EMPLOYEE_DETAILS_CSV))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the line: " + e.getMessage());
        }
    }

    @Override
    public void clearAllEmployees() {
        Employee.records.clear();
    }
}
