package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Genetic_History_Class extends Activity {

	public static String rslt = "";

	String Concatinated_String = null;
	String Current_Date = null;

	int Dia_ID, Chro_ID, Hemo_ID, Cousin_ID, phorphy_ID, hyper_ID,
			Drug_Abuse_ID, Smoking_ID, MultiPreg_ID, RadioCard_ID,
			AnyBirthDefect_ID, InheritedDisease_ID;
	RadioGroup Dia_RadioGroup, Chro_RadioGroup, Hemo_RadioGroup,
			Cousin_RadioGroup, phorphy_RadioGroup, hyper_RadioGroup,
			Drug_Abuse_RadioGroup, Smoking_RadioGroup, MultiPreg_RadioGroup,
			Cardiac_RadioGroup, AnyBirthDefect_RadioGroup,
			InheritedDisease_RadioGroup;
	RadioButton Dia_RadioBtn, Chro_RadioBtn, Hemo_RadioBtn, Cousin_RadioBtn,
			phorphy_RadioBtn, hyper_RadioBtn, Drug_Abuse_RadioBtn,
			Smoking_RadioBtn, MultiPreg_RadioBtn, Cardiac_RadioBtn,
			AnyBirthDefect_RadioBtn, InheritedDisease_RadioBtn;
	Button SaveBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.genetic_history_form1);
		final AlertDialog ad = new AlertDialog.Builder(this).create();

		setCurrentDate();

		Dia_RadioGroup = (RadioGroup) findViewById(R.id.radio_diab);
		Chro_RadioGroup = (RadioGroup) findViewById(R.id.radio_chromosomal_problems);
		Hemo_RadioGroup = (RadioGroup) findViewById(R.id.radio_hemoglobinopathies);
		Cousin_RadioGroup = (RadioGroup) findViewById(R.id.radio_cousin_marriage);
		phorphy_RadioGroup = (RadioGroup) findViewById(R.id.radio_porphyria);
		hyper_RadioGroup = (RadioGroup) findViewById(R.id.radio_HyperTension);
		Drug_Abuse_RadioGroup = (RadioGroup) findViewById(R.id.radio_Drug_Abuse);
		Smoking_RadioGroup = (RadioGroup) findViewById(R.id.radio_Smoking);
		MultiPreg_RadioGroup = (RadioGroup) findViewById(R.id.radio_Multiple_Pregnency);
		Cardiac_RadioGroup = (RadioGroup) findViewById(R.id.radio_cardiac);
		AnyBirthDefect_RadioGroup = (RadioGroup) findViewById(R.id.radio_Any_Birth_Defect);
		InheritedDisease_RadioGroup = (RadioGroup) findViewById(R.id.radio_inherited_disease);

		SaveBtn = (Button) findViewById(R.id.Save_geneticHistory);

		SaveBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {

					Dia_ID = Dia_RadioGroup.getCheckedRadioButtonId();
					Chro_ID = Chro_RadioGroup.getCheckedRadioButtonId();
					Hemo_ID = Hemo_RadioGroup.getCheckedRadioButtonId();
					Cousin_ID = Cousin_RadioGroup.getCheckedRadioButtonId();
					phorphy_ID = phorphy_RadioGroup.getCheckedRadioButtonId();
					hyper_ID = hyper_RadioGroup.getCheckedRadioButtonId();
					Drug_Abuse_ID = Drug_Abuse_RadioGroup
							.getCheckedRadioButtonId();
					Smoking_ID = Smoking_RadioGroup.getCheckedRadioButtonId();
					MultiPreg_ID = MultiPreg_RadioGroup
							.getCheckedRadioButtonId();
					RadioCard_ID = Cardiac_RadioGroup.getCheckedRadioButtonId();
					AnyBirthDefect_ID = AnyBirthDefect_RadioGroup
							.getCheckedRadioButtonId();
					InheritedDisease_ID = InheritedDisease_RadioGroup
							.getCheckedRadioButtonId();

					Dia_RadioBtn = (RadioButton) findViewById(Dia_ID);
					Chro_RadioBtn = (RadioButton) findViewById(Chro_ID);
					Hemo_RadioBtn = (RadioButton) findViewById(Hemo_ID);
					Cousin_RadioBtn = (RadioButton) findViewById(Cousin_ID);
					phorphy_RadioBtn = (RadioButton) findViewById(phorphy_ID);
					hyper_RadioBtn = (RadioButton) findViewById(hyper_ID);
					Drug_Abuse_RadioBtn = (RadioButton) findViewById(Drug_Abuse_ID);
					Smoking_RadioBtn = (RadioButton) findViewById(Smoking_ID);
					MultiPreg_RadioBtn = (RadioButton) findViewById(MultiPreg_ID);
					Cardiac_RadioBtn = (RadioButton) findViewById(RadioCard_ID);
					AnyBirthDefect_RadioBtn = (RadioButton) findViewById(AnyBirthDefect_ID);
					InheritedDisease_RadioBtn = (RadioButton) findViewById(InheritedDisease_ID);

					if (Dia_RadioGroup.getCheckedRadioButtonId() == -1
							|| Chro_RadioGroup.getCheckedRadioButtonId() == -1
							|| Hemo_RadioGroup.getCheckedRadioButtonId() == -1
							|| Cousin_RadioGroup.getCheckedRadioButtonId() == -1
							|| phorphy_RadioGroup.getCheckedRadioButtonId() == -1
							|| hyper_RadioGroup.getCheckedRadioButtonId() == -1
							|| Drug_Abuse_RadioGroup.getCheckedRadioButtonId() == -1
							|| Smoking_RadioGroup.getCheckedRadioButtonId() == -1
							|| MultiPreg_RadioGroup.getCheckedRadioButtonId() == -1
							|| Cardiac_RadioGroup.getCheckedRadioButtonId() == -1
							|| AnyBirthDefect_RadioGroup
									.getCheckedRadioButtonId() == -1
							|| InheritedDisease_RadioGroup
									.getCheckedRadioButtonId() == -1)

					{
						Toast.makeText(Genetic_History_Class.this,
								"Check all the Radio Options",
								Toast.LENGTH_SHORT).show();

					} else {

						Concatinated_String = IDs_Class.getPatient_ID() + ","
								+ "13" + ","
								+ Dia_RadioBtn.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "14" + ","
								+ Chro_RadioBtn.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "15" + ","
								+ Hemo_RadioBtn.getText().toString() + "," + ""
								+ "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "16" + ","
								+ Cousin_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "17" + ","
								+ phorphy_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "18" + ","
								+ hyper_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "19" + ","
								+ Drug_Abuse_RadioBtn.getText().toString()
								+ "," + "" + "," + Current_Date + "," + "0"
								+ "/"

								+ IDs_Class.getPatient_ID() + "," + "20" + ","
								+ Smoking_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "21" + ","
								+ MultiPreg_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "22" + ","
								+ Cardiac_RadioBtn.getText().toString() + ","
								+ "" + "," + Current_Date + "," + "0" + "/"

								+ IDs_Class.getPatient_ID() + "," + "23" + ","
								+ AnyBirthDefect_RadioBtn.getText().toString()
								+ "," + "" + "," + Current_Date + "," + "0"
								+ "/"

								+ IDs_Class.getPatient_ID() + "," + "24" + ","
								+ AnyBirthDefect_RadioBtn.getText().toString()
								+ "," + "" + "," + Current_Date + "," + "0";

						try {
							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "InsertHistoryAnswers";
							c.arg1a = "historyAnswer";

							c.arg1_value = Concatinated_String;
							c.selection = 12;

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

						Toast.makeText(Genetic_History_Class.this,
								"Saved Succesfully !", Toast.LENGTH_SHORT)
								.show();

						Intent i = new Intent(Genetic_History_Class.this,
								Medical_HistoryClass.class);
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
