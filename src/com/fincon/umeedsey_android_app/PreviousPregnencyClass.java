package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PreviousPregnencyClass extends Activity {

	public static String rslt = "";

	Button Save, btnChangeDate;
	EditText tvDisplayDate, complications, detail, outcome;
	Spinner Duration;

	String Current_Date;

	DateCheckClass objDate = new DateCheckClass();
	int validator = 0;
	int year;
	int month;
	int day;
	int Check = 0;
	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.previous_pragnancy_var1);
		setCurrentDateOnView();
		addListenerOnButton();

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		Duration = (Spinner) findViewById(R.id.spinner_previPreg_duration);
		Save = (Button) findViewById(R.id.save_prev_pregnancy);

		complications = (EditText) findViewById(R.id.editText_prevpreg_complications);
		detail = (EditText) findViewById(R.id.editText_prevpreg_details);
		outcome = (EditText) findViewById(R.id.editText_prevpreg_outcome);

		outcome.setKeyListener(null);

		Duration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> adapterView, View view,
					int i, long l) {
				// TODO Auto-generated method stub

				if (Check == 1) {

					if (Duration.getSelectedItem().toString().equals("1")
							|| Duration.getSelectedItem().toString()
									.equals("2")
							|| Duration.getSelectedItem().toString()
									.equals("3")
							|| Duration.getSelectedItem().toString()
									.equals("4")
							|| Duration.getSelectedItem().toString()
									.equals("5")
							|| Duration.getSelectedItem().toString()
									.equals("6")) {

						complications.setVisibility(View.VISIBLE);
						detail.setVisibility(View.VISIBLE);
						outcome.setText("Miscarriage");

					} else if (Duration.getSelectedItem().toString()
							.equals("7")
							|| Duration.getSelectedItem().toString()
									.equals("8")) {

						complications.setVisibility(View.GONE);
						detail.setVisibility(View.GONE);
						outcome.setText("Pre Term");

					} else if (Duration.getSelectedItem().toString()
							.equals("9")) {

						complications.setVisibility(View.GONE);
						detail.setVisibility(View.GONE);
						outcome.setText("Full Term");

					} else if (Duration.getSelectedItem().toString()
							.equals("10")) {

						complications.setVisibility(View.GONE);
						detail.setVisibility(View.GONE);
						outcome.setText("Post Term");

					}

				}
				Check = 1;

			}

			// If no option selected
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		Save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				validator = 22;

				if (Duration.getSelectedItem().toString()
						.equals("Pregnancy Duration")) {
					Toast.makeText(PreviousPregnencyClass.this,
							"Select the Pregnancy Duration", Toast.LENGTH_SHORT)
							.show();
					validator = 11;
				}

				int result = objDate.DateChecker(Current_Date, tvDisplayDate
						.getText().toString());

				if (result != 1) {
					Toast.makeText(PreviousPregnencyClass.this,
							"Invalid Previous Pregnency Date ! ..",
							Toast.LENGTH_SHORT).show();
					validator = 11;
				}

				if (validator != 11) {

					IDs_Class.setPreviousPregnencyDate(tvDisplayDate.getText()
							.toString());

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertPastObestraticHistory";
						c.arg1a = "PastObestaticHistory";
						// c.arg1_value="2,8-26-2014,Postterm,abc,aa,10,5";

						c.arg1_value = IDs_Class.getPatient_ID() + ","
								+ Current_Date + ","
								+ outcome.getText().toString() + ","
								+ complications.getText().toString() + ","
								+ detail.getText().toString() + ","
								+ Duration.getSelectedItem().toString() + ","
								+ IDs_Class.getCurrentPregnancyCase_ID();

						c.selection = 15;

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

					Toast.makeText(PreviousPregnencyClass.this,
							"Result " + rslt, Toast.LENGTH_SHORT).show();

					Toast.makeText(PreviousPregnencyClass.this,
							"Saved Successfully !", Toast.LENGTH_SHORT).show();

					IDs_Class.setLnPOH(rslt);
					IDs_Class.setDuration(outcome.getText().toString());

					if (outcome.getText().toString().equals("Miscarriage")) {
						Intent i = new Intent(PreviousPregnencyClass.this,
								Allergies_Class.class);
						startActivity(i);
					} else {
						Intent i = new Intent(PreviousPregnencyClass.this,
								Previous_Delivery_Class.class);
						startActivity(i);
					}

				}

			}
		});

	}

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.editText_prevpreg_year);
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

		btnChangeDate = (Button) findViewById(R.id.button_add_year_prevpreg);

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
