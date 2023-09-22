package com.jomariabejo.database;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class db {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory entityManagerFactory;
    private static db instance;
    private db() {
    }
    public static db getInstance() {
        if (instance == null) {
            synchronized (db.class) {
                if (instance == null) {
                    instance = new db();
                }
            }
        }
        return instance;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}

