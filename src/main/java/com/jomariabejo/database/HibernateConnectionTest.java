package com.jomariabejo.database;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateConnectionTest {
    public static void main(String[] args) {
        // Get a Hibernate session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Perform a simple database operation to test the connection
            int rowCount = (int) session.createNativeQuery("SELECT 1").uniqueResult();
            System.out.println("Database connection test successful. Row count: " + rowCount);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

