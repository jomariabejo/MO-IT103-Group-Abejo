package attendance;

import com.jomariabejo.model.Attendance;
import com.jomariabejo.repository.AttendanceRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createAttendanceTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = "2022-01-09";

        Date date = new Date(sdf.format(String.valueOf(DateFormat.getDateInstance().parse(strDate))));

        System.out.println(date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
//
//        simpleDateFormat.format(strDate);
//
//        System.out.println(simpleDateFormat.format(""));
//
//        Attendance attendance = new Attendance(100001, "Crisostomo", "Jose", "2022-01-09");
//        AttendanceRepository.createAttendance();
    }
}
