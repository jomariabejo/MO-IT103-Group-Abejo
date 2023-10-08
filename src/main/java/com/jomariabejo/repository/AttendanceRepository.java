package com.jomariabejo.repository;

import com.jomariabejo.database.db;
import com.jomariabejo.interface_.employee.iAttendanceRecord;
import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;
import java.util.List;

public class AttendanceRepository {

    /**
     * Retrieves a list of Attendance records for a given employee based on their employeeNumber.
     *
     * @param employeeNumber The unique identifier of the employee.
     * @return A List of Attendance objects associated with the specified employeeNumber.
     */
    static List<Attendance> getAllAttendance(long employeeNumber) {
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
     * Retrieves a list of Attendance records for a given employee, year, and month.
     *
     * @param employeeNumber The employee's unique identifier.
     * @param year           The year for which attendance records are to be retrieved.
     * @param month          The month for which attendance records are to be retrieved.
     * @return A List of Attendance objects associated with the specified employeeNumber, year, and month.
     */
    List<Attendance> getAllAttendance(int employeeNumber, int year, int month) {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT a FROM Attendance a WHERE a.employeeNumber = :employeeNumber AND YEAR(a.date) = :year AND MONTH(a.date) = :month", Attendance.class)
                .setParameter("employeeNumber", employeeNumber)
                .setParameter("year", year)
                .setParameter("month", month)
                .getResultList();
    }


    /**
     * Inserts a new attendance record into the attendance table if it doesn't already exist.
     *
     * @param attendance The new attendance record to be added
     */
    public static void createAttendance(Attendance attendance) {
        EntityManager em = db.getInstance().getEntityManager();

        String firstName = attendance.getFirstName();
        String lastName = attendance.getLastName();
        Date date = attendance.getDate();

        Long attendanceCount = em.createQuery("SELECT COUNT(c) FROM Attendance c WHERE c.firstName = :firstName AND c.lastName = :lastName AND c.date = :date", Long.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("date", date)
                .getSingleResult();

        if (attendanceCount == 0) {
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();
                em.persist(attendance);
                transaction.commit();
                System.out.println("Attendance added successfully...");
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
        } else {
            System.out.println("Attendance already exists...");
        }
    }

    /**
     * Removes attendance records by their unique ID.
     * @param id The ID of the attendance record to be deleted.
     */
    public static void deleteAttendance(Long id) {
        try {
            EntityManager entityManager = db.getInstance().getEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            Employee employee = entityManager.find(Employee.class, id);
            if (employee != null) {
                entityTransaction.begin();
                entityManager.remove(employee);
                entityTransaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Updates an existing attendance record.
     *
     * @param attendanceID The unique ID of the attendance record to be updated.
     * @param attendance   The updated Attendance object containing new values.
     */
    public static void updateAttendance(Long attendanceID, Attendance attendance) {
        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Attendance attendanceToBeUpdated = entityManager.find(Attendance.class, attendanceID);

        attendanceToBeUpdated.setEmployeeNumber(attendance.getEmployeeNumber());
        attendanceToBeUpdated.setLastName(attendance.getLastName());
        attendanceToBeUpdated.setFirstName(attendance.getFirstName());
        attendanceToBeUpdated.setDate(attendance.getDate());
        attendanceToBeUpdated.setTimeIn(attendance.getTimeIn());
        attendanceToBeUpdated.setTimeOut(attendance.getTimeOut());

        entityTransaction.begin();
        entityTransaction.commit();
        entityManager.close();
    }

    public static void main(String[] args) {
        AttendanceRepository.getAllAttendance(10001).size();
    }
}
