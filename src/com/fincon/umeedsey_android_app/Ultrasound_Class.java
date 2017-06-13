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
import android.widget.Spinner;
import android.widget.Toast;

public class Ultrasound_Class extends Activity {

	public static String rslt = "";

	Spinner SP_Babies, SP_Fetal, SP_Presentation, SP_Placement, SP_Maturity,
			SP_Liquor;
	EditText ET_DisplayDate, ET_biparital, ET_femur, ET_gestAge, ET_USSGestAge,
			ET_Anomly;
	Button BTN_ChangeDate, BTN_Save, BTN_Back;

	String Current_Date;
	int year;
	int month;
	int day;
	int Validator = 22;
	static final int DATE_DIALOG_ID = 999;
	
	WeekClass objWeek= new   WeekClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ultrasound);

		setCurrentDateOnView();
		addListenerOnButton();

		SP_Babies = (Spinner) findViewById(R.id.spinner_no_babies_ultrasound);
		SP_Fetal = (Spinner) findViewById(R.id.spinner_fetal_heartrate_ultrasound);
		SP_Presentation = (Spinner) findViewById(R.id.spinner_presentation_ultrasound);
		SP_Placement = (Spinner) findViewById(R.id.spinner_placement_location_ultrasound);
		SP_Maturity = (Spinner) findViewById(R.id.spinner_maturity_ultrasound);
		SP_Liquor = (Spinner) findViewById(R.id.spinner_liquor_ultrasound);

		ET_biparital = (EditText) findViewById(R.id.editText_biparital_ultrasound);
		ET_femur = (EditText) findViewById(R.id.editText_femur_length_ultrasound);
		ET_gestAge = (EditText) findViewById(R.id.editText_gest_age_ultrasound);
		ET_USSGestAge = (EditText) findViewById(R.id.editText_uss_gest_age_ultrasound);
		ET_Anomly = (EditText) findViewById(R.id.editText_anomly_ultrasound);

		BTN_Save = (Button) findViewById(R.id.button_save_ultrasound);
		BTN_Back = (Button) findViewById(R.id.button_back_ultrasound);

		AgeCalculation obj_Age = new AgeCalculation();

		ET_gestAge.setKeyListener(null);
		ET_gestAge.setText(String.valueOf(objWeek.WeekCalculator(Current_Date, IDs_Class.getLMP())));
		// =========================================================================================================
		ET_biparital.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_biparital);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_femur.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_femur);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_USSGestAge.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(ET_USSGestAge);
			}
		});
		// =========================================================================================================

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(Ultrasound_Class.this, "Skipped !... ",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Ultrasound_Class.this, DashBoard.class);
				startActivity(i);

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Validator = 22;

				if (SP_Babies.getSelectedItem().toString()
						.equals("Select No.of Babies")
						|| SP_Fetal.toString()
								.equals("Select Fetal Heart Rate")
						|| SP_Presentation.toString().equals(
								"Select Presentation")
						|| SP_Placement.toString().equals(
								"Select Placental Location")
						|| SP_Maturity.toString().equals("Select Maturity")
						|| SP_Liquor.toString().equals("Select Liquor")) {

					Validator = 11;

					Toast.makeText(Ultrasound_Class.this,
							"Select all the Drop Down Values !... ",
							Toast.LENGTH_SHORT).show();

				}

				if (ET_DisplayDate.getText().toString().length() <= 0
						|| ET_biparital.toString().length() <= 0
						|| ET_femur.toString().length() <= 0
						|| ET_gestAge.toString().length() <= 0
						|| ET_USSGestAge.toString().length() <= 0) {

					Validator = 11;

					Toast.makeText(Ultrasound_Class.this,
							"Fill all the Mendatory Text Boxes !... ",
							Toast.LENGTH_SHORT).show();
				}

				if (Validator == 22) {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertUltrasoundResults";
						c.arg1a = "UltrasoundResults";

						c.arg1_value = Current_Date + "@" + "2" + "@"
								+ ET_gestAge.getText().toString() + "@"
								+ SP_Babies.getSelectedItem().toString() + "@"
								+ SP_Fetal.getSelectedItem().toString() + "@"
								+ SP_Presentation.getSelectedItem().toString()
								+ "@" + ET_biparital.getText().toString() + "@"
								+ ET_femur.getText().toString() + "@"
								+ ET_USSGestAge.getText().toString() + "@"
								+ SP_Placement.getSelectedItem().toString()
								+ "@"
								+ SP_Maturity.getSelectedItem().toString()
								+ "@" + SP_Liquor.getSelectedItem().toString()
								+ "@" + ET_Anomly.getText().toString() + "@"
								+ "00000000-0000-0000-0000-000000000000" + "@"
								+ "E85279FF-014B-49D8-AFF7-72844EA23AAE" + "@"
								+ "2" + "@" + Current_Date;

						c.selection = 115;
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

					// Toast.makeText(Ultrasound_Class.this,
					// "Server Response " + rslt, Toast.LENGTH_SHORT).show();

					Toast.makeText(Ultrasound_Class.this,
							"Saved Successfully!... ", Toast.LENGTH_SHORT)
							.show();

					DashBoardSession.setUltrasoundScan(11);

					Intent i = new Intent(Ultrasound_Class.this,
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
			edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	public void setCurrentDateOnView() {

		ET_DisplayDate = (EditText) findViewById(R.id.editText_last_ultrasound);
		ET_DisplayDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		ET_DisplayDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));

		Current_Date = (new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" ")).toString();

	}

	public void addListenerOnButton() {

		BTN_ChangeDate = (Button) findViewById(R.id.button_add_date_ultrasound);

		BTN_ChangeDate.setOnClickListener(new OnClickListener() {

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
			ET_DisplayDate.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
