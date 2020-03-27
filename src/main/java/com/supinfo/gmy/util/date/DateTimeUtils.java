package com.supinfo.gmy.util.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/** 
* @Description: 基于java8的日期工具类DateTimeUtils,线程安全因此最好使用此类
* @author: gaomingyang
* @date: 2020-03-27
*/
public class DateTimeUtils {
	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		System.out.println(this.getCurrentLocalDate());
		System.out.println(this.getCurrentLocalDateTime());
		System.out.println(getStartOfDay(LocalDate.now()));
		System.out.println(getEndOfDay(LocalDate.now()));
		System.out.println(this.getCurrentDateTimeStr());
		System.out.println(this.getCurrentDateStr());
		System.out.println(this.getCurDateAfterTwoWeek());
		System.out.println(this.getCurDateAfterSixMonth());
		System.out.println(this.getCurDateAfterFiveYear());
		System.out.println(this.getFirstDayOfThisMonth());
		System.out.println(this.getLastDayOfThisMonth());
		System.out.println(this.getFirstMonday());
		System.out.println(this.getCurDateAfterTwentyYear());

	}

	// 一天的开始
	public static LocalDateTime getStartOfDay(LocalDate date) {
		LocalDateTime time = LocalDateTime.of(date, LocalTime.MIN);
		return time;
	}

	public static LocalDateTime getStartOfDay() {
		return getStartOfDay(LocalDate.now());
	}

	/**
	 * 一天的结束
	 */
	public static LocalDateTime getEndOfDay(LocalDate date) {
		LocalDateTime time = LocalDateTime.of(date, LocalTime.MAX);
		return time;
	}

	public static LocalDateTime getEndOfDay() {
		return getEndOfDay(LocalDate.now());
	}

	/**
	 * 返回当前的日期
	 * 
	 * @return
	 */
	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	/**
	 * 返回当前日期时间
	 * 
	 * @return
	 */
	public static LocalDateTime getCurrentLocalDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * 返回当前日期字符串 yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		return LocalDate.now().format(DATE_FORMATTER);
	}

	/**
	 * 返回当前日期时间字符串 yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeStr() {
		return LocalDateTime.now().format(DATETIME_FORMATTER);
	}

	public static LocalDate parseLocalDate(String dateStr, String pattern) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
		return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 日期相隔天数
	 * 
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 */
	public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getDays();
	}

	/**
	 * 日期相隔小时
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toHours();
	}

	/**
	 * 日期相隔分钟
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMinutes();
	}

	/**
	 * 日期相隔毫秒数
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMillis();
	}

	/**
	 * 是否当天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(LocalDate date) {
		return getCurrentLocalDate().equals(date);
	}

	/**
	 * 获取本月的第一天
	 * 
	 * @return
	 */
	public static String getFirstDayOfThisMonth() {
		return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
	}

	/**
	 * 获取本月的最后一天
	 * 
	 * @return
	 */
	public static String getLastDayOfThisMonth() {
		return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
	}

	/**
	 * 获取2017-01的第一个周一
	 * 
	 * @return
	 */
	public static String getFirstMonday() {
		return LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
				.format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的后两周
	 * 
	 * @return
	 */
	public static String getCurDateAfterTwoWeek() {
		return getCurrentLocalDate().plus(2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的6个月后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterSixMonth() {
		return getCurrentLocalDate().plus(6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的5年后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterFiveYear() {
		return getCurrentLocalDate().plus(5, ChronoUnit.YEARS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的20年后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterTwentyYear() {
		return getCurrentLocalDate().plus(2, ChronoUnit.DECADES).format(DATE_FORMATTER);
	}

}
