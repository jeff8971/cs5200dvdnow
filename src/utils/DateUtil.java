package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Time and date processing class
 */
public class DateUtil {

    // Calculate the return deadline
    public  String addDate(String date,int days) throws Exception {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(date);
        calendar.setTime(parse);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int newDay = day+days+1;  // The return deadline is the next day at 0 o'clock
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,newDay);
        return format.format(calendar.getTime());
    }

    // Get the current date and time
    public String nowDate(){
        Calendar cal=Calendar.getInstance();
        int year =cal.get(Calendar.YEAR);
        int month =cal.get(Calendar.MONTH)+1;  // Month starts from 0 in Calendar
        int day =cal.get(Calendar.DAY_OF_MONTH);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;

    }

    // Compare two dates
    public boolean compareDate(String time1,String time2) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date a= null;
        Date b=null;
        try {
            a = sdf.parse(time1);
            b=sdf.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // If 'a' is earlier than 'b', return true; otherwise, return false
        assert a != null;
        return a.before(b);
    }

}
