package Attendance;

import com.jomariabejo.interface_.employee.iEmployeeAttendanceRecord;
import com.jomariabejo.repository.AttendanceRepository;

public class getAllAttendanceTest implements iEmployeeAttendanceRecord {
    public static void main(String[] args) {
        System.out.println(iEmployeeAttendanceRecord.getAllAttendance(10_001L).size());;
    }
}
