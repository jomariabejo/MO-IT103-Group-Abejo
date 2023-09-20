import com.jomariabejo.database.HibernateUtil;
import com.jomariabejo.model.User;
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

        // Get a Hibernate session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Save the user to the database
            session.save(user);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("User saved to the database with ID: " + user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
