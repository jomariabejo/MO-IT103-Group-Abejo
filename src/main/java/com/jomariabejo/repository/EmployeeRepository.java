package com.jomariabejo.repository;

import com.jomariabejo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.jomariabejo.database.db;

import java.util.Collections;
import java.util.List;

public class EmployeeRepository {
    private static final EntityManager entityManager = db.getInstance().getEntityManager();

    public static void createEmployee(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
//            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        }
    }

    public static Employee getEmployee(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
//            entityTransaction.begin();
            return entityManager.find(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return null;
        }
    }

    public static void updateEmployee(Long id, Employee employeeNewValues) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Employee employee = entityManager.find(Employee.class, id);

        try {
            if (employee != null) {
                employee.injectNewValues(employee, employeeNewValues);
//                entityTransaction.begin();
                entityTransaction.commit();
                System.out.println("UPDATE SUCCESS");
            }
        } catch (Exception e) {
            System.out.println("UPDATE FAILED");
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        }
    }

    public static boolean deleteEmployee(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Employee employee = entityManager.find(Employee.class, id);

        try {
            if (employee != null) {
                entityTransaction.begin();
                entityManager.remove(employee);
                entityTransaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        }
        return false;
    }

    public static List<Employee> getAllEmployee() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
//            entityTransaction.begin();
            return entityManager
                    .createQuery("SELECT c FROM Employee c ", Employee.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return Collections.emptyList();
        }
    }

    public static int getEmployeeSize() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
//            entityTransaction.begin();
            return entityManager
                    .createQuery("FROM Employee", Employee.class)
                    .getResultList()
                    .size();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return 0;
        }
    }
}
