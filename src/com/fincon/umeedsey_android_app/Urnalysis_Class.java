package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Urnalysis_Class extends Activity {

	public static String rslt = "";

	Button BTN_Save;
	EditText ET_Remarks;
	Spinner SP_Leukocyte;
	RadioGroup RG_Protein, RG_Glucose;
	RadioButton RB_Protein, RB_Glucose;

	int RG_Protein_ID, RG_Glucose_ID;
	int Validator = 22;
	String Current_Date, No_of_Visits, Gestation_Week;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.urinalysis);

		BTN_Save = (Button) findViewById(R.id.button_save_urinalysis);
		SP_Leukocyte = (Spinner) findViewById(R.id.spinner_leukocyte_urinalysis);
		ET_Remarks = (EditText) findViewById(R.id.remarks_urinalysis);

		RG_Protein = (RadioGroup) findViewById(R.id.radio_protein_utinalysis);
		RG_Glucose = (RadioGroup) findViewById(R.id.radio_glucose_urinalysis);

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

			c.selection = 222;
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

		Toast.makeText(Urnalysis_Class.this, "No of Visits" + rslt,
				Toast.LENGTH_SHORT).show();

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

			c.selection = 331;
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
		Toast.makeText(Urnalysis_Class.this, "Gestation Weeks" + rslt,
				Toast.LENGTH_SHORT).show();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Validator = 22;

				if (RG_Glucose.getCheckedRadioButtonId() == -1
						|| RG_Protein.getCheckedRadioButtonId() == -1) {
					Validator = 11;

					Toast.makeText(Urnalysis_Class.this,
							"Select all the Radio Options !.." + rslt,
							Toast.LENGTH_SHORT).show();
				}

				if (SP_Leukocyte.getSelectedItem().toString()
						.equals("Select Value")) {

					Validator = 11;
					Toast.makeText(Urnalysis_Class.this,
							"Select the Leukocyte Value !.." + rslt,
							Toast.LENGTH_SHORT).show();
				}

				if (Validator == 22) {
					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertPatientLabTest";
						c.arg1a = "PatientLabTests";

						// c.arg1_value = SessionClass.getUser_id() + "@"
						// + Current_Date + "@"
						// + "00000000-0000-0000-0000-000000000000" + "@"
						// + IDs_Class.getAM_Patient_ID() + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + ET_Remarks.getText().toString() + "@" + "1" + "@"
						// + Gestation_Week + "@" + No_of_Visits + "@"
						// + Current_Date;

						c.arg1_value = "E85279FF-014B-49D8-AFF7-72844EA23AAE@9-11-2014@00000000-0000-0000-0000-000000000000@2@2@dads@1@28@1@9-11-2014";

						c.selection = 110;
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

					Toast.makeText(Urnalysis_Class.this,
							"Server Response" + rslt, Toast.LENGTH_SHORT)
							.show();

					Intent i = new Intent(Urnalysis_Class.this, DashBoard.class);
					startActivity(i);
				}

			}
		});

	}

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		Current_Date = (new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" ")).toString();

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
