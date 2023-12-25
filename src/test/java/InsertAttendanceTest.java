import com.payrollsystem.jomariabejo.model.Attendance;
import com.payrollsystem.jomariabejo.repository.CSVAttendanceRepository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InsertAttendanceTest {
    @Test
    public void addNewAttendanceTest() {
        // Define a new Attendance object for Jomari Abejo on December 25, 2023, from 8:00 AM to 5:00 PM
        Attendance attendance = new Attendance(
                10000,
                "Abejo",
                "Jomari",
                "12/25/2023",
                "8:00",
                "17:00"
        );

        // Create a new attendance entry using the CSVAttendanceRepository
        new CSVAttendanceRepository().createAttendance(attendance);

        // Prepare verified attendance data for comparison
        String[] verifiedAttendance = {
                "10000",
                "Abejo",
                "Jomari",
                "12/25/2023",
                "8:00",
                "17:00"
        };

        // Check if the created attendance matches the verified attendance details
        assertTrue(new CSVAttendanceRepository().hasMatchingAttendance(attendance, verifiedAttendance));

        // Check if the verified attendance exists in the CSVAttendanceRepository
        assertTrue(new CSVAttendanceRepository().isAttendanceExist(verifiedAttendance));

        // TODO: 12/26/2023 - Create test cases for update and delete functionalities for Attendance.
    }
}
