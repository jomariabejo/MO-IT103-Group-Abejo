package com.jomariabejo.controller;

import com.jomariabejo.SceneController;
import com.jomariabejo.database.HibernateUtil;
import com.jomariabejo.model.User;
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


            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();

            try {
                session.beginTransaction();

                String username = txtField_employeeNumber.getText();
                String password = pwField_password.getText();

                String hql = "FROM User u WHERE u.username = :username AND u.password = :password";

                User user = (User) session.createQuery(hql)
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .uniqueResult();

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
                session.getTransaction().commit();

            }
            catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }
}