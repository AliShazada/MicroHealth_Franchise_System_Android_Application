package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Medical_HistoryClass extends Activity {

	public static String rslt = "";

	String Concatinated_String = null;
	String Current_Date = null;
	int Dia_ID, Ane_ID, Hyper_ID, CaRBia_ID, BloodTransfuion_ID, RENTALD_ID,
			Hepa_ID, CurrentMED_ID, Allergies_ID, APSurjery_ID,
			OvstetricSurgery_ID;

	RadioButton Dia_RB, Ane_RB, Hyper_RB, CaRBia_RB, BloodTransfuion_RB,
			RENTALD_RB, Hepa_RB, CurrentMED_RB, Allergies_RB, APSurjery_RB,
			OvstetricSurgery_RB;
	RadioGroup Dia_RGroup, Ane_RGroup, Hyper_RGroup, CaRBia_RGroup,
			BloodTransfuion_RGroup, RENTALD_RGroup, Hepa_RGroup,
			CurrentMED_RGroup, Allergies_RGroup, APSurjery_RGroup,
			OvstetricSurgery_RGroup;
	Button saveBTn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medical_histoy);
		final AlertDialog ad = new AlertDialog.Builder(this).create();
		setCurrentDate();

		Dia_RGroup = (RadioGroup) findViewById(R.id.radio_diab_medical);
		Ane_RGroup = (RadioGroup) findViewById(R.id.radio_Anemia);
		Hyper_RGroup = (RadioGroup) findViewById(R.id.radio_hypertensionn);
		CaRBia_RGroup = (RadioGroup) findViewById(R.id.radio_cardiac_problems);
		BloodTransfuion_RGroup = (RadioGroup) findViewById(R.id.radio_Blood_Transfusion);
		RENTALD_RGroup = (RadioGroup) findViewById(R.id.radio_Renal_Diseases);
		Hepa_RGroup = (RadioGroup) findViewById(R.id.radio_Hepatatis);
		CurrentMED_RGroup = (RadioGroup) findViewById(R.id.radio_Current_Medication);
		Allergies_RGroup = (RadioGroup) findViewById(R.id.radio_Allergies);
		APSurjery_RGroup = (RadioGroup) findViewById(R.id.radio_AbdominoPelvicSurgery);
		OvstetricSurgery_RGroup = (RadioGroup) findViewById(R.id.radio_Obstetric_Surgery);

		saveBTn = (Button) findViewById(R.id.save_medicalHistory);

		saveBTn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {

					Dia_ID = Dia_RGroup.getCheckedRadioButtonId();
					Ane_ID = Ane_RGroup.getCheckedRadioButtonId();
					Hyper_ID = Hyper_RGroup.getCheckedRadioButtonId();
					CaRBia_ID = CaRBia_RGroup.getCheckedRadioButtonId();
					BloodTransfuion_ID = BloodTransfuion_RGroup
							.getCheckedRadioButtonId();
					RENTALD_ID = RENTALD_RGroup.getCheckedRadioButtonId();
					Hepa_ID = Hepa_RGroup.getCheckedRadioButtonId();
					CurrentMED_ID = CurrentMED_RGroup.getCheckedRadioButtonId();
					Allergies_ID = Allergies_RGroup.getCheckedRadioButtonId();
					APSurjery_ID = APSurjery_RGroup.getCheckedRadioButtonId();
					OvstetricSurgery_ID = OvstetricSurgery_RGroup
							.getCheckedRadioButtonId();

					Dia_RB = (RadioButton) findViewById(Dia_ID);
					Ane_RB = (RadioButton) findViewById(Ane_ID);
					Hyper_RB = (RadioButton) findViewById(Hyper_ID);
					CaRBia_RB = (RadioButton) findViewById(CaRBia_ID);
					BloodTransfuion_RB = (RadioButton) findViewById(BloodTransfuion_ID);
					RENTALD_RB = (RadioButton) findViewById(RENTALD_ID);
					Hepa_RB = (RadioButton) findViewById(Hepa_ID);
					CurrentMED_RB = (RadioButton) findViewById(CurrentMED_ID);
					Allergies_RB = (RadioButton) findViewById(Allergies_ID);
					APSurjery_RB = (RadioButton) findViewById(APSurjery_ID);
					OvstetricSurgery_RB = (RadioButton) findViewById(OvstetricSurgery_ID);

					if (Dia_RGroup.getCheckedRadioButtonId() == -1
							|| Ane_RGroup.getCheckedRadioButtonId() == -1
							|| Hyper_RGroup.getCheckedRadioButtonId() == -1
							|| CaRBia_RGroup.getCheckedRadioButtonId() == -1
							|| BloodTransfuion_RGroup.getCheckedRadioButtonId() == -1
							|| RENTALD_RGroup.getCheckedRadioButtonId() == -1
							|| Hepa_RGroup.getCheckedRadioButtonId() == -1
							|| CurrentMED_RGroup.getCheckedRadioButtonId() == -1
							|| Allergies_RGroup.getCheckedRadioButtonId() == -1
							|| APSurjery_RGroup.getCheckedRadioButtonId() == -1
							|| OvstetricSurgery_RGroup
									.getCheckedRadioButtonId() == -1) {

						Toast.makeText(Medical_HistoryClass.this,
								"Check all the Radio Options",
								Toast.LENGTH_SHORT).show();

					} else {

						Concatinated_String = IDs_Class.getPatient_ID() + ","
								+ "1" + "," + Dia_RB.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "2" + ","
								+ Ane_RB.getText().toString() + "," + "" + ","
								+ Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "3" + ","
								+ Hyper_RB.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "4" + ","
								+ CaRBia_RB.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "5" + ","
								+ BloodTransfuion_RB.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "6" + ","
								+ Hepa_RB.getText().toString() + "," + "" + ","
								+ Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "7" + ","
								+ CurrentMED_RB.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "8" + ","
								+ Allergies_RB.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "9" + ","
								+ APSurjery_RB.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "13" + ","
								+ OvstetricSurgery_RB.getText().toString()
								+ "," + "" + "," + Current_Date + "," + "0";

						// Toast.makeText(getApplicationContext(),
						// "Dkho " + Concatinated_String, Toast.LENGTH_SHORT)
						// .show();

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "InsertHistoryAnswers";
							c.arg1a = "historyAnswer";

							c.arg1_value = Concatinated_String;

							c.selection = 13;

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

						Toast.makeText(Medical_HistoryClass.this,
								"Saved Succesfully !", Toast.LENGTH_SHORT)
								.show();

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "InsertPatientFlagCheck";

							c.arg1a = "PatientID";
							c.arg2a = "CurrentDate";

							c.arg1_value = IDs_Class.getAM_Patient_ID();
							c.arg2_value = Current_Date;

							c.selection = 226;
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
						Toast.makeText(Medical_HistoryClass.this,
								"Result = " + rslt, Toast.LENGTH_SHORT).show();

						IDs_Class.setPatientFlagCheck(rslt);

						Intent i = new Intent(Medical_HistoryClass.this,
								Present_pregnancy_record.class);

						startActivity(i);
					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Internet is  not available", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});
	}

	public void setCurrentDate() {

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
