package com.jomariabejo.database;

import java.util.Properties;

import com.jomariabejo.model.Attendance;
import com.jomariabejo.model.Employee;
import com.jomariabejo.model.Leave;
import com.jomariabejo.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static HibernateUtil Instance;

    public static HibernateUtil getInstance() {
        if (Instance == null) Instance = new HibernateUtil();
        return Instance;
    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/motorph");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "@L03e1t3");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Leave.class);
                configuration.addAnnotatedClass(Attendance.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}