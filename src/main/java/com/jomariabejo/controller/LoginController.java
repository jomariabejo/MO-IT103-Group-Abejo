package com.jomariabejo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.jomariabejo.MainApp;
import com.jomariabejo.SceneController;
import com.jomariabejo.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField txtField_employeeNumber;

    @FXML
    private PasswordField pwField_password;

    private boolean verifyUser(String user, String pwd) {
        return true;
    }

    public void loginAction(ActionEvent event) {
        if (verifyUser(txtField_employeeNumber.getText(), pwField_password.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully logged in.");
            alert.showAndWait();


        } else {

        }
    }
}