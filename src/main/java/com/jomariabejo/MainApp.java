package com.jomariabejo;

import com.jomariabejo.repository.EmployeeRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
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

    public static void main(String[] args) {
//        launch(args);
        System.out.println(EmployeeRepository.getEmployee(1).getLastName());
    }
}
