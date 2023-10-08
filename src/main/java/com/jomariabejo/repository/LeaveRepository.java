package com.jomariabejo.repository;

import com.jomariabejo.database.db;
import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Leave;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LeaveRepository {
    public static void createLeave(Leave leave) {
        if (isAllowedToCreateLeave()) {

            if (isLeaveDoesNotExist()) {
                EntityManager entityManager = db.getInstance().getEntityManager();
                EntityTransaction entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.persist(leave);
                entityTransaction.commit();
                entityManager.close();
            }
            else {
                System.out.println("Leave already exist, employee can't create leave with the same date...");
            }
        }
        else {
            System.out.println("Employee is not allowed to create leave based on company policy, emergency = 5, vacation = 10, sick = 5");
        }
    }


    public static List<Leave> getLeave() {
        return db
                .getInstance()
                .getEntityManager()
                .createQuery("FROM Leave", Leave.class)
                .getResultList();
    }

    public static List<Leave> getLeave(long employeeNumber) {
        return db
                .getInstance()
                .getEntityManager()
                .createQuery("SELECT c FROM Leave c WHERE c.leaveId= :employeeNumber", Leave.class)
                .getResultList();
    }

    public static List<Leave> getLeave(long employeeNumber, short year) {
        return db
                .getInstance()
                .getEntityManager()
                .createQuery("SELECT c FROM Leave c WHERE  c.leaveId = :employeeNumber AND YEAR(c.date) = :year", Leave.class)
                .getResultList();
    }

    public static List<Leave> getLeave(long employeeNumber, short year, String type) {
        return db
                .getInstance()
                .getEntityManager()
                .createQuery("SELECT c FROM Leave c WHERE  c.leaveId = :employeeNumber AND YEAR(c.date) = :year AND c.type = :type", Leave.class)
                .getResultList();
    }

    public static void getLeaveSize() {

    }

    public static void getLeaveSize(long employeeNumber) {

    }

    public static void getLeaveSize(long employeeNumber, short year) {

    }

    public static boolean isAllowedToCreateLeave() {
        return false;
    }

    public static boolean isLeaveDoesNotExist() {
        return false;
    }

    public static void updateLeave() {

    }

    public static void deleteLeave() {

    }

}
