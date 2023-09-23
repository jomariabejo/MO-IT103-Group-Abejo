package attendance;

import com.jomariabejo.interface_.employee.iEmployeeAttendanceRecord;

public class getAllAttendanceTest implements iEmployeeAttendanceRecord {
    public static void main(String[] args) {
        System.out.println(iEmployeeAttendanceRecord.getAllAttendance(10_001L).size());;
    }
}
