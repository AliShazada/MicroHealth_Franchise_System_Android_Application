package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Blood_Sugar_Test_Class extends Activity {

	EditText tvDisplayDate, ET_RBS, ET_FBS, ET_PostPrandial, ET_Remarks;
	Button btnChangeDate, BTN_Save, BTN_Discard;

	String Current_Date, No_of_Visits, Gestation_Week;
	public static String rslt = "";

	int year;
	int month;
	int day;
	int Validator = 0;

	DateCheckClass objDate = new DateCheckClass();

	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blood_sugar_test);

		setCurrentDateOnView();
		addListenerOnButton();

		ET_RBS = (EditText) findViewById(R.id.editText_rbs_blood_sugar);
		ET_FBS = (EditText) findViewById(R.id.editText_fbs_blood_sugar);
		ET_PostPrandial = (EditText) findViewById(R.id.editText_postprandial_blood_sugar);
		ET_Remarks = (EditText) findViewById(R.id.editText_remarks_blood_sugar);

		BTN_Save = (Button) findViewById(R.id.button_save_cbc);
		BTN_Discard = (Button) findViewById(R.id.button_discard_cbc);

		// =========================================================================================================
		ET_RBS.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_RBS);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_PostPrandial.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_PostPrandial);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_FBS.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_FBS);
			}
		});
		// =========================================================================================================

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

			c.selection = 224;
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

		// Toast.makeText(Blood_Sugar_Test_Class.this, "No of Visits" + rslt,
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

			c.selection = 334;
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
		// Toast.makeText(Blood_Sugar_Test_Class.this, "Gestation Weeks" + rslt,
		// Toast.LENGTH_SHORT).show();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		BTN_Discard.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(Blood_Sugar_Test_Class.this, "Skipped !...",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Blood_Sugar_Test_Class.this,
						DashBoard.class);
				startActivity(i);

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {

					Validator = 22;

					if (ET_RBS.getText().toString().length() <= 0) {

						Toast.makeText(Blood_Sugar_Test_Class.this,
								"Enter Value of RBS (mg/dl) ",
								Toast.LENGTH_SHORT).show();

						Validator = 11;

					}
					int result = objDate.DateChecker(Current_Date,
							tvDisplayDate.getText().toString());

					if (result == 2) {
						Toast.makeText(Blood_Sugar_Test_Class.this,
								"Invalid Date ! ..", Toast.LENGTH_SHORT).show();
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
									+ "00000000-0000-0000-0000-000000000000"
									+ "@" + IDs_Class.getAM_Patient_ID() + "@"
									+ IDs_Class.getCurrentPregnancyCase_ID()
									+ "@" + ET_Remarks.getText().toString()
									+ "@" + "1" + "@" + Gestation_Week + "@"
									+ No_of_Visits + "@" + Current_Date;

							c.selection = 114;
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

						// Toast.makeText(Blood_Sugar_Test_Class.this,
						// "Server Response" + rslt, Toast.LENGTH_SHORT)
						// .show();

						Toast.makeText(Blood_Sugar_Test_Class.this,
								"Saved Successfully !...", Toast.LENGTH_SHORT)
								.show();

						DashBoardSession.setBloodSugarTest(11);

						Intent i = new Intent(Blood_Sugar_Test_Class.this,
								DashBoard.class);
						startActivity(i);
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"Internet is not available", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

	}

	// =========================================================================================================
	public void Is_Valid_Number(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[0-9 ]+")) {
			edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.editText_TestDate_blood_sugar_test);
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
				.append(year).append(" "));

		Current_Date = (new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" ")).toString();

	}

	public void addListenerOnButton() {

		btnChangeDate = (Button) findViewById(R.id.button_add_TestDate_blood_sugar);

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
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
