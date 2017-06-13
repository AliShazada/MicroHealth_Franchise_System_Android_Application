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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Antenatal_Class extends Activity {

	public static String rslt = "";

	EditText ET_Gastation, ET_Weight, ET_BP_Sys, ET_BP_Dys, ET_FundalHeight,
			ET_FetalHeart, ET_Remarks, tvDisplayDate;

	Spinner SP_Presentation;

	RadioGroup RG_EngagementAntenatal, RG_EdemaAntenatal, RG_Anemia, RG_Fetal;

	RadioButton RB_EngagmentAntenatal, RB_EdemaAntenatal, RB_Anemia, RB_Fetal;

	int RB_EngagmentAntenatal_ID, RB_EdemaAntenatal_ID, RB_Anemia_ID,
			RB_Fetal_ID;

	Button Save, Discard, btnChangeDate;

	int year;
	int month;
	int day;
	static final int DATE_DIALOG_ID = 999;

	int Validator = 22;

	String Current_Date;
	String No_of_Visits;
	String Gestation_Week;

	DateCheckClass objDate = new DateCheckClass();
	WeekClass objWeek = new WeekClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.antenatal_visit_record);

		setCurrentDateOnView();
		addListenerOnButton();

		Save = (Button) findViewById(R.id.button_save_anenatal);
		Discard = (Button) findViewById(R.id.button_discard_anenatal);

		ET_Gastation = (EditText) findViewById(R.id.editText_Gastation_antenatal);
		ET_Weight = (EditText) findViewById(R.id.editText_Weight_antenatal);
		ET_BP_Sys = (EditText) findViewById(R.id.editText_Blood_Pressure_systolic_antenatal);
		ET_BP_Dys = (EditText) findViewById(R.id.editText_Blood_Pressure_diastolic_antenatal);
		ET_FundalHeight = (EditText) findViewById(R.id.editText_fundal_Height_antenatal);
		ET_FetalHeart = (EditText) findViewById(R.id.editText_fetal_heart_antenatal);
		ET_Remarks = (EditText) findViewById(R.id.remarks_anenatal);

		RG_EngagementAntenatal = (RadioGroup) findViewById(R.id.radio_engagement_antenantal);
		RG_EdemaAntenatal = (RadioGroup) findViewById(R.id.radio_edema_antenantal);
		RG_Anemia = (RadioGroup) findViewById(R.id.radio_anemia_antenantal);
		RG_Fetal = (RadioGroup) findViewById(R.id.radio_fetal_antenantal);

		SP_Presentation = (Spinner) findViewById(R.id.spinner_presentation_antenatal);

		// =========================================================================================================
		ET_Weight.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_NumberPoint(ET_Weight);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_Gastation.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(ET_Gastation);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_BP_Sys.addTextChangedListener(new TextWatcher() {

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
				// //Is_Valid_Number(ET_BP_Sys);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_BP_Dys.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(ET_BP_Dys);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_FundalHeight.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(ET_FundalHeight);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_FetalHeart.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(ET_FetalHeart);
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

			c.selection = 221;
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

		Toast.makeText(Antenatal_Class.this, "No of Visits" + rslt,
				Toast.LENGTH_SHORT).show();

		No_of_Visits = rslt;

		// // Get the No. of visits from the Service Closed
		// //////////////////////....................................................

		// // Getting the value of gastation week from the DataBase
		// ////.............
		// ...........................................................................

		Toast.makeText(
				Antenatal_Class.this,
				"IDs_Class.getAM_Patient_ID() : "
						+ IDs_Class.getAM_Patient_ID()
						+ "IDs_Class.getCurrentPregnancyCase_ID() : "
						+ IDs_Class.getCurrentPregnancyCase_ID()
						+ "IDs_Class.getLMP() : " + IDs_Class.getLMP(),
				Toast.LENGTH_SHORT).show();

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

			c.selection = 3310;
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
		Toast.makeText(Antenatal_Class.this, "Gestation Weeks" + rslt,
				Toast.LENGTH_SHORT).show();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		ET_Gastation.setKeyListener(null);

		ET_Gastation.setText(String.valueOf(objWeek.WeekCalculator(
				Current_Date, IDs_Class.getLMP())));

		ET_Weight.setText(IDs_Class.getMotherWeight());

		Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Validator = 22;

				RB_EngagmentAntenatal_ID = RG_EngagementAntenatal
						.getCheckedRadioButtonId();
				RB_EdemaAntenatal_ID = RG_EdemaAntenatal
						.getCheckedRadioButtonId();
				RB_Anemia_ID = RG_Anemia.getCheckedRadioButtonId();
				RB_Fetal_ID = RG_Fetal.getCheckedRadioButtonId();

				RB_EngagmentAntenatal = (RadioButton) findViewById(RB_EngagmentAntenatal_ID);
				RB_EdemaAntenatal = (RadioButton) findViewById(RB_EdemaAntenatal_ID);
				RB_Anemia = (RadioButton) findViewById(RB_Anemia_ID);
				RB_Fetal = (RadioButton) findViewById(RB_Fetal_ID);

				if (RG_EngagementAntenatal.getCheckedRadioButtonId() == -1
						|| RG_EdemaAntenatal.getCheckedRadioButtonId() == -1
						|| RG_Anemia.getCheckedRadioButtonId() == -1
						|| RG_Fetal.getCheckedRadioButtonId() == -1) {

					Validator = 11;
					Toast.makeText(Antenatal_Class.this,
							"Select All Radio Buttons" + rslt,
							Toast.LENGTH_SHORT).show();

				}

				if (SP_Presentation.getSelectedItem().toString()
						.equals("Select Presentation")) {
					Toast.makeText(Antenatal_Class.this,
							"Select Presentation Value" ,
							Toast.LENGTH_SHORT).show();

					Validator = 11;
				}

				int result = objDate.DateChecker(Current_Date, tvDisplayDate
						.getText().toString());

				if (result == 1) {
					Toast.makeText(Antenatal_Class.this,
							"Invalid Next Visit Date ! ..", Toast.LENGTH_SHORT)
							.show();
					Validator = 11;
				}

				if (Validator == 22) {
					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "AntenantalVisit";
						c.arg1a = "AntenatalVisits";

						c.arg1_value = IDs_Class.getAM_Patient_ID() + "@"
								+ IDs_Class.getCurrentPregnancyCase_ID() + "@"
								+ Current_Date + "@"
								+ ET_Gastation.getText().toString() + "@"
								+ RB_EdemaAntenatal.getText().toString() + "@"
								+ ET_Weight.getText().toString() + "@"
								+ ET_BP_Sys.getText().toString() + "/"
								+ ET_BP_Dys.getText().toString() + "@"
								+ ET_FundalHeight.getText().toString() + "@"
								+ SP_Presentation.getSelectedItem().toString()
								+ "@" + ET_FetalHeart.getText().toString()
								+ "@" + RB_Fetal.getText().toString() + "@"
								+ ET_Remarks.getText().toString() + "@"
								+ tvDisplayDate.getText().toString() + "@"
								+ "00000000-0000-0000-0000-000000000000" + "@"
								+ SessionClass.getUser_id() + "@"
								+ No_of_Visits + "@"
								+ RB_Anemia.getText().toString() + "@"
								+ RB_EngagmentAntenatal.getText().toString();
						c.selection = 19;
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

					// Toast.makeText(Antenatal_Class.this, "Server Response " +
					// rslt,
					// Toast.LENGTH_SHORT).show();

					Toast.makeText(Antenatal_Class.this,
							"Saved Succesfully " + rslt, Toast.LENGTH_SHORT)
							.show();

					
					
					IDs_Class.setAntenatal_ID(rslt);
					
					DashBoardSession.setAntenatalVisit(11);

					Intent i = new Intent(Antenatal_Class.this,
							Urnalysis_Class.class);
					startActivity(i);
				}

			}
		});

		Discard.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Antenatal_Class.this,
						DashBoard.class);
				startActivity(i);

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

	// =========================================================================================================
	public void Is_Valid_NumberPoint(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Decimals Only.");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[0-9. ]+")) {
			edt.setError("Accept Decimals Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.date_of_next_visit_antenatal);
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

		btnChangeDate = (Button) findViewById(R.id.button_add_date_of_next_visit_antenatal);

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
