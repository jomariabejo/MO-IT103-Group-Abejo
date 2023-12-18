package com.payrollsystem.jomariabejo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.payrollsystem.jomariabejo.data.FXMLFilePaths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController extends Application {
    private static Stage stage;
    private static URL url;


    public static URL getUrl() {
        return url;
    }

    public static URL setUrl(URL url) {
        SceneController.url = url;
        return url;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login View");
    }

    public static void loginScene(ActionEvent event) throws IOException {
        setUrl(new File(FXMLFilePaths.LOGIN_VIEW_FXML).toURI().toURL());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getUrl())));
        stage.setTitle("Login View");
        stage.show();
    }

    public static void employeeScene(ActionEvent event) throws IOException {
        setUrl(new File(FXMLFilePaths.EMPLOYEE_VIEW_FXML).toURI().toURL());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getUrl())));
        stage.setTitle("Employee View");
        stage.show();
    }

    public static void attendanceScene(ActionEvent event) throws IOException {
        setUrl(new File(FXMLFilePaths.ATTENDANCE_VIEW_FXML).toURI().toURL());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getUrl())));
        stage.setTitle("Attendance View");
        stage.show();
    }

    public static void leavesScene(ActionEvent event) throws IOException {
        setUrl(new File(FXMLFilePaths.LEAVES_VIEW_FXML).toURI().toURL());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getUrl())));
        stage.setTitle("Leaves View");
        stage.show();
    }

    public static void salaryScene(ActionEvent event) throws IOException {
        setUrl(new File(FXMLFilePaths.SALARY_VIEW_FXML).toURI().toURL());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getUrl())));
        stage.setTitle("Salary View");
        stage.show();
    }
}