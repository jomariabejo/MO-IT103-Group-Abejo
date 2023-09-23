package com.jomariabejo.repository;

import com.jomariabejo.database.db;
import com.jomariabejo.interface_.employee.iAttendanceRecord;
import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;
import java.util.List;

public class AttendanceRepository implements iAttendanceRecord {

    /**
     * Retrieves a list of Attendance records for a given employee based on their employeeID.
     *
     * @param employeeNumber The unique identifier of the employee.
     * @return A List of Attendance objects associated with the specified employeeID.
     */
    List<Attendance> getAllAttendance(long employeeNumber) {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT a FROM Attendance a WHERE a.employee.id = :employeeID", Attendance.class)
                .setParameter("employeeID", employeeNumber)
                .getResultList();
    }



    /**
     * Retrieves a list of Attendance records for a given employee and year.
     *
     * @param employeeNumber The employee's unique identifier.
     * @param year           The year for which attendance records are to be retrieved.
     * @return A List of Attendance objects associated with the specified employeeNumber and year.
     */
    List<Attendance> getAllAttendance(int employeeNumber, int year) {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT a FROM Attendance a WHERE a.employeeNumber = :employeeNumber AND YEAR(a.date) = :year", Attendance.class)
                .setParameter("employeeNumber", employeeNumber)
                .setParameter("year", year)
                .getResultList();
    }

    /**
     * Inserts new attendance row to attendance tbl
     */
    public static void createAttendance(Attendance attendance) {
        /** Declare arguments, for firstname, lastname and date */
        String
                fastName = attendance.getFirstName() ,
                lastName = attendance.getLastName();
        Date
                date = attendance.getDate();

        /** Check if attendance already exist */
        Boolean isAttendanceExist = db.getInstance().getEntityManager().createQuery("SELECT c FROM Attendance c WHERE c.firstName = firstName AND c.lastName = lastName AND c.date = date").getSingleResult() != null;

        /** If it don't exist then... Insert new attendance...*/
        if (isAttendanceExist) {
            db.getInstance().getEntityManager().persist(attendance);
        }
        else {
            System.out.println("Attendance already exist...");
        }
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
