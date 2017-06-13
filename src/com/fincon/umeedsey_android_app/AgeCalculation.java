package com.fincon.umeedsey_android_app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgeCalculation {
	public static int deliveryDay;
	public static int deliveryMonth;
	public static int deliveryYear;

	public int AgeCal(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day);
		Calendar now = new GregorianCalendar();
		int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
				|| (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal
						.get(Calendar.DAY_OF_MONTH) > now
						.get(Calendar.DAY_OF_MONTH))) {
			res--;
		}

		return res;
	}

	public static String DeliveryDate(int year, int month, int day) {

		int monthsToAdd = 9;

		Calendar c = new GregorianCalendar(year, month, day);

		// add months to current date
		c.add(Calendar.MONTH, monthsToAdd);
		c.add(Calendar.DAY_OF_MONTH, 7);

		String ExpectedDate = (c.get(Calendar.MONTH) + 1) + "-"
				+ c.get(Calendar.DATE) + "-" + c.get(Calendar.YEAR);

		return ExpectedDate;

	}

}