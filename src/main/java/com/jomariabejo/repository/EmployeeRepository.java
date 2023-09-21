package com.jomariabejo.repository;

import com.jomariabejo.database.HibernateUtil;
import com.jomariabejo.model.Employee;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static void createEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            String hql = "INSERT INTO Employee (lastName, firstName, birthday, address, phoneNumber, sssNumber, philhealthNumber, tinNumber, pagIbigNumber, status, position, immediateSupervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate) " +
                    "VALUES (:lastName, :firstName, :birthday, :address, :phoneNumber, :sssNumber, :philhealthNumber, :tinNumber, :pagIbigNumber, :status, :position, :immediateSupervisor, :basicSalary, :riceSubsidy, :phoneAllowance, :clothingAllowance, :grossSemiMonthlyRate, :hourlyRate)";

            Query query = session.createQuery(hql);
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("birthday", employee.getBirthday());
            query.setParameter("address", employee.getAddress());
            query.setParameter("phoneNumber", employee.getPhoneNumber());
            query.setParameter("sssNumber", employee.getSssNumber());
            query.setParameter("philhealthNumber", employee.getPhilhealthNumber());
            query.setParameter("tinNumber", employee.getTinNumber());
            query.setParameter("pagIbigNumber", employee.getPagIbigNumber());
            query.setParameter("status", employee.getStatus());
            query.setParameter("position", employee.getPosition());
            query.setParameter("immediateSupervisor", employee.getImmediateSupervisor());
            query.setParameter("basicSalary", employee.getBasicSalary());
            query.setParameter("riceSubsidy", employee.getRiceSubsidy());
            query.setParameter("phoneAllowance", employee.getPhoneAllowance());
            query.setParameter("clothingAllowance", employee.getClothingAllowance());
            query.setParameter("grossSemiMonthlyRate", employee.getGrossSemiMonthlyRate());
            query.setParameter("hourlyRate", employee.getHourlyRate());


            int rowCount = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Rows affected: " + rowCount);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "New employee : " + employee.getFirstName() + " " + employee.getLastName() + " added successfully");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    public static Employee getEmployee(int employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Employee employee = null;

        try {
            session.beginTransaction();

            employee = session.get(Employee.class, employeeId);

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employee;
    }

    public static void updateEmployee(Long id, Employee updatedEmployee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Retrieve the existing employee record by ID
            Employee existingEmployee = session.get(Employee.class, id);

            if (existingEmployee != null) {
                // Update the properties of the existing employee with values from the updatedEmployee object
                existingEmployee.setLastName(updatedEmployee.getLastName());
                existingEmployee.setFirstName(updatedEmployee.getFirstName());
                existingEmployee.setBirthday(updatedEmployee.getBirthday());
                existingEmployee.setAddress(updatedEmployee.getAddress());
                existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                existingEmployee.setSssNumber(updatedEmployee.getSssNumber());
                existingEmployee.setPhilhealthNumber(updatedEmployee.getPhilhealthNumber());
                existingEmployee.setTinNumber(updatedEmployee.getTinNumber());
                existingEmployee.setPagIbigNumber(updatedEmployee.getPagIbigNumber());
                existingEmployee.setStatus(updatedEmployee.getStatus());
                existingEmployee.setPosition(updatedEmployee.getPosition());
                existingEmployee.setImmediateSupervisor(updatedEmployee.getImmediateSupervisor());
                existingEmployee.setBasicSalary(updatedEmployee.getBasicSalary());
                existingEmployee.setRiceSubsidy(updatedEmployee.getRiceSubsidy());
                existingEmployee.setPhoneAllowance(updatedEmployee.getPhoneAllowance());
                existingEmployee.setClothingAllowance(updatedEmployee.getClothingAllowance());
                existingEmployee.setGrossSemiMonthlyRate(updatedEmployee.getGrossSemiMonthlyRate());
                existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());

                // Update the employee record in the database
                session.update(existingEmployee);

                session.getTransaction().commit();
                System.out.println("Employee record updated successfully.");
            } else {
                System.err.println("Employee with ID " + id + " not found.");
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }


    public static void deleteEmployee(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Retrieve the existing employee record by ID
            Employee employeeToDelete = session.get(Employee.class, id);

            if (employeeToDelete != null) {
                // Delete the employee record from the database
                session.delete(employeeToDelete);

                session.getTransaction().commit();
                System.out.println("Employee record with ID " + id + " deleted successfully.");
            } else {
                System.err.println("Employee with ID " + id + " not found. No deletion performed.");
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Employee> getAllEmployee() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Employee> employees = new ArrayList<>();
        try {
            String hql = "SELECT c FROM Employee c";
            Query query = session.createQuery(hql, Employee.class);
            employees = query.getResultList();

        }
        catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
            sessionFactory.close();
            session.close();
        }
        return employees;
    }


    public static String getEmployeeSize() {
        return null;
    }
}
