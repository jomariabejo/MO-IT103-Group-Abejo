package employee;

import com.jomariabejo.model.Employee;
import com.jomariabejo.repository.EmployeeRepository;

public class FindEmployeeTest {
    public static void main(String[] args) {
        /*
            Find employee with an id 1 exist to our database;
            It is expected to return true

            Reminder: you need first to create or store to employee table atleast one employee so this method works
        */
        int findEmployeeNumber = 11;

        Employee employee = (EmployeeRepository.getEmployee(findEmployeeNumber));

        boolean isEmployeeNumberExist = employee != null && employee.getEmployeeNumber() == findEmployeeNumber;

        boolean isEmployeeTableEmpty = EmployeeRepository.getEmployeeSize() == 0;

        System.out.println(isEmployeeNumberExist
                ? ("Yes, employee number with id " + findEmployeeNumber +"  found😁")
                : (isEmployeeTableEmpty)
                    ? "Sorry but employee table is empty 🫗"
                    : ("Employee number " + findEmployeeNumber + " not found.🥲"));
    }
}
