package employeeCSVCRUDTest;

import com.payrollsystem.jomariabejo.model.Employee;
import com.payrollsystem.jomariabejo.repository.CSVEmployeeRepository;
import com.payrollsystem.jomariabejo.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class employeeCSVCRUDTest {
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository = new CSVEmployeeRepository();
    }


    @Test
    public void EmployeeCRUDTest() throws IOException {

        // Create a new employee in the CSV.
        employeeRepository.createEmployee(new Employee(
                "10026",
                "lastNameTest",
                "firstNameTest",
                "February 28, 2000",
                "Brgy. Di Matagpuan, Biringan, Samar",
                "918-621-604", "49-1632020-9", "382189453146", "317-674-022-001", "441093369647",
                "Probationary", "Junior Java Developer"
                , "",
                22_500, 555, 1_050, 0, 11250, 133.93f));


        // Update the details of the employee in the CSV at line number 27.
        employeeRepository.updateEmployee(27,
                new String[] {
                        "10026",
                        "Abejo",
                        "Jomari",
                        "\"February 28, 2000\"",
                        "\"Brgy. Ping 192.168.1.1\"",
                        "918-621-604",
                        "49-1632020-9",
                        "382189453146",
                        "317-674-022-001",
                        "441093369647",
                        "Probationary",
                        "Junior Java Developer",
                        "Uchiha Sasuke",
                        "\"22,500\"",
                        "555",
                        "\"1,050\"",
                        "0",
                        "\"11,250\"",
                        "133.93"
                });
        assertTrue(employeeRepository.isEmployeeExist("10026"));

        /**
         * Check if updated successfully
         */
        assertTrue(employeeRepository.getEmployeeByID(10026).toString().contains("Brgy. Ping 192.168.1.1"));
    }

    @After
    public void tearDown() {

        // Delete employee with ID 27 from the CSV.
        employeeRepository.deleteEmployee(27);

        // Check if employee with number 10026 (line 27) was successfully deleted.
        assertFalse(employeeRepository.isEmployeeExist("10026"));
    }
}
