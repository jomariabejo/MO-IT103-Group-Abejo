package com.jomariabejo.interface_.employee;

import com.jomariabejo.database.db;
import com.jomariabejo.model.Attendance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public interface iEmployeeAttendanceRecord {
     static List<Attendance> getAllAttendance(long employeeID) {
        return db.getInstance().getEntityManager()
                .createQuery("SELECT a FROM Attendance a WHERE a.employee.id = :employeeID", Attendance.class)
                .setParameter("employeeID", employeeID)
                .getResultList();
    }

    static List<Attendance> getAllAttendance(int employeeNumber, int year) {
        EntityManager entityManager = db.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Attendance a WHERE a.employeeNumber = :employeeNumber AND YEAR(a.date) = :year";

        Query query = entityManager.createQuery(jpql, Attendance.class);
        query.setParameter("employeeNumber", employeeNumber);
        query.setParameter("year", year);

        List<Attendance> attendanceList = query.getResultList();

        entityManager.close();

        return attendanceList;
    }
}
