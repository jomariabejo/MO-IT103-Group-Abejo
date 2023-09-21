package com.jomariabejo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeNumber")
    private int employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "sssNumber")
    private String sssNumber;

    @Column(name = "philhealthNumber")
    private String philhealthNumber;

    @Column(name = "tinNumber")
    private String tinNumber;

    @Column(name = "pagIbigNumber")
    private String pagIbigNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "position")
    private String position;

    @Column(name = "immediateSupervisor")
    private String immediateSupervisor;

    @Column(name = "basicSalary")
    private BigDecimal basicSalary;

    @Column(name = "riceSubsidy")
    private BigDecimal riceSubsidy;

    @Column(name = "phoneAllowance")
    private BigDecimal phoneAllowance;

    @Column(name = "clothingAllowance")
    private BigDecimal clothingAllowance;

    @Column(name = "grossSemiMonthlyRate")
    private BigDecimal grossSemiMonthlyRate;

    @Column(name = "hourlyRate")
    private BigDecimal hourlyRate;

    // Constructors, getters, and setters
    // ...

    public Employee(String lastName, String firstName, Date birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagIbigNumber, String status, String position, String immediateSupervisor, BigDecimal basicSalary, BigDecimal riceSubsidy, BigDecimal phoneAllowance, BigDecimal clothingAllowance, BigDecimal grossSemiMonthlyRate, BigDecimal hourlyRate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    public Employee() {

    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public void setImmediateSupervisor(String immediateSupervisor) {
        this.immediateSupervisor = immediateSupervisor;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(BigDecimal riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public BigDecimal getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(BigDecimal phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public BigDecimal getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(BigDecimal clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public BigDecimal getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public void setGrossSemiMonthlyRate(BigDecimal grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
