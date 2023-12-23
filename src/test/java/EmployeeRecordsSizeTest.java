import com.payrollsystem.jomariabejo.model.Employee;
import com.payrollsystem.jomariabejo.utils.CsvUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EmployeeRecordsSizeTest {

    @Test
    public void addAllEmployee() throws IOException {
        CsvUtils.addAllEmployee();
        assertTrue(Employee.records.size() == 25);
    }
}
