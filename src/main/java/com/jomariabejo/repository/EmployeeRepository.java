package com.jomariabejo.repository;

import com.jomariabejo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javafx.scene.control.Alert;
import com.jomariabejo.database.db;

import java.util.List;

public class EmployeeRepository {
    public static void createEmployee(Employee employee) {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();

            entityManager.persist(employee);
            entityTransaction.commit();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "New employee : " + employee.getFirstName() + " " + employee.getLastName() + " added successfully");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public static Employee getEmployee(int id) {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        return entityManager.find(Employee.class, id);
    }

    public static void updateEmployee(Long id, Employee employeeNewValues) {
        EntityManager entityManager = db.getInstance().getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);

        try {
            if (employee != null) {
                employee.injectNewValues(employee, employeeNewValues);
                entityManager.getTransaction().begin();
                entityManager.getTransaction().commit();
                System.out.println("UPDATE SUCCESS");
            }
        } catch (Exception e) {
            System.out.println("UPDATE FAILED");
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public static void deleteEmployee(Long id) {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Employee employee = entityManager.find(Employee.class, id);

        if (employee != null) {
            entityTransaction.begin();
            entityManager.remove(employee);
            entityTransaction.commit();
        }

        entityManager.close();
    }

    public static List<Employee> getAllEmployee() {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        return entityManager
                .createQuery("SELECT c FROM Employee c ", Employee.class).getResultList();
    }


    public static int getEmployeeSize() {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        return entityManager
                .createQuery("FROM Employee", Employee.class)
                .getResultList()
                .size();
    }
}
