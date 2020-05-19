package com.supinfo.gmy.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** 
* @Description: 时间工具类 
* @author: gaomingyang
* @date: 2020-03-27
*/
public class DateUtils {

	public static final String DEFAULT_DATE = "yyyyMMdd";
	public static final String DEFAULT_DATETIME = "yyyyMMdd HHmmssSSS";
	public static final String SIGN_DATETIME = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) {
		System.out.print(System.currentTimeMillis()/1000);

		/*Date haha = new Date();
		getDayEndTime(haha);*/

	}

	/**
	* @Description: 获取时间字符串工具类
	* 3种常见pattern
	* DEFAULT_DATE
	* DEFAULT_DATETIME
	* SIGN_DATETIME
	* @param date
	* @param pattern
	* @return 
	*/
	public static String getDate(Date date, String pattern) {
		if (date == null) {
			date = new Date();
		}
		if (org.apache.commons.lang.StringUtils.isBlank(pattern)) {
			pattern = DEFAULT_DATE;
		}
		String result = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			result = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;

	}

	/**
	* @Description: 获取时间间隔天数
	* @param smdate
	* @param bdate
	* @return
	* @throws ParseException 
	*/
	public static String daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return String.valueOf(between_days);
	}

	/**
	* @Description: 获取两个时间间隔,精度毫秒
	* @param currentDate
	* @param beferDate
	* @return 
	*/
	public static long getTwoHour(java.util.Date currentDate, java.util.Date beferDate) {
		long hours = 0;
		try {
			hours = (currentDate.getTime() - beferDate.getTime()) / (60 * 60 * 1000);
			// 这里精确到了秒，我们可以在做差的时候将时间精确到天
		} catch (Exception e) {
		}
		return hours;
	}

	/**
	* @Description: 20200326
	* @return 
	*/
	public static String getLastDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		System.out.println(sdf.format(calendar.getTime()));
		return sdf.format(calendar.getTime());
	}

	/**
	* @Description: Thu Mar 26 00:00:00 CST 2020 此值可以直接查sql库date类型数据
	* @return 
	*/
	public static Date getLastDayStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, -24);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}

	/**
	* @Description: Fri Mar 27 00:00:00 CST 2020 此值可以直接查sql库date类型数据
	* @return 
	*/
	public static Date getLastDayEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}

	// 获取某个日期的开始时间
	/**
	* @Description: Fri Mar 27 00:00:00 CST 2020  此值可以直接查sql库date类型数据
	* @param date
	* @return 
	*/
	public static Date getDayStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (null != date) {
			calendar.setTime(date);
		}
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}

	// 获取某个日期的结束时间
	/**
	* @Description: Sat Mar 28 00:00:00 CST 2020 此值可以直接查sql库date类型数据
	* @param date
	* @return 
	*/
	public static Date getDayEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (null != date) {
			calendar.setTime(date);
		}
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}

	/**
	* @Description:  获取基本参数
	*/
	public static void getBaseFunction() {
		Calendar calendar = new GregorianCalendar();
		Date trialTime = new Date();
		calendar.setTime(trialTime);
		System.out.println("ERA: " + calendar.get(Calendar.ERA));
		System.out.println("ERA: " + calendar.get(Calendar.ERA));
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));// 12:00前是0,12点后是1
		System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
		System.out.println("ZONE_OFFSET: " + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
		System.out.println("DST_OFFSET: " + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));
		System.out.println("Current Time, with hour reset to 3");
		calendar.clear(Calendar.HOUR_OF_DAY);
	}
	
}