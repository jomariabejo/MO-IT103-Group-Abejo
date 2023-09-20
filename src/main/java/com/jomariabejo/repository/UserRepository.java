//package com.jomariabejo.repository;
//
//
//import com.jomariabejo.model.User;
//import jakarta.persistence.EntityManager;
//
//import java.util.List;
//
//public class UserRepository {
//    public List<User> getUser() {
//        EntityManager entityManager = db.getInstance().getEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        return entityManager.createQuery("SELECT c FROM User c ", User.class).getResultList();
//    }
//
//    public static void main(String[] args) {
//        UserRepository s = new UserRepository();
//        System.out.println(s.getUser());
//    }
//
//    public static void insertUser(User user) {
//        EntityManager entityManager = db.getInstance().getEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        entityManager.persist(user);
//        entityTransaction.commit();
//        entityManager.close();
//    }
//
//    public static void deleteUser(Long ID) {
//        EntityManager entityManager = db.getInstance().getEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        User stock = entityManager.find(User.class, ID);
//        if (stock != null) {
//            entityTransaction.begin();
//            entityManager.remove(stock);
//            entityTransaction.commit();
//        }
//        entityManager.close();
//    }
//
//    public static void updateUser(Long ID, User updatedStock) {
//
//    }
//}
//
