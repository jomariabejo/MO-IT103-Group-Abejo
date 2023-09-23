package user;

import com.jomariabejo.database.db;
import com.jomariabejo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class CreateUserTest {
    public static void main(String[] args) {
        // Create a new user
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        user.setRole(User.UserRole.Customer); // Set the user role
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDateOfBirth(new Date()); // Set the date of birth
        user.setAddress("123 Main St");
        user.setPhoneNumber("123-456-7890");

        EntityManager entityManager = db.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            // Begin a transaction

            // Save the user to the database
            entityManager.persist(user);

            // Commit the transaction
            entityTransaction.commit();

            System.out.println("User saved to the database with ID: " + user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
