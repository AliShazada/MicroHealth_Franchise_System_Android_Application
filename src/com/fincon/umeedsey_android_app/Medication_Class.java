package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Medication_Class extends Activity {

	public static String rslt = "";

	EditText ET_No_of_Tablets, ET_Strength, ET_Unit, ET_Dose, ET_Comments,
			ET_StartDate, ET_EndDate, tvDisplayDate;
	Spinner SP_Drugs;
	Button BTN_Save, BTN_Back, btnChangeDate, BTN_StartDate, BTN_EndDate;

	int year;
	int month;
	int day;

	int Startyear;
	int Startmonth;
	int Startday;

	int Endyear;
	int Endmonth;
	int Endday;

	int Date_Checker = 0;

	DateCheckClass objDate = new DateCheckClass();

	int Drug_counter;
	String Current_Date;
	String Drug_Service_ID, Gestation_Week;
	int Validator = 22;

	List<String> List_Drugs = new ArrayList<String>();

	static final int DATE_DIALOG_ID = 999;

	public String[][] Drugs_Array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medication);

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		ET_No_of_Tablets = (EditText) findViewById(R.id.editText_noOfTablets_medication);
		ET_Unit = (EditText) findViewById(R.id.editText_strength_medication);
		ET_Dose = (EditText) findViewById(R.id.editText_dose_medication);
		ET_Comments = (EditText) findViewById(R.id.editText_comments_medication);
		// ET_StartDate=(EditText)findViewById(R.id.editText_startdate_medication);
		// ET_EndDate=(EditText)findViewById(R.id.editText_enddate_medication);

		SP_Drugs = (Spinner) findViewById(R.id.spinner_drugs_medication);

		BTN_Save = (Button) findViewById(R.id.button_save_medication);
		BTN_Back = (Button) findViewById(R.id.button_back_medication);

		setCurrentDateOnView();
		setCurrentDateOnView_Start();
		setCurrentDateOnView_End();

		addListenerOnButton();
		addListenerOnButton_Start();
		addListenerOnButton_End();

		// =========================================================================================================
		ET_No_of_Tablets.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_No_of_Tablets);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_Unit.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_Unit);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_Dose.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_Dose);
			}
		});
		// =========================================================================================================

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

			c.selection = 336;
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

		// Toast.makeText(Medication_Class.this, "Gestation Weeks" + rslt,
		// Toast.LENGTH_SHORT).show();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		// // Code to Populate The Drop Down List of Drug Name.............
		try {

			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "SelectAllDrugs";
			c.selection = 116;
			c.ad = ad;

			c.join();
			c.start();
			while (rslt == "START") {
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}

		} catch (Exception ex) {
			ad.setTitle("Error!");
			ad.setMessage(ex.toString());
		}

		// Toast.makeText(getApplicationContext(), "Result : " + rslt,
		// Toast.LENGTH_SHORT).show();

		String[] Drug_Token = rslt.split("/");
		int ic = 0;
		for (ic = 0; ic < Drug_Token.length; ic++) {

		}
		Drug_counter = ic;

		Drugs_Array = new String[Drug_counter][2];

		String[] Drug_Token2 = rslt.split("/");

		String Drug_id = null;
		String Drug_name = null;

		List_Drugs.add("Select the Drug");

		for (int ic2 = 0; ic2 < Drug_Token2.length; ic2++) {

			String[] SubDrug_Token = Drug_Token2[ic2].split("@");
			//
			for (int jc2 = 0; jc2 < SubDrug_Token.length; jc2++) {
				if (jc2 == 0) {
					Drug_name = SubDrug_Token[jc2];
				} else if (jc2 == 1) {
					Drug_id = SubDrug_Token[jc2];
				}

			}

			//
			Drugs_Array[ic2][0] = Drug_name;
			Drugs_Array[ic2][1] = Drug_id;
			//
			List_Drugs.add(Drug_name);
			//
			// Drug_id = null;
			// Drug_name = null;

		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, List_Drugs);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SP_Drugs.setAdapter(dataAdapter);

		// // (Closed)Code to Populate The Drop Down List of
		// Drug Name.............

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(Medication_Class.this, "Skipped !",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Medication_Class.this, DashBoard.class);
				startActivity(i);

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Validator = 22;

				if (SP_Drugs.getSelectedItem().toString()
						.equals("Select the Drug")) {
					Toast.makeText(Medication_Class.this, "Select the Drug",
							Toast.LENGTH_SHORT).show();

					Validator = 11;
				}

				// if (ET_No_of_Tablets.getText().toString().length() <= 0
				// || ET_Strength.getText().toString().length() <= 0
				// || ET_Unit.getText().toString().length() <= 0
				// || ET_Dose.getText().toString().length() <= 0) {
				// Validator = 11;
				//
				// Toast.makeText(Medication_Class.this,
				// "Fill all the Mendatory Text Fields ! ..",
				// Toast.LENGTH_SHORT).show();
				// }

				int result = objDate.DateChecker(ET_StartDate.getText()
						.toString(), ET_EndDate.getText().toString());

				if (result != 2) {
					Toast.makeText(Medication_Class.this,
							"End Date should be greater ! ..",
							Toast.LENGTH_SHORT).show();
					Validator = 11;
				}

				if (Validator == 22) {

					Toast.makeText(Medication_Class.this, "clear",
							Toast.LENGTH_SHORT).show();

					DashBoardSession.setMedication(11);

					Intent i = new Intent(Medication_Class.this,
							DashBoard.class);
					startActivity(i);

				}

			}
		});

	}

	// =========================================================================================================
	public void Is_Valid_Number(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			// edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[0-9 ]+")) {
			// edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.editText_date_medication);
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

	public void setCurrentDateOnView_Start() {

		ET_StartDate = (EditText) findViewById(R.id.editText_startdate_medication);
		ET_StartDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		ET_StartDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));

	}

	public void setCurrentDateOnView_End() {

		ET_EndDate = (EditText) findViewById(R.id.editText_enddate_medication);
		ET_EndDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		ET_EndDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));

	}

	public void addListenerOnButton() {

		btnChangeDate = (Button) findViewById(R.id.button_date_medication);

		btnChangeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Date_Checker = 11;

				showDialog(DATE_DIALOG_ID);

			}

		});

	}

	public void addListenerOnButton_Start() {

		BTN_StartDate = (Button) findViewById(R.id.button_add_start_date_medication);

		BTN_StartDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Date_Checker = 22;

				showDialog(DATE_DIALOG_ID);

			}

		});

	}

	public void addListenerOnButton_End() {

		BTN_EndDate = (Button) findViewById(R.id.button_end_date_medication);

		BTN_EndDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Date_Checker = 33;

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

			if (Date_Checker == 11) {

				// set selected date into textview
				tvDisplayDate.setText(new StringBuilder().append(month + 1)
						.append("-").append(day).append("-").append(year)
						.append(" "));
			} else if (Date_Checker == 22) {

				// set selected date into textview
				ET_StartDate.setText(new StringBuilder().append(month + 1)
						.append("-").append(day).append("-").append(year)
						.append(" "));
			} else if (Date_Checker == 33) {

				// set selected date into textview
				ET_EndDate.setText(new StringBuilder().append(month + 1)
						.append("-").append(day).append("-").append(year)
						.append(" "));
			}

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
