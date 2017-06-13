package com.fincon.umeedsey_android_app;

public class DateFormatingClass {
	
	public static String DateFormator(String InputDate) {
		String Garbage_Date = InputDate;// "LMP: Apr 30, 2014";
		String Temp_MonthName = null;
		String TempDay = null;
		String TempYear = null;
		String TempIntMonth = null;

		String[] ServerResponse = Garbage_Date.split(" ");

		Temp_MonthName = ServerResponse[1];
		TempYear = ServerResponse[3];

		String[] TokenDay = ServerResponse[2].split(",");
		TempDay = TokenDay[0];

		// System.out.println("Month:" + Temp_MonthName);
		// System.out.println("Day:" + TempDay);
		// System.out.println("Year:" + TempYear);

		if (Temp_MonthName.equalsIgnoreCase("Jan")) {
			TempIntMonth = "1";
		} else if (Temp_MonthName.equalsIgnoreCase("Feb")) {
			TempIntMonth = "2";
		} else if (Temp_MonthName.equalsIgnoreCase("Mar")) {
			TempIntMonth = "3";
		} else if (Temp_MonthName.equalsIgnoreCase("Apr")) {
			TempIntMonth = "4";
		} else if (Temp_MonthName.equalsIgnoreCase("May")) {
			TempIntMonth = "5";
		} else if (Temp_MonthName.equalsIgnoreCase("Jun")) {
			TempIntMonth = "6";
		} else if (Temp_MonthName.equalsIgnoreCase("Jul")) {
			TempIntMonth = "7";
		} else if (Temp_MonthName.equalsIgnoreCase("Aug")) {
			TempIntMonth = "8";
		} else if (Temp_MonthName.equalsIgnoreCase("Sep")) {
			TempIntMonth = "9";
		} else if (Temp_MonthName.equalsIgnoreCase("Oct")) {
			TempIntMonth = "10";
		} else if (Temp_MonthName.equalsIgnoreCase("Nov")) {
			TempIntMonth = "11";
		} else if (Temp_MonthName.equalsIgnoreCase("Dec")) {
			TempIntMonth = "12";
		}

		String FormatedDate = TempIntMonth + "-" + TempDay + "-" + TempYear;

		return FormatedDate;

	}

}
