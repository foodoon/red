package guda.red.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by well on 2014/12/27.
 */
public class DateHelper {

    public static String lastDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        Date d =cleanMHS(calendar.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(d);
    }

    public static Date last7Day(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-7);
        return cleanMHS(calendar.getTime());
    }
    public static Date last3MonDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-3);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return calendar.getTime();
    }

    public static String formatYMD(Object d){
        if(d instanceof Date) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format((Date)d);
        }
        return null;
    }

    public static String tomorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        Date d =cleanMHS(calendar.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(d);
    }

    public static String today(){
        Calendar calendar = Calendar.getInstance();
        Date d = cleanMHS(calendar.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(d);
    }

    public static String todayYMDForDir(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }

    public static String currentTimeForDir(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss-sss");
        return dateFormat.format(new Date());
    }

    public static String lastYMDForDir(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(calendar.getTime());
    }

    public static String last2YMDForDir(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(calendar.getTime());
    }

    public static String format(long time){
        Date d = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
        return dateFormat.format(d);
    }

    public static String todayHMSForDir(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss-sss");
        return dateFormat.format(new Date());
    }

    public static Date cleanMHS(Date date){
        if(date == null){
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    public static Date endMHS(Date date){
        if(date == null){
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);
        return calendar.getTime();
    }

    public static void main(String[] args){
        System.out.println(DateHelper.last3MonDay());
    }
}
