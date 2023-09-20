package com.jomariabejo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Leave")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private int leaveId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private LeaveType type;

    @Column(name = "description")
    private String description;

    // Constructors, getters, and setters
    // ...


    public Leave(int leaveId, String firstName, String lastName, Date date, LeaveType type, String description) {
        this.leaveId = leaveId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.type = type;
        this.description = description;
    }

    public Leave() {

    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LeaveType getType() {
        return type;
    }

    public void setType(LeaveType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum LeaveType {
        Vacation,
        Sick,
        Emergency
    }
}
