package com.fincon.umeedsey_android_app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheckClass {

	public int DateChecker(String CurrentDate, String inputDate) {

		int result = 0;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(CurrentDate);
			Date date2 = sdf.parse(inputDate);

			System.out.println(sdf.format(date1));
			System.out.println(sdf.format(date2));

			if (date1.after(date2)) {
				// System.out.println("Date1 is after Date2");

				result = 1;
			}

			if (date1.before(date2)) {
				// System.out.println("Date1 is before Date2");
				result = 2;
			}

			if (date1.equals(date2)) {
				// System.out.println("Date1 is equal Date2");
				result = 3;
			}

		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return result;
	}


}
