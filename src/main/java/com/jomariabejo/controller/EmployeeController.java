package com.jomariabejo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

import com.jomariabejo.repository.EmployeeRepository;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    public void onAddNewEmployeeClicked(ActionEvent event) {
    }

    public void onSaveButtonClicked(ActionEvent event) {
        EmployeeRepository.createEmployee(
                // should have employee number value to
                /**
                 * Error accessing field [private int com.jomariabejo.model.Employee.employeeNumber] by reflection for persistent property [com.jomariabejo.model.Employee#employeeNumber] : null
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.property.access.spi.GetterFieldImpl.get(GetterFieldImpl.java:48)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.metamodel.mapping.internal.BasicEntityIdentifierMappingImpl.getIdentifier(BasicEntityIdentifierMappingImpl.java:148)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.persister.entity.AbstractEntityPersister.getIdentifier(AbstractEntityPersister.java:5269)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.id.Assigned.generate(Assigned.java:31)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.query.sqm.sql.BaseSqmToSqlAstConverter$IdGeneratorParameter.bindParameterValue(BaseSqmToSqlAstConverter.java:1455)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.sql.exec.internal.StandardJdbcMutationExecutor.execute(StandardJdbcMutationExecutor.java:74)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.query.sqm.internal.SimpleInsertQueryPlan.executeUpdate(SimpleInsertQueryPlan.java:124)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.query.sqm.internal.QuerySqmImpl.doExecuteUpdate(QuerySqmImpl.java:728)
                 * 	at org.hibernate.orm.core@6.1.7.Final/org.hibernate.query.sqm.internal.QuerySqmImpl.executeUpdate(QuerySqmImpl.java:698)
                 * 	... 60 more
                 */
                new Employee(
                        tf_lName.getText(),
                        tf_fName.getText(),
                        Date.from(dp_birthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        tf_address.getText(),
                        tf_phone_number.getText(),
                        tf_sss.getText(),
                        tf_philhealth.getText(),
                        tf_tin.getText(),
                        tf_pagibig.getText(),
                        tf_status.getText(),
                        tf_position.getText(),
                        tf_immediateSupervisor.getText(),
                        new BigDecimal(tf_basicSalary.getText()),
                        new BigDecimal(tf_riceSubsidy.getText()),
                        new BigDecimal(tf_phoneAllowance.getText()),
                        new BigDecimal(tf_clothingAllowance.getText()),
                        new BigDecimal(tf_grossSemiMonthlyRate.getText()),
                        new BigDecimal(tf_hourlyRate.getText())));
//        System.out.println(new BigDecimal(tf_basicSalary.getText()));
    }

    public void onCancelButtonClicked(ActionEvent event) {
        tf_lName.setText("");
        tf_fName.setText("");
        dp_birthday.setValue(null);  // Set the DatePicker to its default value
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
        rice_subsidy.setText("");
        phone_allowance.setText("");
        clothing_allowance.setText("");
        gross_semi_monthly_rate.setText("");
        hourly_rate.setText("");
    }


    public void onEmployeeClicked(ActionEvent event) {

    }

    public void textField_SearchBar(ActionEvent event) {
    }

}
