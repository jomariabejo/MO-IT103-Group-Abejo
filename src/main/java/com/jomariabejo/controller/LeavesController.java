package com.jomariabejo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.jomariabejo.utils.StringUtils;
import com.jomariabejo.model.Leave;
import com.jomariabejo.MainApp;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LeavesController implements Runnable {

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_leaves;

    @FXML
    private Button btn_save_right;

    @FXML
    private Button btn_spent_credits;

    @FXML
    private ComboBox<String> comboBox_selected_request;


    @FXML
    private DatePicker dp_leave_date;

    @FXML
    private TableColumn<Leave, Integer> eid;

    @FXML
    private TableView<Leave> leavesTableView;

    @FXML
    private TableColumn<Leave, String> first_name;

    @FXML
    private TableColumn<Leave, String> last_name;

    @FXML
    private TableColumn<Leave, String> leave_date;

    @FXML
    private TableColumn<Leave, String> leave_type;

    @FXML
    private TextField tf_employee_number;

    @FXML
    private TextField tf_fName;

    @FXML
    private TextField tf_lName;

    @FXML
    private Label lbl_num_emergency_result;

    @FXML
    private Label lbl_num_sick_result;

    @FXML
    private Label lbl_num_vacation_result;

    @FXML
    void filterTableData(ActionEvent event) {
    }

    @FXML
    void onClckedEmployee(ActionEvent event) {
        try {
            SceneController.employeeScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onClickAttendance(ActionEvent event) {
        try {
            SceneController.attendanceScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onClickedLeaves(ActionEvent event) {
        run();
        btn_leaves.requestFocus();
    }

    @FXML
    void onClickedDeleteLeave(ActionEvent event) {

    }

    @FXML
    void onClickedLogout(ActionEvent event) {

    }

    @FXML
    void onSaveLeaveClicked(ActionEvent event) throws IOException, ParseException {

    }


    @FXML
    void
    onClickedCancel(ActionEvent event) {

    }

    @FXML
    void
    onClickedSetNewLeave(ActionEvent event) {

    }


    @Override
    public void
    run() {

    }

    public void
    initialize() {
        run();
    }

    private void
    setCellValueFactoryTableColumns() {
        eid.setCellValueFactory(new PropertyValueFactory<>("eid"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        leave_type.setCellValueFactory(new PropertyValueFactory<>("leave_type"));
        leave_date.setCellValueFactory(new PropertyValueFactory<>("leave_date"));
    }


}
