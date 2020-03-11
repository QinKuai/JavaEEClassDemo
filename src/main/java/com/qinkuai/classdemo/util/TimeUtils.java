package com.qinkuai.classdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 时间工具类
public class TimeUtils {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private TimeUtils() {}
	
	public static String dateToString(Date date) {
		return format.format(date);
	}
	
	public static String dateToString(Date date, int lastTime) {
		Date after = new Date(date.getTime() + lastTime * 3600000);
		return format.format(after);
	}
	
	public static Date stringToDate(String dateStr) throws ParseException{
		return format.parse(dateStr);
	}
}
