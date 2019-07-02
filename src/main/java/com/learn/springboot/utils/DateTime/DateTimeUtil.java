package com.learn.springboot.utils.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * DateTime Utils
 */
public class DateTimeUtil {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat();


    public static Date date(long time) {
        return new Date(time);
    }


    public static Calendar calendar(long time) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }


    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }


    public static long currentTimeNano() {
        return System.nanoTime();
    }


    public static long currentTimeSecond() {
        return System.currentTimeMillis()/1000;
    }


    /**
     * yyyy-MM-dd HH:mm:ss
     * @return String formatted time
     */
    public static String time(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getDefault());
        return format.format(date);
    }


    /**
     * yyyy-mm-dd
     * @return String formatted date
     */
    public static String day(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getDefault());
        return format.format(date);
    }


    /**
     * month of the day
     * @return int formatted month
     */
    public static int month(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }


    /**
     * Year of the day
     * @return int formatted year
     */
    public static int year(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    /**
     * Quarter of the year
     * @param date date
     * @return int
     */
    public static int quarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (calendar.get(Calendar.MONTH) / 3) + 1;
    }


    /**
     * Week of the year
     * @return int
     */
    public static int weekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * Week of the month
     * @return int
     */
    public static int weekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }


    /**
     * Day of the year
     * @return int
     */
    public static int dayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }


    /**
     * Day of the month
     * @return int
     */
    public static int dayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * Day of the week
     * @return int
     */
    public static int dayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * Hour of the Day
     * @return int
     */
    public static int hour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * Minute of the hour
     * @return int
     */
    public static int minute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * Second of the minute
     * @return int
     */
    public static int second(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }


    /**
     * Millisecond of a second
     * @return int
     */
    public static int millsecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * Check if it is morning
     * @param date current date value
     * @return is or not AM
     */
    public static boolean isAM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return isAM(calendar);
    }

    /**
     * Check if it is morning
     * @param calendar current calendar value
     * @return is or not AM
     */
    public static boolean isAM(Calendar calendar) {
        return calendar.get(Calendar.AM_PM) == Calendar.AM;
    }


    /**
     * Check if it is afternoon
     * @param date current date value
     * @return is or not PM
     */
    public static boolean isPM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return isPM(calendar);
    }


    /**
     * Check if it is afternoon
     * @param calendar current calendar value
     * @return is or not PM
     */
    public static boolean isPM(Calendar calendar) {
        return calendar.get(Calendar.AM_PM) == Calendar.PM;
    }


    /**
     * Determine current year
     * @return int
     */
    public static int thisYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }


    /**
     * Determine current month of the year
     * @return int
     */
    public static int thisMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }


    /**
     * Determine current day of the year
     * @return int
     */
    public static int thisDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
    }


    /**
     * Determine current hour of the day
     * @return int
     */
    public static int thisHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }


    /**
     * Determine current second of the hour
     * @return int
     */
    public static int thisSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }


    /**
     * Determine current ms of the second
     * @return int
     */
    public static int thieMillis() {
        return Calendar.getInstance().get(Calendar.MILLISECOND);
    }
}
