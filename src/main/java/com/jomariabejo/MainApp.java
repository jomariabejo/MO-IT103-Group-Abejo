package com.jomariabejo;

import com.jomariabejo.repository.EmployeeRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends SceneController {

    public static void main(String[] args) {
        launch(args);
//        System.out.println(EmployeeRepository.getEmployee(1).getLastName());
    }
}
