package com.jomariabejo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AttendanceController {

    @FXML
    private TableView<?> attendanceTableView;

    @FXML
    private Button btn_attendance;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_createNewAttendance;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_employee;

    @FXML
    private Button btn_leaves;

    @FXML
    private Button btn_payslip;

    @FXML
    private Button btn_save;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<?, ?> employee_number;

    @FXML
    private TableColumn<?, ?> f_name;

    @FXML
    private TableColumn<?, ?> l_name;

    @FXML
    private Label lbl_attendance_size;

    @FXML
    private TextField tf_employee_number;

    @FXML
    private TextField tf_fName;

    @FXML
    private TextField tf_lName;

    @FXML
    private TextField tf_search;

    @FXML
    private TextField tf_timeIN;

    @FXML
    private TextField tf_timeOUT;

    @FXML
    private TableColumn<?, ?> timeIn;

    @FXML
    private TableColumn<?, ?> timeOut;

    @FXML
    private Font x3;

    @FXML
    private Font x31;

    @FXML
    private Font x32;

    @FXML
    private Font x321;

    @FXML
    private Color x4;

    @FXML
    private Color x41;

    @FXML
    private Color x42;

    @FXML
    private Color x421;

    @FXML
    void filterTableData(ActionEvent event) {

    }

    @FXML
    void handleCancelClick(ActionEvent event) {

    }

    @FXML
    void handleCreateNewAttendanceClick(ActionEvent event) {

    }

    @FXML
    void handleDeleteAttendanceClick(ActionEvent event) {

    }

    @FXML
    void handleSaveClick(ActionEvent event) {

    }

    @FXML
    void onClckedEmployee(ActionEvent event) {

    }

    @FXML
    void onClickedAttendance(ActionEvent event) {

    }

    @FXML
    void onClickedLeaves(ActionEvent event) {

    }

    @FXML
    void onClickedSalary(ActionEvent event) {

    }

    @FXML
    void onLogoutClicked(ActionEvent event) {

    }

}
