package attendance;

import com.jomariabejo.interface_.employee.iAttendanceRecord;

public class getAllAttendanceTest implements iAttendanceRecord {
    public static void main(String[] args) {
        System.out.println(iAttendanceRecord.getAllAttendance(10_001L).size());;
    }
}
