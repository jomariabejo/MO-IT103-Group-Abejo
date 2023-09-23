package com.jomariabejo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employeeNumber")
    private int employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "employee_id") // Adjust the column name to match your schema
    private Employee employee;


    @Column(name = "date")
    private Date date;

    @Column(name = "timeIn")
    private Time timeIn;

    @Column(name = "timeOut")
    private Time timeOut;

    // Constructors, getters, and setters
    // ...


    public Attendance() {
    }

    public Attendance(int id, int employeeNumber, String lastName, String firstName, Date date, Time timeIn, Time timeOut) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }
}
