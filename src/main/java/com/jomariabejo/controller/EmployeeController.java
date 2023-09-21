package com.jomariabejo.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.jomariabejo.utils.StringUtils;
import com.jomariabejo.MainApp;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Employee;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class EmployeeController implements Runnable {
    /**
     * Attributes
     */
    @FXML
    private Label lbl_employeeSize;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableColumn<Employee, Integer> basic_salary;

    @FXML
    private TableColumn<Employee, String> birthday;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_deleteSelectedEmployee;

    @FXML
    private Button btn_employee;

    @FXML
    private Button btn_saveOrUpdate;

    @FXML
    private TableColumn<Employee, Integer> clothing_alw;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> f_name;

    @FXML
    private TableColumn<Employee, Integer> gross_semi_monthly_rate;

    @FXML
    private TableColumn<Employee, Float> hourly_rate;

    @FXML
    private TableColumn<Employee, String> id;

    @FXML
    private TableColumn<Employee, String> immediate_supervisor;

    @FXML
    private TableColumn<Employee, String> l_name;

    @FXML
    private TableColumn<Employee, String> pagibig_num;

    @FXML
    private TableColumn<Employee, String> philhealth_num;

    @FXML
    private TableColumn<Employee, Integer> phone_alw;

    @FXML
    private TableColumn<Employee, String> phone_num;

    @FXML
    private TableColumn<Employee, String> position;

    @FXML
    private TableColumn<Employee, String> rice_subsidy;

    @FXML
    private TableColumn<Employee, String> sss_num;

    @FXML
    private TableColumn<Employee, String> status;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_basicSalary;

    @FXML
    private DatePicker dp_birthday;

    @FXML
    private TextField tf_clothingAllowance;

    @FXML
    private TextField tf_employee_number;

    @FXML
    private TextField tf_fName;

    @FXML
    private TextField tf_grossSemiMonthlyRate;

    @FXML
    private TextField tf_hourlyRate;

    @FXML
    private TextField tf_immediateSupervisor;

    @FXML
    private TextField tf_lName;

    @FXML
    private TextField tf_pagibig;

    @FXML
    private TextField tf_philhealth;

    @FXML
    private TextField tf_phone_number;

    @FXML
    private TextField tf_phoneAllowance;

    @FXML
    private TextField tf_position;

    @FXML
    private TextField tf_riceSubsidy;

    @FXML
    private TextField tf_sss;

    @FXML
    private TextField tf_status;

    @FXML
    private TextField tf_tin;

    @FXML
    private TableColumn<Employee, String> tin_num;

    @FXML
    private TextField tf_search;

    @FXML
    public void refreshEmployeeScene(ActionEvent actionEvent) {

    }

    @Override
    public void run() {

    }

    public void onAttendanceClicked(ActionEvent event) throws IOException {
        SceneController.attendanceScene(event);
    }

    public void onLeavesClicked(ActionEvent event) throws IOException {
        SceneController.leavesScene(event);
    }

    public void onSalaryClicked(ActionEvent event) throws IOException {
        SceneController.salaryScene(event);
    }

    public void onLogoutClicked(ActionEvent event) throws IOException {
        SceneController.loginScene(event);
    }

    public void filterTableData(ActionEvent event) {

    }

    public void createEmployee(ActionEvent event) {

    }

    public void onDeleteEmployeeClicked(ActionEvent event) {

    }

    public void onActionViewDetails(ActionEvent event) {

    }

    public void resetDetailsTextField(ActionEvent event) {

    }

    public void onSaveEmployeeClicked(ActionEvent event) {

    }
}
