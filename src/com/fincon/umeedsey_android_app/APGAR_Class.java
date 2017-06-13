package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class APGAR_Class extends Activity {

	public static String rslt = "";

	Spinner Sp_HeartRate, Sp_Breathing, SP_MuscleTone,
			Sp_Response_to_Stimulation, SP_ColorOfBaby;
	Button BTN_Save;

	int year;
	int month;
	int day;

	String HeartRate_Value, Breathing_Value, MuscleTone_Value,
			Response_to_Stimulation_Value, BabyColor_Value;
	String Current_Date = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apgar);
		setCurrentDateOnView();

		Sp_HeartRate = (Spinner) findViewById(R.id.spinner2_heartrate_apgar);
		Sp_Breathing = (Spinner) findViewById(R.id.spinner2_breathing_apgar);
		SP_MuscleTone = (Spinner) findViewById(R.id.spinner2_MuscleTone_apgar);
		Sp_Response_to_Stimulation = (Spinner) findViewById(R.id.spinner2_Grimacing_apgar);
		SP_ColorOfBaby = (Spinner) findViewById(R.id.spinner2_color_of_baby_apgar);

		BTN_Save = (Button) findViewById(R.id.button_save_apsar);

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (Sp_HeartRate.getSelectedItem().toString()
						.equals("Select Heart Rate")
						|| Sp_Breathing.getSelectedItem().toString()
								.equals("Select Breathing")
						|| SP_MuscleTone.getSelectedItem().toString()
								.equals("Select Muscle Tone")
						|| Sp_Response_to_Stimulation.getSelectedItem()
								.toString()
								.equals("Select Responce to Stimulation")
						|| SP_ColorOfBaby.getSelectedItem().toString()
								.equals("Select Baby Color")) {

					Toast.makeText(APGAR_Class.this,
							"All the DropDowns are not selected !",
							Toast.LENGTH_SHORT).show();

				} else {

					if (Sp_HeartRate.getSelectedItem().toString().equals("No")) {
						HeartRate_Value = "1";
					} else if (Sp_HeartRate.getSelectedItem().toString()
							.equals("Less than 100")) {
						HeartRate_Value = "2";
					} else if (Sp_HeartRate.getSelectedItem().toString()
							.equals("Greater than 100")) {
						HeartRate_Value = "3";
					}

					if (Sp_Breathing.getSelectedItem().toString().equals("No")) {
						Breathing_Value = "4";
					} else if (Sp_Breathing.getSelectedItem().toString()
							.equals("Slow and Irregular")) {
						Breathing_Value = IDs_Class.getPostnatal_list_PersonID();
					} else if (Sp_Breathing.getSelectedItem().toString()
							.equals("Good and Crying well")) {
						Breathing_Value = "6";
					}

					if (SP_MuscleTone.getSelectedItem().toString().equals("No")) {
						MuscleTone_Value = "7";
					} else if (SP_MuscleTone.getSelectedItem().toString()
							.equals("Weak")) {
						MuscleTone_Value = "8";
					} else if (SP_MuscleTone.getSelectedItem().toString()
							.equals("Active")) {
						MuscleTone_Value = "9";
					}

					if (Sp_Response_to_Stimulation.getSelectedItem().toString()
							.equals("No")) {
						Response_to_Stimulation_Value = IDs_Class.getPostnatal_list_PersonID();
					} else if (Sp_Response_to_Stimulation.getSelectedItem()
							.toString().equals("Less Response")) {
						Response_to_Stimulation_Value = "11";
					} else if (Sp_Response_to_Stimulation.getSelectedItem()
							.toString().equals("Coughing/Sneezing")) {
						Response_to_Stimulation_Value = "12";
					}

					if (SP_ColorOfBaby.getSelectedItem().toString()
							.equals("Blue")) {
						BabyColor_Value = "13";
					} else if (SP_ColorOfBaby.getSelectedItem().toString()
							.equals("Body pink-Hand and feet blue")) {
						BabyColor_Value = "14";
					} else if (SP_ColorOfBaby.getSelectedItem().toString()
							.equals("Pink")) {
						BabyColor_Value = "15";
					}

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertApgarScore";
						c.arg1a = "WP7CAPGHARBaby";

						c.arg1_value = IDs_Class.getPostnatal_list_PersonID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@" + HeartRate_Value
								+ "@" + Current_Date + "@"
								+ SessionClass.getUser_id() + "@" + "" + "@"
								+ "" + "@" + "False" + "@" + "Satti" + "@"
								+ "1" + "|" + IDs_Class.getPostnatal_list_PersonID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@"
								+ Breathing_Value + "@" + Current_Date + "@"
								+ SessionClass.getUser_id() + "@" + "" + "@"
								+ "" + "@" + "False" + "@" + "Satti" + "@"
								+ "1" + "|" + IDs_Class.getPostnatal_list_PersonID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@"
								+ MuscleTone_Value + "@" + Current_Date + "@"
								+ SessionClass.getUser_id() + "@" + "" + "@"
								+ "" + "@" + "False" + "@" + "Satti" + "@"
								+ "1" + "|" + IDs_Class.getPostnatal_list_PersonID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@"
								+ Response_to_Stimulation_Value + "@"
								+ Current_Date + "@"
								+ SessionClass.getUser_id() + "@" + "" + "@"
								+ "" + "@" + "False" + "@" + "Satti" + "@"
								+ "1" + "|" + IDs_Class.getPostnatal_list_PersonID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@"
								+ BabyColor_Value + "@" + Current_Date + "@"
								+ SessionClass.getUser_id() + "@" + "" + "@"
								+ "" + "@" + "False" + "@" + "Satti" + "@"
								+ "1";

						c.selection = 1111;
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

					Toast.makeText(APGAR_Class.this, "Server Response" + rslt,
							Toast.LENGTH_SHORT).show();

					Toast.makeText(APGAR_Class.this, "Saved Successfully",
							Toast.LENGTH_SHORT).show();

					Intent i = new Intent(APGAR_Class.this,
							QuestionsClass.class);
					startActivity(i);
				}

			}
		});

	}

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		Current_Date = (new StringBuilder()
		// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year)).toString();

	}
	
	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
