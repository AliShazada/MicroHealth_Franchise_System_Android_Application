package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Present_pregnancy_record extends Activity {

	public static String rslt = "";

	EditText Gravida, Para, tvDisplayDate, Expected_delivery_date;
	String Current_Date;

	String Concatinated_Message;
	Button save, btnChangeDate;

	Spinner pregType;

	ValidatorClass obj = new ValidatorClass();
	WeekClass objWeek = new WeekClass();
	Calendar now = Calendar.getInstance();
	DateCheckClass objDate = new DateCheckClass();

	static final int DATE_DIALOG_ID = 999;

	int year;
	int month;
	int day;
	int Validator = 0;

	int Gravida_Value = 0;
	int Para_Value = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.present_pragnancy_record);

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		setCurrentDateOnView();
		addListenerOnButton();

		Gravida = (EditText) findViewById(R.id.editText_Gravida);
		Para = (EditText) findViewById(R.id.editText_para);
		tvDisplayDate = (EditText) findViewById(R.id.editText_last_mentrual_period);
		Expected_delivery_date = (EditText) findViewById(R.id.editText_Expected_date_of_delivery);

		pregType = (Spinner) findViewById(R.id.spinner_presentPreg);

		pregType.setClickable(false);

		tvDisplayDate.setKeyListener(null);
		Expected_delivery_date.setKeyListener(null);

		save = (Button) findViewById(R.id.save_present_pregnancy);

		now.add(Calendar.MONTH, 9);
		System.out.println("date after 10 months : "
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE)
				+ "-" + now.get(Calendar.YEAR));

		Expected_delivery_date.setText((now.get(Calendar.MONTH) + 1) + "-"
				+ now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

		// =========================================================================================================
		Gravida.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(Gravida);
				Para.setText("");
				if (Gravida.getText().toString().equals("1")) {
					// mySpinner.setSelection(((ArrayAdapter)mySpinner.getAdapter()).getPosition("Value‌​"));
					pregType.setSelection(1);
					Para.setKeyListener(null);
					Para.setText("0");
				} else if ((Gravida.getText().toString()).equals("")) {
					pregType.setSelection(0);
					Para.setInputType(InputType.TYPE_CLASS_TEXT);
					Para.setFocusable(true);
				} else {
					pregType.setSelection(2);
					Para.setInputType(InputType.TYPE_CLASS_TEXT);
					Para.setFocusable(true);
				}
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Para.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(Para);
			}
		});
		// =========================================================================================================

		save.setOnClickListener(new View.OnClickListener() {

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

					if (Gravida.getText().toString().length() <= 0
							|| Para.getText().toString().length() <= 0) {
						Toast.makeText(getApplicationContext(),
								"Enter the value in Empty Textboxes",
								Toast.LENGTH_SHORT).show();

						Validator = 11;
					}

					if (Integer.parseInt(Gravida.getText().toString()) < Integer
							.parseInt(Para.getText().toString())) {

						Toast.makeText(getApplicationContext(),
								"Gravida value must be greater than Para",
								Toast.LENGTH_SHORT).show();

						Validator = 11;

					}

					int result = objDate.DateChecker(Current_Date,
							tvDisplayDate.getText().toString());

					if (result != 1) {
						Toast.makeText(Present_pregnancy_record.this,
								"LMP should be less than 41 weeks! ..",
								Toast.LENGTH_SHORT).show();
						Validator = 11;
					}

					if (result == 1) {
						int temp_week_value = objWeek.WeekCalculator(
								Current_Date, tvDisplayDate.getText()
										.toString());

						if (temp_week_value > 41) {
							Validator = 11;

							Toast.makeText(Present_pregnancy_record.this,
									"LMP is greater than 41 weeks",
									Toast.LENGTH_SHORT).show();

						}

						if (temp_week_value < 4) {
							Validator = 11;

							Toast.makeText(Present_pregnancy_record.this,
									"LMP is less than 4 weeks",
									Toast.LENGTH_SHORT).show();
						}

					}

					if (Validator != 11) {

						// / Saving the no of weeks
						IDs_Class.setNo_of_weeks(objWeek.WeekCalculator(
								Current_Date, tvDisplayDate.getText()
										.toString()));
						String TotalWeeks = String.valueOf(objWeek
								.WeekCalculator(Current_Date, tvDisplayDate
										.getText().toString()));
						objWeek.WeekCalculator(Current_Date, tvDisplayDate
								.getText().toString());

						IDs_Class.setGestationWeek(String.valueOf(objWeek
								.WeekCalculator(Current_Date, tvDisplayDate
										.getText().toString())));

						// //

						Gravida_Value = Integer.parseInt(Gravida.getText()
								.toString());
						Para_Value = Integer
								.parseInt(Para.getText().toString());

						Concatinated_Message = pregType.getSelectedItem()
								.toString()
								+ ","
								+ Para.getText().toString()
								+ ","
								+ Gravida.getText().toString()
								+ ","
								+ tvDisplayDate.getText().toString()
								+ ","
								+ Expected_delivery_date.getText().toString()
								+ ","
								+ SessionClass.getUser_id()
								+ ","
								+ IDs_Class.getAM_Patient_ID()
								+ ","
								+ SessionClass.getCMW_id();

						// Concatinated_Message = pregType.getSelectedItem()
						// .toString()
						// + ","
						// + Para.getText().toString()
						// + ","
						// + Gravida.getText().toString()
						// + ","
						// + tvDisplayDate.getText().toString()
						// + ","
						// + tvDisplayDate.getText().toString()
						// + ","
						// + SessionClass.getUser_id() + "," + "2" + "," + "5";

						IDs_Class.setLMP(tvDisplayDate.getText().toString());

						IDs_Class.setLMPDay(day);
						IDs_Class.setLMPMonth(month);
						IDs_Class.setLMPYear(year);

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "PragnencyCases";
							c.arg1a = "pregnancyCases";

							c.arg1_value = Concatinated_Message;

							c.selection = 14;

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

						Toast.makeText(Present_pregnancy_record.this,
								"Saved Successfully !", Toast.LENGTH_SHORT)
								.show();

						IDs_Class.setCurrentPregnancyCase_ID(rslt);

						// // Adding values in the list................

						String list_string = IDs_Class.getAM_Patient_ID() + "@"
								+ IDs_Class.getCurrentPregnancyCase_ID() + "@"
								+ TotalWeeks + "@" + "" + "@" + "" + "@"
								+ SessionClass.getUser_id();

						// Toast.makeText(Present_pregnancy_record.this,
						// "list_string :" + list_string,
						// Toast.LENGTH_SHORT).show();
						// PatientID,PregnancyID,DayOfWeek,CPatientStatus,comments,createdby

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "PatientStatus";
							c.arg1a = "PatientStatus";

							c.arg1_value = list_string;

							c.selection = 1121;

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

						Toast.makeText(Present_pregnancy_record.this,
								"Saved Successfully !", Toast.LENGTH_SHORT)
								.show();

						// //// closed.................................

						// /// Another method ////...........

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "InsertDeliveryCheckPrenatal";
							c.arg1a = "DeliveryCheck";

							c.arg1_value = IDs_Class.getAM_Patient_ID() + "@"
									+ IDs_Class.getCurrentPregnancyCase_ID()
									+ "@" + Current_Date;

							c.selection = 1121;

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

						Toast.makeText(Present_pregnancy_record.this,
								"Saved Successfully !", Toast.LENGTH_SHORT)
								.show();

						// /// Another method Closed ////...........

						if (Gravida_Value > 1) {

							IDs_Class.setGravida_counter(Gravida_Value - 1);

							Intent i = new Intent(
									Present_pregnancy_record.this,
									PreviousPregnencyClass.class);

							startActivity(i);
						} else if (Gravida_Value == 1) {
							Intent i = new Intent(
									Present_pregnancy_record.this,
									Allergies_Class.class);
							startActivity(i);
						}

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

		tvDisplayDate = (EditText) findViewById(R.id.editText_last_mentrual_period);
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

		btnChangeDate = (Button) findViewById(R.id.button_add_Mentural_period);

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

			AgeCalculation obj = new AgeCalculation();

			Expected_delivery_date.setText(obj.DeliveryDate(year, month, day));

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
