package cn.mq.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class DateUtil {

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATEMINUTE = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_LONG_DATETIME = "yyyyMMddHHmmss";
    public static final String FORMAT_LONG_DATE = "yyyyMMdd";
    public static final String FORMAT_TIME = "HH:mm:ss";

    /**
     * 格式化日期
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 格式化日期
     */
    public static String formatDatetime(Date date) {
        return format(date, FORMAT_DATETIME);
    }

    /**
     * 格式化日期格式  yyyy-MM-dd
     */
    public static String formatDate(Date date) {
        return format(date, FORMAT_DATE);
    }

    /**
     * 格式化时间格式 HH:mm:ss
     */
    public static String formatLongDatetime(Date date) {
        return format(date, FORMAT_LONG_DATETIME);
    }

    /**
     * 转换日期
     */
    public static Date parse(String formatDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(formatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换日期
     */
    public static Date parseDateTime(String formatDate) {
        return parse(formatDate, FORMAT_DATETIME);
    }

    public static Date parseDate(String formatDate) {
        return parse(formatDate, FORMAT_DATE);
    }

    public static Date parseTimestamp(long timestamp) {
        Date date = new Date();
        timestamp = timestamp * 1000;
        date.setTime(timestamp);
        return date;
    }

    public static Date parseTimestampWithMilliseonds(long timestamp) {
        Date date = new Date();
        date.setTime(timestamp);
        return date;
    }


    /**
     * 获取日期date前后的第几天
     */
    public static Date gapDay(Date date, int gapDay) {
        Calendar calendar = getCalendar(date);
        addDay(calendar, gapDay);
        return calendar.getTime();
    }

    /**
     * 获取日期date前后的第几天
     */
    public static Date gapDayAndClearTime(Date date, int gapDay) {
        Calendar calendar = getCalendar(date);
        addDay(calendar, gapDay);
        clearTime(calendar);
        return calendar.getTime();
    }

    /**
     * 在calendar上添加天数
     */
    public static void addDay(Calendar calendar, int day) {
        calendar.add(Calendar.DATE, day);
    }

    /**
     * 获取当前时刻
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 获取当天
     */
    public static Date getTodayAndClearTime() {
        Calendar calendar = getCalendarAndClearTime(null);
        return calendar.getTime();
    }
    /**
     * 获取昨天
     */
    public static Date getYestoryDay() {
        return gapDay(null, -1);
    }

    public static Date getYestorDayAndClearTime(){
        return clearTime(getYestoryDay());
    }

    /**
     * 获取明天
     */
    public static Date getTomorrow() {
        return gapDay(null, 1);
    }

    /**
     * 获取第二天零点时刻
     */
    public static Date getTomorrowAndClearTime() {
        return clearTime(getTomorrow());
    }

    /**
     * 获取星期几
     */
    public static String getWeek(Date date) {
        if (date == null) {
            date = new Date();
        }
        String[] weeks = {"", "日", "一", "二", "三", "四", "五", "六"};
        Calendar calendar = getCalendar(date);
        int d = calendar.get(Calendar.DAY_OF_WEEK);
        return weeks[d];
    }


    /**
     * 在calendar上添加月份
     */
    public static void addMonth(Calendar calendar, int month) {
        calendar.add(Calendar.MONTH, month);
    }





    /**
     * 清空日期里的时间
     */
    public static Date clearTime(Date date) {
        Calendar calendar = getCalendarAndClearTime(date);
        return calendar.getTime();
    }

    /**
     * 清空日期里的时间
     */
    public static void clearTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 根据date获取Calendar对象
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return calendar;
    }

    /**
     * 清空日期里的时间
     */
    public static Calendar getCalendarAndClearTime(Date date) {
        Calendar calendar = getCalendar(date);
        clearTime(calendar);
        return calendar;
    }

    /**
     * 获取两个日期之间的间隔
     */
    public static int betweenDateByDay(Date startDate, Date endDate) {
        long t1 = startDate.getTime();
        long t2 = endDate.getTime();
        return (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取随机日期
     */
    public static Date getRandomTime(int day) {
        Random r = new Random();
        int m = r.nextInt(day);
        long t1 = System.currentTimeMillis();
        return parseTimestampWithMilliseonds(t1 - m * 24 * 3600 * 100 - (m + 1) * 3600 * 800);
    }

    /**
     * 根据年和月获取Calendar实例
     */
    public static Calendar getCalendar(int year, int month) {
        Calendar calendar = getCalendarAndClearTime(null);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return calendar;
    }

    /**
     * 根据年和月获取Calendar实例
     */
    public static Calendar getCalendar(int year, int month, int day) {
        Calendar calendar = getCalendarAndClearTime(null);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        return calendar;
    }

    /**
     * 获取某个月份下的第一天和最后一天
     */
    public static Date[] getFLDatesInMonth(int year, int month) {
        Calendar calendar = getCalendar(year, month);
        Date firstDate = calendar.getTime();
        firstDate = getFirstDayOfMonth(firstDate);
        calendar.add(Calendar.MONTH, 1);
        Date lastDate = calendar.getTime();
        lastDate = getFirstDayOfMonth(lastDate);
        return new Date[]{firstDate, lastDate};
    }

    /**
     * 获取某一天的第一天和第二天
     */
    public static Date[] getFLDay(int year, int month, int day) {
        Calendar calendar = getCalendar(year, month, day);
        clearTime(calendar);
        Date currentDay = calendar.getTime();
        addDay(calendar, 1);
        Date nextDay = calendar.getTime();
        return new Date[]{currentDay, nextDay};
    }

    /**
     * 判断某一日期是否在某个月内,不指定年份
     */
    public static boolean isDateInMonth(Date date, int startMonth, int endMonth) {
        Calendar calendar = getCalendar(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month > startMonth && month < endMonth;
    }


    /**
     * 判断某一日期是否在某个月内,指定年份
     */
    public static boolean isDateInMonth(Date date, int startMonth, int endMonth, int year) {
        Calendar calendar = getCalendar(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month > startMonth && month < endMonth && year == calendar.get(Calendar.YEAR);
    }

    /**
     * 判断某一日期是否在某天内
     */
    public static boolean isDateInDay(Date date, int startDay, int endDay) {
        Calendar calendar = getCalendar(date);
        int day = calendar.get(Calendar.DATE);
        return day >= startDay && day < endDay;
    }


    /**
     * 获取一个月里有多少天
     */
    public static int getDaysOfMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = getCalendar(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某一个月有多少天
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = getCalendar(year, month);
        return getDaysOfMonth(calendar.getTime());
    }

    /**
     * 获取当前月的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        String mm = format(date, "yyyy-MM-01");
        return parse(mm, "yyyy-MM-dd");
    }

    /**
     * 获取当前月的最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        int maxDay = getDaysOfMonth(date);
        String mm = format(date, "yyyy-MM-" + maxDay);
        return parse(mm, "yyyy-MM-dd");
    }

}