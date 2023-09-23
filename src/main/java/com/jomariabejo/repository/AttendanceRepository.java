package com.jomariabejo.repository;

import com.jomariabejo.database.db;
import com.jomariabejo.interface_.employee.iEmployeeAttendanceRecord;
import com.jomariabejo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AttendanceRepository implements iEmployeeAttendanceRecord {
    public static void createAttendance() {

    }

    public static void deleteAttendance(Long id) {
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

    public static List<Employee> getAllAttendances() {
        return getAllAttendances();
    }



    public static Employee getSpecifiedAttendance(Long id) {
        return db
                .getInstance()
                .getEntityManager()
                .find(Employee.class, id);
    }
    public static int getAttendanceYearSize() {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT c FROM Employee c", Employee.class)
                .getResultList()
                .size();
    }

    public static void main(String[] args) {
        deleteAttendance(1L);
        System.out.println(getAttendanceYearSize());
//        System.out.println(getEmployee(1L).getEmployeeNumber());
    }
}
