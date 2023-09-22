package com.jomariabejo.interface_.employee;

import com.jomariabejo.model.Employee;

public interface iEmployee {

    /**
     * This method will update the primary employee based on the values of secondary employee
     * @param primaryEmployee The main Employee
     * @param SecondaryEmployee The updated Values of Employee
     * @return
     */
    default Employee injectNewValues(Employee primaryEmployee, Employee SecondaryEmployee) {

        primaryEmployee.setLastName(SecondaryEmployee.getLastName());
        primaryEmployee.setFirstName(SecondaryEmployee.getFirstName());
        primaryEmployee.setBirthday(SecondaryEmployee.getBirthday());
        primaryEmployee.setAddress(SecondaryEmployee.getAddress());
        primaryEmployee.setPhoneNumber(SecondaryEmployee.getPhoneNumber());
        primaryEmployee.setSssNumber(SecondaryEmployee.getSssNumber());
        primaryEmployee.setPhilhealthNumber(SecondaryEmployee.getPhilhealthNumber());
        primaryEmployee.setTinNumber(SecondaryEmployee.getTinNumber());
        primaryEmployee.setPagIbigNumber(SecondaryEmployee.getPagIbigNumber());
        primaryEmployee.setStatus(SecondaryEmployee.getStatus());
        primaryEmployee.setPosition(SecondaryEmployee.getPosition());
        primaryEmployee.setImmediateSupervisor(SecondaryEmployee.getImmediateSupervisor());
        primaryEmployee.setBasicSalary(SecondaryEmployee.getBasicSalary());
        primaryEmployee.setRiceSubsidy(SecondaryEmployee.getRiceSubsidy());
        primaryEmployee.setPhoneAllowance(SecondaryEmployee.getPhoneAllowance());
        primaryEmployee.setClothingAllowance(SecondaryEmployee.getClothingAllowance());
        primaryEmployee.setGrossSemiMonthlyRate(SecondaryEmployee.getGrossSemiMonthlyRate());
        primaryEmployee.setHourlyRate(SecondaryEmployee.getHourlyRate());

        return primaryEmployee;
    }
}
