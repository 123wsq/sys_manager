package com.wsq.sys.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {

	public static  final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
	public static  final String DATE_FORMAT_2 = "yyyyMMddHHmmss";
	public static void main(String[] args) {
		
		try {
			System.out.println(onMillisForStr(System.currentTimeMillis()+"", DATE_FORMAT_1));
			System.out.println(onYear()+onMonth()+onDay()+onHour()+onMinute()+onSecond()+ onMillisecond());
			System.out.println(onCurTime(DATE_FORMAT_2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 将当前时间转换成固定格式
	 * @param format
	 * @return
	 */
	public static String onCurTime(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}
	
	
	/**
	 * 将毫秒转换成时间格式
	 * @param time
	 * @param format
	 * @return
	 */
	public static String onMillisForStr(String time, String format) throws Exception{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		date.setTime(Long.parseLong(time));
		String str = dateFormat.format(date);
		
		return str;
	}
	
	/**
	 * 获取年份
	 * @return
	 */
	public static String onYear() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.YEAR)+"";
	}
	
	/**
	 * 月份
	 * @return
	 */
	public static String onMonth() {
		Calendar calendar = Calendar.getInstance();
		
		return (calendar.get(Calendar.MONTH)+1)+"";
	}
	
	/**
	 * 天
	 * @return
	 */
	public static String onDay() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.DAY_OF_MONTH)+"";
	}
	
	/**
	 * 小时
	 * @return
	 */
	public static String onHour() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.HOUR_OF_DAY)+"";
	}
	
	/**
	 * 分钟
	 * @return
	 */
	public static String onMinute() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.MINUTE)+"";
	}
	/**
	 * 秒
	 * @return
	 */
	public static String onSecond() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.SECOND)+"";
	}
	
	public static String onMillisecond() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.MILLISECOND)+"";
	}
	
}
