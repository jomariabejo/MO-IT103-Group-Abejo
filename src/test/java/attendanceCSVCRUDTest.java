import com.payrollsystem.jomariabejo.model.Attendance;
import com.payrollsystem.jomariabejo.repository.CSVAttendanceRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class attendanceCSVCRUDTest {
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
        assertTrue(new CSVAttendanceRepository().matchAttendanceRecords(attendance, verifiedAttendance));

        // Check if the verified attendance exists in the CSVAttendanceRepository
        assertTrue(new CSVAttendanceRepository().isAttendanceExist(verifiedAttendance));
    }

    @Test
    public void verifyAttendanceExistenceInCSVTest() {
        // Test to verify if the provided attendance exists in the CSV file.
        Attendance attendance = new Attendance(
                10001,
                "Crisostomo",
                "Jose",
                "1/9/2022",
                "8:00",
                "17:00"
        );

        assertTrue(new CSVAttendanceRepository().isAttendanceExist(attendance));
    }

    @Test
    public void modifySecondRowLineOfCSVTest() {
        Attendance attendance = new Attendance(
                10001,
                "Crisostomo",
                "Jose",
                "1/9/2022",
                "8:45",
                "17:00"
        );
        byte rowLine = 2;
        new CSVAttendanceRepository().updateAttendance(rowLine, attendance);
        new CSVAttendanceRepository().isAttendanceExist(attendance);
    }

    /**
     * This test removes the second row line from the dataset.
     * After removal, the subsequent row lines will be shifted up to fill the gap,
     * causing the remaining data to adjust their row numbers accordingly.
     */
    @Test
    public void deleteSecondRowLineOfCSVTest() {
        // ⚠️ In the CSV file, row numbering starts at 1, unlike the array concept which starts at 0.
        new CSVAttendanceRepository().deleteAttendance(2);

        Attendance removedAttendance = new Attendance(
                10001,
                "Crisostomo",
                "Jose",
                "1/9/2022",
                "8:00",
                "17:00"
        );

        // Verify if it was removed. The 'isAttendanceExist' should return false
        assertFalse(new CSVAttendanceRepository().isAttendanceExist(removedAttendance));
    }

    /**
     * Delete multiple attendances from a CSV file using row numbers.
     */
    @Test
    public void deleteMultipleAttendanceRowLineCSVTest() {
        ArrayList<Integer> rowNumber = new ArrayList<>();
        rowNumber.add(2);
        rowNumber.add(3);
        rowNumber.add(4);
        rowNumber.add(5);
        new CSVAttendanceRepository().deleteMultipleAttendance(rowNumber);
    }

    /**
     * Ten new attendances should be created in a CSV file.
     */
    @Test
    public void addNewMultipleAttendancesCSVTest() {
        ArrayList<Attendance> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Attendance attendance = new Attendance(
                    10001,
                    "Crisostomo",
                    "Jose",
                    "1/9/2022",
                    "8:00",
                    "17:00"
            );
            list.add(attendance);
        }
        // Add all attendances to CSV
        new CSVAttendanceRepository().createMultipleAttendance(list);
    }
}
