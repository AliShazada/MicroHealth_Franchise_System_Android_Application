package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import javax.xml.datatype.Duration;

import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Delivery_Basic_info_Class extends Activity {

	public static String rslt = "";

	Button add_Delvery_date, BTN_Save, BTN_Discard;
	EditText outcome, duration;
	EditText delivery_date;

	private int year;
	private int month;
	private int day;
	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.delivery_basic_information);

		setCurrentDateOnView();
		addListenerOnButton();

		duration = (EditText) findViewById(R.id.auto_duration_dbi);
		outcome = (EditText) findViewById(R.id.autofill_outcome_dbi);

		BTN_Save = (Button) findViewById(R.id.button_save_dbi);
		BTN_Discard = (Button) findViewById(R.id.button_discard_dbi);
		duration.setKeyListener(null);
		outcome.setKeyListener(null);

		// //Code to get the Value of LMP////////////--------------------------

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "getLMP";

			c.arg1a = "PregnancyID";
			c.arg2a = "personID";

			c.arg1_value = IDs_Class.getPostnatal_list_PregID();
			c.arg2_value = IDs_Class.getPostnatal_list_PersonID();

			c.selection = 227;

			// c.ad = ad;
			c.join();
			c.start();
			while (rslt == "START") {
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}

		} catch (Exception ex) {

		}

		Toast.makeText(Delivery_Basic_info_Class.this, "Result " + rslt,
				Toast.LENGTH_SHORT).show();

		String Delivery_Date_Day = null;
		String Delivery_Date_Month = null;
		String Delivery_Date_Year = null;

		String LMP_Day = null;
		String LMP_Month = null;
		String LMP_Year = null;

		String Month = null;

		String Delivery_Date = delivery_date.getText().toString();

		String[] Delivery_Date_Token = Delivery_Date.split("-");

		for (int i = 0; i < Delivery_Date_Token.length; i++) {

			if (i == 0) {
				Delivery_Date_Day = Delivery_Date_Token[i];
			} else if (i == 1) {
				Delivery_Date_Month = Delivery_Date_Token[i];
			} else if (i == 2) {
				Delivery_Date_Year = Delivery_Date_Token[i];

				break;
			}
		}

		String LMP = rslt;
		String[] LMP_Token = null;

		if (LMP.contains("-")) {
			LMP_Token = LMP.split("-");
		} else if (LMP.contains("/")) {
			LMP_Token = LMP.split("/");
		}

		for (int i1 = 0; i1 < LMP_Token.length; i1++) {

			if (i1 == 0) {
				LMP_Day = LMP_Token[i1];
			} else if (i1 == 1) {
				LMP_Month = LMP_Token[i1];
			} else if (i1 == 2) {
				LMP_Year = LMP_Token[i1];
				break;
			}
		}

		Toast.makeText(Delivery_Basic_info_Class.this,
				LMP_Year + "-" + Delivery_Date_Year, Toast.LENGTH_SHORT).show();

		// Delivery_Date_Year.trim();
		// LMP_Year.trim();
		//
		// int Temp_Delivery_Date_Year=Integer.parseInt("2014");
		//
		// int Temp_LMP_Year=Integer.parseInt("2014");
		//
		// int diffYear = Integer.parseInt(Delivery_Date_Year)
		// - Integer.parseInt(LMP_Year);
		//
		// int diffMonth = diffYear * 12 + Integer.parseInt(Delivery_Date_Month)
		// - Integer.parseInt(LMP_Month);
		//
		// Month = String.valueOf(diffMonth);

		// Toast.makeText(Delivery_Basic_info_Class.this,
		// "No. of Months = " + Calculate_Month(), Toast.LENGTH_SHORT)
		// .show();

		// //Code to get the Value of LMP////////////
		// Closed--------------------------

int duration_value= Math.round((Integer.parseInt(IDs_Class.getGestationWeek())*7)/30);  //(weeksx7)30
				
		
		
		duration.setText(String.valueOf(duration_value));

		//duration.setText(String.valueOf(duration_value));

		if (duration_value >= 0 && duration_value <= 6) {
			outcome.setText("Miscarriage");
		} else if (duration_value == 7 || duration_value == 8) {
			outcome.setText("Preterm");
		} else if (duration_value == 9) {
			outcome.setText("Fullterm");
		} else if (duration_value == 10) {
			outcome.setText("Postterm");
		}

		BTN_Discard.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Delivery_Basic_info_Class.this,
						PostNatal_ListViewClass.class);

				startActivity(i);

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				try {
					rslt = "START";
					Caller3 c = new Caller3();

					c.Method_Name = "InsertObstetricHistory";
					c.arg1a = "ObstetricHistory";

					// PersonID,Date,OutCome,Complication,Detail,Duration
					// ,PregnancyCaseID

					c.arg1_value = IDs_Class.getPostnatal_list_PersonID() + "@"
							+ delivery_date.getText().toString() + "@"
							+ outcome.getText().toString() + "@" + "" + "@"
							+ "" + "@" + "" + duration.getText().toString()
							+ "@" + IDs_Class.getPostnatal_list_PregID();

					c.selection = 119;
					c.join();
					c.start();
					while (rslt == "START") {
						try {
							Thread.sleep(10);
						} catch (Exception ex) {
						}
					}

				} catch (Exception ex) {

				}

				Toast.makeText(Delivery_Basic_info_Class.this,
						"Server Response" + rslt, Toast.LENGTH_SHORT).show();

				IDs_Class.setPast_Obstetic_History_ID(rslt);
				IDs_Class.setDeliveryDate(delivery_date.getText().toString());
				IDs_Class.setPregnencyDuration(duration.getText().toString());

				Toast.makeText(
						Delivery_Basic_info_Class.this,
						"Delivery Date : " + delivery_date.getText().toString(),
						Toast.LENGTH_SHORT).show();

				Toast.makeText(Delivery_Basic_info_Class.this,
						"Saved Successfully", Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Delivery_Basic_info_Class.this,
						DeliveryDetail_informationClass.class);
				startActivity(i);

			}
		});

	}

	public void setCurrentDateOnView() {

		delivery_date = (EditText) findViewById(R.id.editText_delDate_dbi);
		delivery_date.setKeyListener(null);

		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		delivery_date.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year));

	}

	public void addListenerOnButton() {

		add_Delvery_date = (Button) findViewById(R.id.button_add_deldate_dbi);

		add_Delvery_date.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showDialog(DATE_DIALOG_ID);

			}

		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			delivery_date.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year));

		}
	};

	private String Calculate_Month() {

		String Delivery_Date_Day = null;
		String Delivery_Date_Month = null;
		String Delivery_Date_Year = null;

		String LMP_Day = null;
		String LMP_Month = null;
		String LMP_Year = null;

		String Month = null;

		String Delivery_Date = delivery_date.getText().toString();

		String[] Delivery_Date_Token = Delivery_Date.split("-");

		for (int i = 0; i < Delivery_Date_Token.length; i++) {

			if (i == 0) {
				Delivery_Date_Day = Delivery_Date_Token[i];
			} else if (i == 1) {
				Delivery_Date_Month = Delivery_Date_Token[i];
			} else if (i == 2) {
				Delivery_Date_Year = Delivery_Date_Token[i];
			}
		}

		String LMP = rslt;
		String[] LMP_Token = null;

		if (LMP.contains("-")) {
			LMP_Token = LMP.split("-");
		} else if (LMP.contains("/")) {
			LMP_Token = LMP.split("/");
		}

		for (int i1 = 0; i1 < LMP_Token.length; i1++) {

			if (i1 == 0) {
				LMP_Day = LMP_Token[i1];
			} else if (i1 == 1) {
				LMP_Month = LMP_Token[i1];
			} else if (i1 == 2) {
				LMP_Year = LMP_Token[i1];
			}
		}

		int diffYear = Integer.parseInt(Delivery_Date_Year)
				- Integer.parseInt(LMP_Year);
		int diffMonth = diffYear * 12 + Integer.parseInt(Delivery_Date_Month)
				- Integer.parseInt(LMP_Month);

		Month = String.valueOf(diffMonth);

		return Month;

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
