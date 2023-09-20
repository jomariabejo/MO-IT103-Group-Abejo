package com.jomariabejo.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jomariabejo.utils.StringUtils;
import com.jomariabejo.model.Salary;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Deduction;
import com.jomariabejo.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SalaryController implements Runnable {
    @FXML private ComboBox<String> cb_select_MM;

    @FXML private TextField txtField_select_YY;

    @FXML private Label lbl_basic_salary;

    @FXML private Label lbl_fullname;

    @FXML private Label lbl_hourly_rate;

    @FXML private Label lbl_net_salary;

    @FXML private Label lbl_pagibig;

    @FXML private Label lbl_philhealth;

    @FXML private Label lbl_sss;

    @FXML private Label lbl_total_gross_salary;

    @FXML private Label lbl_total_gross_salary1;

    @FXML private Label lbl_total_hours_worked;

    @FXML private Label lbl_w1_gross_salary;

    @FXML private Label lbl_w1_hours_worked;

    @FXML private Label lbl_w2_gross_salary;

    @FXML private Label lbl_w2_hours_worked;

    @FXML private Label lbl_w3_gross_salary;

    @FXML private Label lbl_w3_hours_worked;

    @FXML private Label lbl_w4_gross_salary;

    @FXML private Label lbl_w4_hours_worked;

    @FXML private Label lbl_w5_gross_salary;

    @FXML private Label lbl_w5_hours_worked;

    @FXML private Label lbl_w6_gross_salary;

    @FXML private Label lbl_w6_hours_worked;

    @FXML private Label lbl_witholding_tax;

    @FXML private TextField txtField_eid;

    @FXML private Label finalweek6lbl;

    @FXML private Label lbl_tax; // taxable income

    @FXML private Label lbl_total_deductions;

    @FXML
    void onAttendanceClicked(ActionEvent event) {
        try {
            SceneController.attendanceScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onEmployeeClicked(ActionEvent event) {
        try {
            SceneController.employeeScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onLeavesClicked(ActionEvent event) {
        try {
            SceneController.leavesScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onLogoutClicked(ActionEvent event) {
        try {
            SceneController.loginScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onSalaryClicked(ActionEvent event) {
        System.out.println("Salary Clicked");
    }

    @Override
    public void run() {
        System.out.println("Salary view running...");
        /**
         * Add combo box items for months
         */
        cb_select_MM.getItems().addAll("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November",
                "December");
    }

}

