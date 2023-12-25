import com.payrollsystem.jomariabejo.model.Attendance;
import com.payrollsystem.jomariabejo.repository.CSVAttendanceRepository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InsertAttendanceTest {
    @Test
    public void addNewAttendanceTest() {
        Attendance attendance = new Attendance(
                10000,
                "Abejo",
                "Jomari",
                "12/25/2023",
                "8:00",
                "17:00"
        );
        new CSVAttendanceRepository().createAttendance(attendance);
        String [] verifiedAttendance = {
                "10000",
                "Abejo",
                "Jomari",
                "12/25/2023",
                "8:00",
                "17:00"
        };
        assertTrue(new CSVAttendanceRepository().hasMatchingAttendance(attendance,verifiedAttendance));
    }
}
