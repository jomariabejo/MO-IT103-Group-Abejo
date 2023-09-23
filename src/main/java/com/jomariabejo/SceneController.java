package com.jomariabejo;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController extends Application {
    private static Stage stage;
    private static Scene scene;

    public static void loginScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("login-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login View");
        stage.show();
    }

    public static void employeeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("employee-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Employees");
        stage.show();
    }

    public static void attendanceScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("attendance-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Attendance");
        stage.show();
    }

    public static void leavesScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(SceneController.class.getResource("leaves-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Leaves View");
        stage.show();
    }

    public static void salaryScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(SceneController.class.getResource("salary-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Salary View");
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        try {
//            Parent root = FXMLLoader.load(MainApp.class.getResource("login-view.fxml"));
            Parent root = FXMLLoader.load(MainApp.class.getResource("login-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}