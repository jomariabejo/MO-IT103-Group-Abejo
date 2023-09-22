package com.jomariabejo.in;

import com.jomariabejo.model.Employee;

public interface iEmployee {
    default Employee setNewValues(Employee data) {
        Employee employee = new Employee();

        employee.setLastName(data.getLastName());
        employee.setFirstName(data.getFirstName());
        employee.setBirthday(data.getBirthday());
        employee.setAddress(data.getAddress());
        employee.setPhoneNumber(data.getPhoneNumber());
        employee.setSssNumber(data.getSssNumber());
        employee.setPhilhealthNumber(data.getPhilhealthNumber());
        employee.setTinNumber(data.getTinNumber());
        employee.setPagIbigNumber(data.getPagIbigNumber());
        employee.setStatus(data.getStatus());
        employee.setPosition(data.getPosition());
        employee.setImmediateSupervisor(data.getImmediateSupervisor());
        employee.setBasicSalary(data.getBasicSalary());
        employee.setRiceSubsidy(data.getRiceSubsidy());
        employee.setPhoneAllowance(data.getPhoneAllowance());
        employee.setClothingAllowance(data.getClothingAllowance());
        employee.setGrossSemiMonthlyRate(data.getGrossSemiMonthlyRate());
        employee.setHourlyRate(data.getHourlyRate());

        return employee;
    }
}
