package com.platform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {
	// 显示日期的各种格式
	public static final String Y_FORMAT = "yyyy";
	public static final String Y_M_FORMAT = "yyyy-MM";
	public static final String Y_M_D_FORMAT = "yyyy-MM-dd";
	public static final String Y_M_D_HMS_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YM_FORMAT = "yyyyMM";
	public static final String YMD_FORMAT = "yyyyMMdd";
	public static final String YMDHMS_FORMAT = "yyyyMMddHHmmss";

	// 默认显示简体中文日期时间的格式
	public static final String ZHCN_Y_M_D_FORMAT = "yyyy年MM月dd日";
	public static final String ZHCN_Y_M_D_HMS_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";
	public static final String ZHCN_Y_M_DHM_FORMAT = "yyyy年MM月dd日HH时mm分";

	/**
	 * 将日期类型对象按指定格式转化成string类型
	 * 
	 * @param date
	 *            传入DATE类型数据
	 * @param pattern
	 *            传入的格式
	 * @return 根据指定格式,格式化日期
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null)
			return null;
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将String类型的日期转换为Date对象
	 * 
	 * @param dateString
	 *            代表日期的字符串
	 * @param style
	 *            转换格式
	 * @return 日期对象
	 */
	public static Date stringToDate(String dateString, String style) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(style,
					Locale.CHINESE);
			return format.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 计算当前月份天数
	 * 
	 * @return
	 */
	public static int getCurentMonthDay() {
		Date date = Calendar.getInstance().getTime();
		return getMonthDay(date);

	}

	public static int getMonthDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 得到当前日期d的月底的前/后若干天的时间,<0表示之前，>0表示之后
	 * 
	 * @param d
	 * @param days
	 * @return
	 */
	public static Date getInternalDateByDay(Date d, int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.DATE, days);
		return now.getTime();

	}

	public static String getInternalDateByLastDay(Date d, int days) {
		return formatDate(getInternalDateByDay(d, days), Y_M_D_FORMAT);

	}
	
	public static Date addTime(Date date,int CalendarType,int count){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(CalendarType, count);
		return calendar.getTime();
	}
	/**
	 * 计算两个时间相差多少个小时
	 * @param endDate 
	 * @param nowDate
	 * @return
	 */
	public static String getDistanceHour(String beginDateStr, String endDateStr) {
		SimpleDateFormat format = new SimpleDateFormat(Y_M_D_HMS_FORMAT);
		java.util.Date beginDate;
		java.util.Date endDate;
		long nh = 1000 * 60 * 60;
		long hours = 0;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			long diff = (endDate.getTime()-beginDate.getTime());//得到毫秒 
			hours = diff/nh;  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hours + "小时";
	}
	
}
