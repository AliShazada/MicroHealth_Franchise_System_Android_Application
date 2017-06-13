package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Phyical_Examination_class extends Activity {

	public static String rslt = "";

	RadioGroup RG_jaundice, RG_Goiter, RG_vaicose, RG_conjunctiva, RG_breast,
			RG_nipples, RG_oro_dental_hygeine, RG_Lymph_nodes;

	RadioButton RB_jaundice, RB_Goiter, RB_vaicose, RB_conjunctiva, RB_breast,
			RB_nipples, RB_oro_dental_hygeine, RB_Lymph_nodes;

	Button Save, Discard;

	String Gestation_Week, Current_Date;

	int ID_RG_jaundice, ID_RG_Goiter, ID_RG_vaicose, ID_RG_conjunctiva,
			ID_RG_breast, ID_RG_nipples, ID_RG_oro_dental_hygeine,
			ID_RG_Lymph_nodes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.physical_examination);

		RG_jaundice = (RadioGroup) findViewById(R.id.radio_jaundice_physical);
		RG_Goiter = (RadioGroup) findViewById(R.id.radio_goiter_physical);
		RG_vaicose = (RadioGroup) findViewById(R.id.radio_vaicose_veins);
		RG_conjunctiva = (RadioGroup) findViewById(R.id.radio_conjunctiva);
		RG_breast = (RadioGroup) findViewById(R.id.radio_breast);
		RG_nipples = (RadioGroup) findViewById(R.id.radio_nipples);
		RG_oro_dental_hygeine = (RadioGroup) findViewById(R.id.radio_oro_dental_hygeine);
		RG_Lymph_nodes = (RadioGroup) findViewById(R.id.radio_Lymph_nodes);

		Save = (Button) findViewById(R.id.btn_save_physical);
		Discard = (Button) findViewById(R.id.btn_discard_physical);

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

			c.selection = 332;
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

		// TOAST.MAKETEXT(PHYICAL_EXAMINATION_CLASS.THIS,
		// "GESTATION WEEKS" + RSLT, TOAST.LENGTH_SHORT).SHOW();

		Gestation_Week = rslt;

		// // Getting the value of gastation week from the DataBase CLOSED//////
		// .........................................

		// Toast.makeText(Phyical_Examination_class.this,
		// "IDs_Class.getPatient_ID()" + IDs_Class.getPatient_ID(),
		// Toast.LENGTH_SHORT).show();
		//
		// Toast.makeText(Phyical_Examination_class.this,
		// "IDs_Class.getCurrentPregnancyCase_ID()" +
		// IDs_Class.getCurrentPregnancyCase_ID(), Toast.LENGTH_SHORT).show();

		Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ID_RG_jaundice = RG_jaundice.getCheckedRadioButtonId();
				ID_RG_Goiter = RG_Goiter.getCheckedRadioButtonId();
				ID_RG_vaicose = RG_vaicose.getCheckedRadioButtonId();
				ID_RG_conjunctiva = RG_conjunctiva.getCheckedRadioButtonId();
				ID_RG_breast = RG_breast.getCheckedRadioButtonId();
				ID_RG_nipples = RG_nipples.getCheckedRadioButtonId();
				ID_RG_oro_dental_hygeine = RG_oro_dental_hygeine
						.getCheckedRadioButtonId();
				ID_RG_Lymph_nodes = RG_Lymph_nodes.getCheckedRadioButtonId();

				RB_jaundice = (RadioButton) findViewById(ID_RG_jaundice);
				RB_Goiter = (RadioButton) findViewById(ID_RG_Goiter);
				RB_vaicose = (RadioButton) findViewById(ID_RG_vaicose);
				RB_conjunctiva = (RadioButton) findViewById(ID_RG_conjunctiva);
				RB_breast = (RadioButton) findViewById(ID_RG_breast);
				RB_nipples = (RadioButton) findViewById(ID_RG_nipples);
				RB_oro_dental_hygeine = (RadioButton) findViewById(ID_RG_oro_dental_hygeine);
				RB_Lymph_nodes = (RadioButton) findViewById(ID_RG_Lymph_nodes);

				if (RG_jaundice.getCheckedRadioButtonId() == -1
						|| RG_Goiter.getCheckedRadioButtonId() == -1
						|| RG_vaicose.getCheckedRadioButtonId() == -1
						|| RG_conjunctiva.getCheckedRadioButtonId() == -1
						|| RG_breast.getCheckedRadioButtonId() == -1
						|| RG_nipples.getCheckedRadioButtonId() == -1
						|| RG_oro_dental_hygeine.getCheckedRadioButtonId() == -1
						|| RG_Lymph_nodes.getCheckedRadioButtonId() == -1) {

					Toast.makeText(Phyical_Examination_class.this,
							"Select all the Radio Options !.." + rslt,
							Toast.LENGTH_SHORT).show();

				} else {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "PhysicalExamination";
						c.arg1a = "PhysicalExamination";

						// c.arg1_value = IDs_Class.getPatient_ID() + "@" + "30"
						// +
						// "@"
						// + RB_jaundice.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "31" + "@" + RB_Goiter.getText().toString()
						// + "@" + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "28" + "@"
						// + RB_vaicose.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "29" + "@"
						// + RB_conjunctiva.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "32" + "@" + RB_breast.getText().toString()
						// + "@" + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "36" + "@"
						// + RB_nipples.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "34" + "@"
						// + RB_oro_dental_hygeine.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week + "|" + IDs_Class.getPatient_ID()
						// + "@" + "35" + "@"
						// + RB_Lymph_nodes.getText().toString() + "@"
						// + "Description" + "@" + Current_Date + "@"
						// + IDs_Class.getCurrentPregnancyCase_ID() + "@"
						// + Gestation_Week;

						c.arg1_value = "2@30@Yes@Description@9-16-2014@2@2|2@31@Yes@Description@9-16-2014@2@2|2@28@Yes@Description@9-16-2014@2@2|2@29@Yes@Description@9-16-2014@2@2|2@32@Yes@Description@9-16-2014@2@2|2@36@Yes@Description@9-16-2014@2@2|2@34@Yes@Description@9-16-2014@2@2|2@35@Yes@Description@9-16-2014@2@2";

						c.selection = 111;
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

					// Toast.makeText(Phyical_Examination_class.this,
					// "Server Response" + rslt, Toast.LENGTH_SHORT)
					// .show();

					Toast.makeText(Phyical_Examination_class.this,
							"Saved Successfully", Toast.LENGTH_SHORT).show();

					DashBoardSession.setPhysicalExaminaton(11);

					Intent i = new Intent(Phyical_Examination_class.this,
							DashBoard.class);
					startActivity(i);

				}
			}
		});

		Discard.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(Phyical_Examination_class.this, "Skipped !..",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Phyical_Examination_class.this,
						DashBoard.class);
				startActivity(i);

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
