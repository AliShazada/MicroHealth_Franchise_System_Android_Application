package com.fincon.umeedsey_android_app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

public class WeekClass {

	Date date1;
	Date date2;
	
	public int WeekCalculator(String CurrentDate, String InputDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		try {
			date1 = sdf.parse(CurrentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			date2 = sdf.parse(InputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTime dateTime1 = new DateTime(date1);
		DateTime dateTime2 = new DateTime(date2);

		int weeks = Weeks.weeksBetween(dateTime1, dateTime2).getWeeks();
		
		// To remove the negative sign
		if(weeks<0)
		{
			weeks=weeks*-1;
		}

		return weeks;

	}

}
