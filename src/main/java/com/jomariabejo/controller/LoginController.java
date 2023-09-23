package com.jomariabejo.controller;

import com.jomariabejo.SceneController;
import com.jomariabejo.database.db;
import com.jomariabejo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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


            EntityManager entityManager = db.getInstance().getEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            try {
                entityTransaction.begin();

                String username = txtField_employeeNumber.getText();
                String password = pwField_password.getText();

                String hql = "FROM User u WHERE u.username = :username AND u.password = :password";

                User user = (User) entityManager.createQuery(hql)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .getSingleResult();

                if (user != null) {
                    // User with the provided username and password exists
                    // Perform further actions here
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login success");
                    alert.showAndWait();
                    // goto employee scene
                    SceneController.employeeScene(event);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Login failed");
                    alert.showAndWait();
                    // User not found
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}