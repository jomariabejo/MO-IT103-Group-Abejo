package com.jomariabejo.interface_.employee;

import com.jomariabejo.database.db;
import com.jomariabejo.model.Attendance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public interface iAttendanceRecord {

    /**
     * Retrieves a list of Attendance records for a given employee based on their employeeID.
     *
     * @param employeeNumber The unique identifier of the employee.
     * @return A List of Attendance objects associated with the specified employeeID.
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
     * @param year The year for which attendance records are to be retrieved.
     * @return A List of Attendance objects associated with the specified employeeNumber and year.
     */
    static List<Attendance> getAllAttendance(int employeeNumber, int year) {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT a FROM Attendance a WHERE a.employeeNumber = :employeeNumber AND YEAR(a.date) = :year", Attendance.class)
                .setParameter("employeeNumber", employeeNumber)
                .setParameter("year", year)
                .getResultList();

    }
}
