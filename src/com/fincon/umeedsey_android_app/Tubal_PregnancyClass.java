package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import android.widget.Toast;

public class Tubal_PregnancyClass extends Activity {

	public static String rslt = "";

	EditText ET_Duration, ET_Outcome, ET_Complications, ET_Details,
			tvDisplayDate;

	Button BTN_back, BTN_Save, btnChangeDate;

	DateCheckClass objDate = new DateCheckClass();

	AgeCalculation obj = new AgeCalculation();

	WeekClass objWeek = new WeekClass();

	int year;
	int month;
	int day;
	String Current_Date;
	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tubal_pregnency);

		setCurrentDateOnView();
		addListenerOnButton();

		ET_Duration = (EditText) findViewById(R.id.editText_duration_tubal);
		ET_Outcome = (EditText) findViewById(R.id.editText_outcome_tubal);
		ET_Complications = (EditText) findViewById(R.id.editText_complications_tubal);
		ET_Details = (EditText) findViewById(R.id.editText_details_tubal);

		BTN_Save = (Button) findViewById(R.id.button_save_tubal);

		BTN_back = (Button) findViewById(R.id.button_back_tubal);

		ET_Duration.setKeyListener(null);
		ET_Outcome.setKeyListener(null);

		ET_Duration.setText(IDs_Class.getDuration());

		int duration_value = Math.round((objWeek.WeekCalculator(Current_Date,
				IDs_Class.getLMP()) * 7) / 30);
		// (weeksx7)/30

		ET_Duration.setText(String.valueOf(duration_value));

		if (ET_Duration.getText().toString().equals("1")
				|| ET_Duration.getText().toString().equals("2")
				|| ET_Duration.getText().toString().equals("3")
				|| ET_Duration.getText().toString().equals("4")
				|| ET_Duration.getText().toString().equals("5")
				|| ET_Duration.getText().toString().equals("6")) {

			ET_Outcome.setText("Miscarriage");

		} else if (ET_Duration.getText().toString().equals("7")
				|| ET_Duration.getText().toString().equals("8")) {

			ET_Outcome.setText("Pre Term");

		} else if (ET_Duration.getText().toString().equals("9")) {

			ET_Outcome.setText("Full Term");

		} else if (ET_Duration.getText().toString().equals("10")) {

			ET_Outcome.setText("Post Term");

		}

		BTN_back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Tubal_PregnancyClass.this,
						DashBoard.class);
				startActivity(i);

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				int result = objDate.DateChecker(Current_Date, tvDisplayDate
						.getText().toString());

				if (result == 2) {
					Toast.makeText(Tubal_PregnancyClass.this,
							"Invalid Date ! ..", Toast.LENGTH_SHORT).show();

				} else {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "TubalPregnancyAbortion";
						c.arg1a = "TubalAbortion";

						c.arg1_value = IDs_Class.getPatient_ID() + "@"
								+ tvDisplayDate.getText().toString() + "@"
								+ ET_Outcome.getText().toString() + "@" + ""
								+ "@" + "" + "@"
								+ ET_Duration.getText().toString() + "@"
								+ IDs_Class.getCurrentPregnancyCase_ID() + "@"
								+ "" + "@" + Current_Date + "@" + "" + "@" + ""
								+ "@" + "" + "@"
								+ ET_Details.getText().toString() + "@"
								+ ET_Complications.getText().toString() + "@"
								+ "0" + "@" + "" + "@"
								+ SessionClass.getUser_id() + "@"
								+ IDs_Class.getAM_Patient_ID() + "@"
								+ Current_Date;

						c.selection = 118;
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

					Toast.makeText(Tubal_PregnancyClass.this,
							"Saved Succesfuetlly !", Toast.LENGTH_SHORT).show();

					// DashBoardSession.setMisscarriage(11);

					Intent i = new Intent(Tubal_PregnancyClass.this,
							DashBoard.class);
					startActivity(i);

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

		tvDisplayDate = (EditText) findViewById(R.id.editText_Date_tubal);
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

		btnChangeDate = (Button) findViewById(R.id.button_add_Date_tubal);

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
			int CalculatedMonths = obj.AgeCal(year, month, day);

			ET_Duration.setText(String.valueOf(CalculatedMonths));
			if (obj.AgeCal(year, month, day) == 1
					|| obj.AgeCal(year, month, day) == 2
					|| obj.AgeCal(year, month, day) == 3
					|| obj.AgeCal(year, month, day) == 4
					|| obj.AgeCal(year, month, day) == 5
					|| obj.AgeCal(year, month, day) == 6) {

				ET_Outcome.setText("Miscarriage");

			} else if (obj.AgeCal(year, month, day) == 7
					|| obj.AgeCal(year, month, day) == 8) {

				ET_Outcome.setText("Pre Term");

			}

			else if (obj.AgeCal(year, month, day) == 9

			) {

				ET_Outcome.setText("Full Term");

			} else if (obj.AgeCal(year, month, day) == 10

			) {

				ET_Outcome.setText("Post Term");

			}

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
