package com.jomariabejo;

import java.io.IOException;

import com.jomariabejo.controller.AttendanceController;
import com.jomariabejo.controller.LeavesController;
import com.jomariabejo.controller.LoginController;
import com.jomariabejo.controller.SalaryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static Stage stage;
    private static Scene scene;

    /**
     * FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("signin.fxml"));
     * Parent root = loader.load();
     * Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     * Scene scene = new Scene(root);
     * stage.setScene(scene);
     * stage.setTitle("Sign In");
     * stage.show();
     *
     * @param event
     * @throws IOException
     */
    public static void loginScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("login-view.fxml"));
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
        Parent root =  FXMLLoader.load(SceneController.class.getResource("attendance-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Attendance View");
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
}