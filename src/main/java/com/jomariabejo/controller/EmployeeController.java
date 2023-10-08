package com.jomariabejo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.jomariabejo.formatter.DateFormatter;
import com.jomariabejo.repository.EmployeeRepository;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Employee;
import com.jomariabejo.utils.AlertUtils;
import com.jomariabejo.utils.DateUtils;
import com.jomariabejo.utils.TextFieldUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button btn_delete;

    @FXML
    private Button btn_employee;

    @FXML
    private Button btn_saveOrUpdate;

    @FXML
    private TableColumn<Employee, Integer> clothing_allowance;

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
    private TableColumn<Employee, Integer> phone_allowance;

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

    /**
     * Custom Method
     */


    public void initialize() {
        setCellValueFactoryTableColumns();
        run();
    }

    @Override
    public void run() {
        ObservableList<Employee> list = FXCollections.observableArrayList(EmployeeRepository.getAllEmployee());
        employeeTable.setItems(list);
        lbl_employeeSize.setText(String.valueOf(EmployeeRepository.getEmployeeSize()));

        tableViewSelectedItemListener();
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
        try {
            boolean isEmployeeFound = EmployeeRepository.deleteEmployee(Long.valueOf(tf_employee_number.getText()));

            if (isEmployeeFound) {
                run();
                AlertUtils.alertSuccess("Employee: "+ tf_fName.getText() + " " + tf_lName.getText() + " deleted successfully...");
            }
            else {
                AlertUtils.alertFailed("Employee: "+ tf_fName.getText() + " " + tf_lName.getText() + " not found...");
            }
            // reload scene
            btn_delete.setDisable(true);
        }
        catch (Exception e) {
            AlertUtils.alertFailed("Employee number "+ tf_employee_number.getText() + " not found.");
        }
    }

    public void onActionViewDetails(ActionEvent event) {

    }

    public void resetDetailsTextField(ActionEvent event) {

    }

    public void onSaveEmployeeClicked(ActionEvent event) {

    }

    /**
     * This method will clear the textfields and redirect to the primary textfield where
     *
     * @param event
     */
    public void onAddNewEmployeeClicked(ActionEvent event) {
        clearFields();
        tf_employee_number.requestFocus();
        btn_saveOrUpdate.setText("Save");
    }

    public void onSaveButtonClicked(ActionEvent event) {
        try {
            if (btn_saveOrUpdate.getText().equals("Save")) {
                if (isValidFields()) {
                    EmployeeRepository.createEmployee(
                            new Employee(
                                    tf_lName.getText().trim(),
                                    tf_fName.getText().trim(),
                                    Date.from(dp_birthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                                    tf_address.getText().trim(),
                                    tf_phone_number.getText().trim(),
                                    tf_sss.getText().trim(),
                                    tf_philhealth.getText(),
                                    tf_tin.getText().trim(),
                                    tf_pagibig.getText().trim(),
                                    tf_status.getText().trim(),
                                    tf_position.getText().trim(),
                                    tf_immediateSupervisor.getText().trim(),
                                    new BigDecimal(tf_basicSalary.getText().trim()),
                                    new BigDecimal(tf_riceSubsidy.getText().trim()),
                                    new BigDecimal(tf_phoneAllowance.getText().trim()),
                                    new BigDecimal(tf_clothingAllowance.getText().trim()),
                                    new BigDecimal(tf_grossSemiMonthlyRate.getText().trim()),
                                    new BigDecimal(tf_hourlyRate.getText().trim())));
                    AlertUtils.alertSuccess("Employee " + tf_fName.getText().trim() + " " + tf_lName.getText().trim() + "created successfully.");
                }
            }
            else {
                /**
                 * String lastName, String firstName, Date birthday, String address, String phoneNumber,
                 * String sssNumber, String philhealthNumber, String tinNumber, String pagIbigNumber, String status,
                 * String position, String immediateSupervisor, BigDecimal basicSalary, BigDecimal riceSubsidy,
                 * BigDecimal phoneAllowance, BigDecimal clothingAllowance, BigDecimal grossSemiMonthlyRate,
                 * BigDecimal hourlyRate
                 */
                /**
                 * basicSalary
                 * riceSubsidy
                 * phoneAllowance
                 * clothingAllowance
                 * grossSemiMonthlyRate
                 * hourlyRate
                 */

                BigDecimal basicSalary = new BigDecimal(tf_basicSalary.getText());
                BigDecimal riceSubsidy = new BigDecimal(tf_riceSubsidy.getText());
                BigDecimal phoneAllowance = new BigDecimal(tf_phoneAllowance.getText());
                BigDecimal clothingAllowance = new BigDecimal(tf_clothingAllowance.getText());
                BigDecimal grossSemiMonthlyRate = new BigDecimal(tf_grossSemiMonthlyRate.getText());
                BigDecimal hourlyRate = new BigDecimal(tf_hourlyRate.getText());

                EmployeeRepository.updateEmployee(Long.valueOf(tf_employee_number.getText()),
                        new Employee(tf_lName.getText().trim(),
                                tf_fName.getText().trim(),
                                DateFormatter.convertLocalDateToDate(dp_birthday.getValue()),
                                tf_address.getText().trim(),
                                tf_phone_number.getText().trim(),
                                tf_sss.getText().trim(),
                                tf_philhealth.getText().trim(),
                                tf_tin.getText().trim(),
                                tf_pagibig.getText().trim(),
                                tf_status.getText().trim(),
                                tf_position.getText().trim(),
                                tf_immediateSupervisor.getText().trim(),basicSalary,riceSubsidy,phoneAllowance,clothingAllowance,grossSemiMonthlyRate,hourlyRate));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AlertUtils.alertFailed(e.getMessage());
        }
        finally {
            // Reload Scene
            run();
        }
    }

    public void onCancelButtonClicked(ActionEvent event) {
        clearFields();
    }


    public void onEmployeeClicked(ActionEvent event) {

    }

    public void textField_SearchBar(ActionEvent event) {

    }

    public void setCellValueFactoryTableColumns() {
        id.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
        l_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        f_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_num.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        sss_num.setCellValueFactory(new PropertyValueFactory<>("sssNumber"));
        philhealth_num.setCellValueFactory(new PropertyValueFactory<>("philhealthNumber"));
        tin_num.setCellValueFactory(new PropertyValueFactory<>("tinNumber"));
        pagibig_num.setCellValueFactory(new PropertyValueFactory<>("pagIbigNumber"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        immediate_supervisor.setCellValueFactory(new PropertyValueFactory<>("immediateSupervisor"));
        basic_salary.setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
        rice_subsidy.setCellValueFactory(new PropertyValueFactory<>("riceSubsidy"));
        phone_allowance.setCellValueFactory(new PropertyValueFactory<>("phoneAllowance"));
        clothing_allowance.setCellValueFactory(new PropertyValueFactory<>("clothingAllowance"));
        gross_semi_monthly_rate.setCellValueFactory(new PropertyValueFactory<>("grossSemiMonthlyRate"));
        hourly_rate.setCellValueFactory(new PropertyValueFactory<>("hourlyRate"));
    }

    public void tableViewSelectedItemListener() {
        employeeTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, employee) -> {
                    if (employee != null) {
                        // print employee data via console.

                        /**
                         * Update the Details textfields
                         */

                        tf_employee_number.setText(String.valueOf(employee.getEmployeeNumber()));
                        tf_lName.setText(employee.getLastName());
                        tf_fName.setText(employee.getFirstName());
                        tf_address.setText(employee.getAddress());
                        dp_birthday.setValue(DateUtils.convertStringToDate(employee.getBirthday().toString()));
                        tf_fName.setText(employee.getFirstName());
                        tf_lName.setText(employee.getLastName());
                        tf_clothingAllowance.setText(String.valueOf(employee.getClothingAllowance()));
                        tf_grossSemiMonthlyRate.setText(String.valueOf(employee.getGrossSemiMonthlyRate()));
                        tf_tin.setText(String.valueOf(employee.getTinNumber()));
                        tf_status.setText(employee.getStatus());
                        tf_sss.setText(employee.getSssNumber());
                        tf_riceSubsidy.setText(String.valueOf(employee.getRiceSubsidy()));
                        tf_position.setText(employee.getPosition());
                        tf_phoneAllowance.setText(String.valueOf(employee.getPhoneAllowance()));
                        tf_philhealth.setText(String.valueOf(employee.getPhilhealthNumber()));
                        tf_pagibig.setText(String.valueOf(employee.getPagIbigNumber()));
                        tf_immediateSupervisor.setText(employee.getImmediateSupervisor());
                        tf_hourlyRate.setText(String.valueOf(employee.getHourlyRate()));
                        tf_phone_number.setText(String.valueOf(employee.getPhoneNumber()));
                        tf_basicSalary.setText(String.valueOf(employee.getBasicSalary()));
                    }
                });
        btn_saveOrUpdate.setText("Update");
        btn_delete.setDisable(false);
    }


    /**
     * Custom Hard Coded Methods Starts Here😁
     */
    private void clearFields() {
        tf_employee_number.setText("");
        tf_lName.setText("");
        tf_fName.setText("");
        dp_birthday.setValue(LocalDate.of(2001, 11, 28));  // Set the DatePicker to its default value
        tf_address.setText("");
        tf_phone_number.setText("");
        tf_sss.setText("");
        tf_philhealth.setText("");
        tf_tin.setText("");
        tf_pagibig.setText("");
        tf_status.setText("");
        tf_position.setText("");
        tf_immediateSupervisor.setText("");
        tf_basicSalary.setText("");
        tf_riceSubsidy.setText("");
        tf_phone_number.setText("");
        tf_clothingAllowance.setText("");
        tf_grossSemiMonthlyRate.setText("");
        tf_hourlyRate.setText("");
        btn_saveOrUpdate.setText("Save");
    }

    /**
     * Check all the fields values,
     * If any of textfields are null or blank, an alert error should be displayed and return false.
     * else continue;
     */
    private boolean isValidFields() {

        if (dp_birthday.getValue() == LocalDate.of(2001, 11, 28)) {
            AlertUtils.alertFailed("Set your birthday");
            return false;
        } else {


            TextField[] textField = {
                    tf_employee_number,
                    tf_lName,
                    tf_fName,
                    tf_address,
                    tf_phone_number,
                    tf_sss,
                    tf_philhealth,
                    tf_tin,
                    tf_pagibig,
                    tf_status,
                    tf_position,
                    tf_immediateSupervisor,
                    tf_basicSalary,
                    tf_riceSubsidy,
                    tf_clothingAllowance,
                    tf_grossSemiMonthlyRate,
                    tf_hourlyRate
            };
            for (short i = 0; i < textField.length; i++) {
                if (textField[i].getText().isEmpty()) {
                    AlertUtils.alertFailed("Invalid input for " + TextFieldUtils.getEmployeeTextFieldName[i]);
                    textField[i].requestFocus();
                    return false;
                }
            }
        }
        return true;
    }
}
