package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class BloodType_Class extends Activity {

	public static String rslt = "";

	EditText Remarks, tvDisplayDate;
	Button BTN_Save, BTN_Skip, btnChangeDate;
	Spinner SP_BloodType;

	int Validator = 0;
	DateCheckClass objDate = new DateCheckClass();
	int year;
	int month;
	int day;
	static final int DATE_DIALOG_ID = 999;

	String Current_Date, No_of_Visits, Gestation_Week;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bloodtype);

		setCurrentDateOnView();
		addListenerOnButton();

		Remarks = (EditText) findViewById(R.id.details_bloodType);
		BTN_Save = (Button) findViewById(R.id.save_bloodType);
		BTN_Skip = (Button) findViewById(R.id.Skip_bloodtype);

		SP_BloodType = (Spinner) findViewById(R.id.spinner1_blood_type);

		// // Get the No. of visits from the Service
		// //////////////////////................................

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "SelectVisitCountForPatient";
			c.arg1a = "patientID";
			c.arg2a = "pregnancyCaseID";

			c.arg1_value = IDs_Class.getAM_Patient_ID();
			c.arg2_value = IDs_Class.getCurrentPregnancyCase_ID();

			c.selection = 2211;
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

		// Toast.makeText(HepatitisB_Service_Class.this, "No of Visits" + rslt,
		// Toast.LENGTH_SHORT).show();

		No_of_Visits = rslt;

		// // Get the No. of visits from the Service Closed
		// //////////////////////................................

		// // Getting the value of gastation week from the DataBase //////
		// .........................................

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "SelectLatestGestationWeek";
			c.arg1a = "patientID";
			c.arg2a = "pregnancyCaseID";
			c.arg3a = "LMP";

			c.arg1_value = IDs_Class.getAM_Patient_ID();

			c.arg2_value = IDs_Class.getCurrentPregnancyCase_ID();

			c.arg3_value = IDs_Class.getLMP();

			c.selection = 3312;
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
		// Toast.makeText(HepatitisB_Service_Class.this, "Gestation Weeks" +
		// rslt,
		// Toast.LENGTH_SHORT).show();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Validator = 22;

				if (SP_BloodType.getSelectedItem().toString()
						.equals("Select Blood Group")) {
					Toast.makeText(BloodType_Class.this,
							"Select the Blood Group !..", Toast.LENGTH_SHORT)
							.show();

					Validator = 11;
				}
				int result = objDate.DateChecker(Current_Date, tvDisplayDate
						.getText().toString());

				if (result == 2) {
					Toast.makeText(BloodType_Class.this, "Invalid Date ! ..",
							Toast.LENGTH_SHORT).show();
					Validator = 11;
				}

				if (Validator != 11) {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertPatientLabTest";
						c.arg1a = "PatientLabTests";

						c.arg1_value = SessionClass.getUser_id() + "@"
								+ Current_Date + "@"
								+ "00000000-0000-0000-0000-000000000000" + "@"
								+ IDs_Class.getAM_Patient_ID() + "@"
								+ IDs_Class.getCurrentPregnancyCase_ID() + "@"
								+ Remarks.getText().toString() + "@" + "1"
								+ "@" + Gestation_Week + "@" + No_of_Visits
								+ "@" + Current_Date;

						c.selection = 1119;
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

					// Toast.makeText(HepatitisB_Service_Class.this,
					// "Server Response" + rslt, Toast.LENGTH_SHORT)
					// .show();

					Toast.makeText(BloodType_Class.this,
							"Saved Successfully !...", Toast.LENGTH_SHORT)
							.show();

					DashBoardSession.setBloodTyping(11);

					Intent i = new Intent(BloodType_Class.this, DashBoard.class);
					startActivity(i);
				}

			}
		});

		BTN_Skip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(BloodType_Class.this, "Skipped !...",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(BloodType_Class.this, DashBoard.class);
				startActivity(i);

			}
		});
	}

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.editText_TestDate_bloodType);
		tvDisplayDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		tvDisplayDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year));

		Current_Date = (new StringBuilder()
		// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year)).toString();

	}

	public void addListenerOnButton() {

		btnChangeDate = (Button) findViewById(R.id.button_add_TestDate_bloodType);

		btnChangeDate.setOnClickListener(new OnClickListener() {

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
			tvDisplayDate.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year));

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
