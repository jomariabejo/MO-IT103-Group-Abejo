package attendance;

import com.jomariabejo.model.Attendance;
import com.jomariabejo.repository.AttendanceRepository;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createAttendanceTest {
    public static void main(String[] args) throws ParseException {
        String strDate = "01-09-2022";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = df.parse(strDate);
        System.out.println(date);

        Time timeIn = new Time(8,0,0);
        Time timeOut = new Time(17, 0, 0);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
//
//        simpleDateFormat.format(strDate);
//
//        System.out.println(simpleDateFormat.format(""));
//
        Attendance attendance = new Attendance(10001, "Crisostomo", "Jose",date, timeIn, timeOut);
        AttendanceRepository.createAttendance(attendance);
    }
}
