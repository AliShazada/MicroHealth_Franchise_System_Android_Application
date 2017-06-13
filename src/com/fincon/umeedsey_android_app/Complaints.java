package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Complaints extends Activity {

	public static String rslt = "";

	CheckBox CB_Headache, CB_HBP, CB_SugarLevel, CB_Hunger,
			CB_IncreasedAppitite, CB_MorningSickness, CB_LookPale, CB_Nausea,
			CB_AbdominalPain, CB_SmallerBaby, CB_BabyMovingLess, CB_BackPain,
			CB_BlurredVision, CB_Contraction, CB_Cramping, CB_Dehydration,
			CB_dizeness, CB_ExcessiveVomitting, CB_ExcessiveWeight,
			CB_ExtremeThirst, CB_Fainting, CB_Fatigue, CB_FeelTired,
			CB_FetalMovement, CB_FluidTissuePassing, CB_PelvicPressure,
			CB_ReducedApptitite, CB_Serizure, CB_BreathShortness,
			CB_StomachPain, CB_TooMuchProtein, CB_UtrineTenderness,
			CB_UterineLarger, CB_VaginalBleeding, CB_Weightloss;

	Button Skip, Save;

	int CB_ID_Headache, CB_ID_HBP, CB_ID_SugarLevel, CB_ID_Hunger,
			CB_ID_IncreasedAppitite, CB_ID_MorningSickness, CB_ID_LookPale,
			CB_ID_Nausea, CB_ID_AbdominalPain, CB_ID_SmallerBaby,
			CB_ID_BabyMovingLess, CB_ID_BackPain, CB_ID_BlurredVision,
			CB_ID_Contraction, CB_ID_Cramping, CB_ID_Dehydration,
			CB_ID_dizeness, CB_ID_ExcessiveVomitting, CB_ID_ExcessiveWeight,
			CB_ID_ExtremeThirst, CB_ID_Fainting, CB_ID_Fatigue,
			CB_ID_FeelTired, CB_ID_FetalMovement, CB_ID_FluidTissuePassing,
			CB_ID_PelvicPressure, CB_ID_ReducedApptitite, CB_ID_Serizure,
			CB_ID_BreathShortness, CB_ID_StomachPain, CB_ID_TooMuchProtein,
			CB_ID_UtrineTenderness, CB_ID_UterineLarger, CB_ID_VaginalBleeding,
			CB_ID_Weightloss;

	WeekClass objWeek = new WeekClass();

	int Service_counter = 0;
	int year;
	int month;
	int day;

	String Complaint = "";
	String Current_Date = "";
	String Symptom_Array = "";
	String Concatinated_Symptom_String = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complaints);

		setCurrentDateOnView();

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		Skip = (Button) findViewById(R.id.Skip_complaints);
		Save = (Button) findViewById(R.id.save_complaints);

		CB_Headache = (CheckBox) findViewById(R.id.headache_complaints);
		CB_HBP = (CheckBox) findViewById(R.id.high_BP_complaints);
		CB_SugarLevel = (CheckBox) findViewById(R.id.high_Blood_Sugar_levels_complaints);
		CB_Hunger = (CheckBox) findViewById(R.id.hunger_complaints);
		CB_IncreasedAppitite = (CheckBox) findViewById(R.id.Increased_Appetite_complaints);
		CB_MorningSickness = (CheckBox) findViewById(R.id.Increased_Morning_Sickness_complaints);
		CB_LookPale = (CheckBox) findViewById(R.id.Look_pale_complaints);
		CB_Nausea = (CheckBox) findViewById(R.id.Nausea_complaints);
		CB_AbdominalPain = (CheckBox) findViewById(R.id.Abdominal_pain_complaints);
		CB_SmallerBaby = (CheckBox) findViewById(R.id.Baby_is_smaller_than_normal_complaints);
		CB_BabyMovingLess = (CheckBox) findViewById(R.id.Baby_is_moving_less_than_normal_complaints);
		CB_BackPain = (CheckBox) findViewById(R.id.Back_pain_complaints);
		CB_BlurredVision = (CheckBox) findViewById(R.id.Blurred_Vision_complaints);
		CB_Contraction = (CheckBox) findViewById(R.id.Contractions_complaints);
		CB_Cramping = (CheckBox) findViewById(R.id.Cramping_complaints);
		CB_Dehydration = (CheckBox) findViewById(R.id.Dehydration_complaints);
		CB_dizeness = (CheckBox) findViewById(R.id.Dizziness_complaints);
		CB_ExcessiveVomitting = (CheckBox) findViewById(R.id.Excessive_Vomitting_complaints);
		CB_ExcessiveWeight = (CheckBox) findViewById(R.id.Excessive_weight_gain_complaints);
		CB_ExtremeThirst = (CheckBox) findViewById(R.id.Extreme_thirst_complaints);
		CB_Fainting = (CheckBox) findViewById(R.id.Fainting_complaints);
		CB_Fatigue = (CheckBox) findViewById(R.id.Fatigue_complaints);
		CB_FeelTired = (CheckBox) findViewById(R.id.Feel_tired_complaints);
		CB_FetalMovement = (CheckBox) findViewById(R.id.Fetal_movments_felt_in_Different_complaints);
		CB_FluidTissuePassing = (CheckBox) findViewById(R.id.Fluid_or_Tissue_passing_through_vagina_complaints);
		CB_PelvicPressure = (CheckBox) findViewById(R.id.Pelvic_pressure_complaints);
		CB_ReducedApptitite = (CheckBox) findViewById(R.id.Reduced_Apptitite_complaints);
		CB_Serizure = (CheckBox) findViewById(R.id.Serizures_complaints);
		CB_BreathShortness = (CheckBox) findViewById(R.id.Shortness_of_breath_complaints);
		CB_StomachPain = (CheckBox) findViewById(R.id.Stomach_Pain_complaints);
		CB_TooMuchProtein = (CheckBox) findViewById(R.id.Too_much_Protein_in_urine_complaints);
		CB_UtrineTenderness = (CheckBox) findViewById(R.id.Utirine_tenderness_complaints);
		CB_UterineLarger = (CheckBox) findViewById(R.id.Uterus_is_larger_than_expected_complaints);
		CB_VaginalBleeding = (CheckBox) findViewById(R.id.Vaginal_Bleeding_complaints);
		CB_Weightloss = (CheckBox) findViewById(R.id.Weight_Loss_complaints);

		// // Creating the Complaints // ..........................

		// // Creating the Complaints CLOSED// ..........................

		Skip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(getApplicationContext(), "Skipped !..",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Complaints.this, DashBoard.class);
				startActivity(i);

			}
		});

		Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {

					if (CB_Headache.isChecked()) {

						CB_ID_Headache = 11;

						Concatinated_Symptom_String += CB_Headache.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_Headache = 22;
					}
					if (CB_HBP.isChecked()) {

						CB_ID_HBP = 11;

						Concatinated_Symptom_String += CB_HBP.getText()
								.toString() + ",";

						Service_counter++;
					} else {
						CB_ID_HBP = 22;
					}
					if (CB_SugarLevel.isChecked()) {

						CB_ID_SugarLevel = 11;

						Concatinated_Symptom_String += CB_SugarLevel.getText()
								.toString() + ",";

						Service_counter++;
					} else {

						CB_ID_SugarLevel = 22;
					}

					if (CB_Hunger.isChecked()) {
						CB_ID_Hunger = 11;

						Concatinated_Symptom_String += CB_Hunger.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_Hunger = 22;
					}
					if (CB_IncreasedAppitite.isChecked()) {

						CB_ID_IncreasedAppitite = 11;

						Concatinated_Symptom_String += CB_IncreasedAppitite
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_IncreasedAppitite = 22;

					}
					if (CB_MorningSickness.isChecked()) {
						CB_ID_MorningSickness = 11;

						Concatinated_Symptom_String += CB_MorningSickness
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_MorningSickness = 22;

					}
					if (CB_LookPale.isChecked()) {

						CB_ID_LookPale = 11;

						Concatinated_Symptom_String += CB_LookPale.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_LookPale = 22;
					}
					if (CB_Nausea.isChecked()) {
						CB_ID_Nausea = 11;

						Concatinated_Symptom_String += CB_Nausea.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_Nausea = 22;
					}
					if (CB_AbdominalPain.isChecked()) {
						CB_ID_AbdominalPain = 11;

						Concatinated_Symptom_String += CB_AbdominalPain
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_AbdominalPain = 22;

					}
					if (CB_SmallerBaby.isChecked()) {

						CB_ID_SmallerBaby = 11;

						Concatinated_Symptom_String += CB_SmallerBaby.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_SmallerBaby = 22;
					}
					if (CB_BabyMovingLess.isChecked()) {
						CB_ID_BabyMovingLess = 11;

						Concatinated_Symptom_String += CB_BabyMovingLess
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_BabyMovingLess = 22;

					}
					if (CB_BackPain.isChecked()) {
						CB_ID_BackPain = 11;

						Concatinated_Symptom_String += CB_BackPain.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_BackPain = 22;

					}
					if (CB_BlurredVision.isChecked()) {

						CB_ID_BlurredVision = 11;

						Concatinated_Symptom_String += CB_BlurredVision
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_BlurredVision = 22;

					}
					if (CB_Contraction.isChecked()) {

						CB_ID_Contraction = 11;

						Concatinated_Symptom_String += CB_Contraction.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_Contraction = 22;
					}

					if (CB_Cramping.isChecked()) {

						CB_ID_Cramping = 11;

						Concatinated_Symptom_String += CB_Cramping.getText()
								.toString() + ",";

						Service_counter++;
					} else {
						CB_ID_Cramping = 22;
					}

					if (CB_Dehydration.isChecked()) {

						CB_ID_Dehydration = 11;

						Concatinated_Symptom_String += CB_Dehydration.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_Dehydration = 22;
					}
					if (CB_dizeness.isChecked()) {

						CB_ID_dizeness = 11;

						Concatinated_Symptom_String += CB_dizeness.getText()
								.toString() + ",";

						Service_counter++;
					} else {

						CB_ID_dizeness = 22;
					}
					if (CB_ExcessiveVomitting.isChecked()) {

						CB_ID_ExcessiveVomitting = 11;

						Concatinated_Symptom_String += CB_ExcessiveVomitting
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_ExcessiveVomitting = 22;
					}
					if (CB_ExcessiveWeight.isChecked()) {

						CB_ID_ExcessiveWeight = 11;

						Concatinated_Symptom_String += CB_ExcessiveWeight
								.getText().toString() + ",";

						Service_counter++;
					} else {
						CB_ID_ExcessiveWeight = 22;
					}
					if (CB_ExtremeThirst.isChecked()) {

						CB_ID_ExtremeThirst = 11;

						Concatinated_Symptom_String += CB_ExtremeThirst
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_ExtremeThirst = 22;
					}
					if (CB_Fainting.isChecked()) {

						CB_ID_Fainting = 11;

						Concatinated_Symptom_String += CB_Fainting.getText()
								.toString() + ",";

						Service_counter++;
					} else {
						CB_ID_Fainting = 22;
					}
					if (CB_Fatigue.isChecked()) {

						CB_ID_Fatigue = 11;

						Concatinated_Symptom_String += CB_Fatigue.getText()
								.toString() + ",";

						Service_counter++;
					} else {
						CB_ID_Fatigue = 22;
					}
					if (CB_FeelTired.isChecked()) {

						CB_ID_FeelTired = 11;

						Concatinated_Symptom_String += CB_FeelTired.getText()
								.toString() + ",";

						Service_counter++;

					} else {

						CB_ID_FeelTired = 22;
					}
					if (CB_FetalMovement.isChecked()) {

						CB_ID_FetalMovement = 11;

						Concatinated_Symptom_String += CB_FetalMovement
								.getText().toString() + ",";

						Service_counter++;
					} else {
						CB_ID_FetalMovement = 22;
					}

					if (CB_FluidTissuePassing.isChecked()) {

						CB_ID_FluidTissuePassing = 11;

						Concatinated_Symptom_String += CB_FluidTissuePassing
								.getText().toString() + ",";

						Service_counter++;
					} else {
						CB_ID_FluidTissuePassing = 22;
					}
					if (CB_PelvicPressure.isChecked()) {

						CB_ID_PelvicPressure = 11;

						Concatinated_Symptom_String += CB_PelvicPressure
								.getText().toString() + ",";

						Service_counter++;
					} else {

						CB_ID_PelvicPressure = 22;
					}
					if (CB_ReducedApptitite.isChecked()) {

						CB_ID_ReducedApptitite = 11;

						Concatinated_Symptom_String += CB_ReducedApptitite
								.getText().toString() + ",";

						Service_counter++;
					} else {
						CB_ID_ReducedApptitite = 22;
					}
					if (CB_Serizure.isChecked()) {

						CB_ID_Serizure = 11;

						Concatinated_Symptom_String += CB_Serizure.getText()
								.toString() + ",";

						Service_counter++;
					} else {

						CB_ID_Serizure = 22;
					}
					if (CB_BreathShortness.isChecked()) {

						CB_ID_BreathShortness = 11;

						Concatinated_Symptom_String += CB_BreathShortness
								.getText().toString() + ",";

						Service_counter++;
					} else {

						CB_ID_BreathShortness = 22;
					}
					if (CB_StomachPain.isChecked()) {

						CB_ID_StomachPain = 11;

						Concatinated_Symptom_String += CB_StomachPain.getText()
								.toString() + ",";

						Service_counter++;

					} else {
						CB_ID_StomachPain = 22;
					}
					if (CB_TooMuchProtein.isChecked()) {

						CB_ID_TooMuchProtein = 11;

						Concatinated_Symptom_String += CB_TooMuchProtein
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_TooMuchProtein = 22;
					}
					if (CB_UtrineTenderness.isChecked()) {

						CB_ID_UtrineTenderness = 11;

						Concatinated_Symptom_String += CB_UtrineTenderness
								.getText().toString() + ",";

						Service_counter++;
					} else {

						CB_ID_UtrineTenderness = 22;
					}
					if (CB_UterineLarger.isChecked()) {

						CB_ID_UterineLarger = 11;

						Concatinated_Symptom_String += CB_UterineLarger
								.getText().toString() + ",";

						Service_counter++;
					} else {

						CB_ID_UterineLarger = 22;
					}
					if (CB_VaginalBleeding.isChecked()) {

						CB_ID_VaginalBleeding = 11;

						Concatinated_Symptom_String += CB_VaginalBleeding
								.getText().toString() + ",";

						Service_counter++;

					} else {
						CB_ID_VaginalBleeding = 22;

					}
					if (CB_Weightloss.isChecked()) {

						CB_ID_Weightloss = 11;

						Concatinated_Symptom_String += CB_Weightloss.getText()
								.toString() + ",";

						Service_counter++;

					} else {

						CB_ID_Weightloss = 22;

					}

					if (CB_ID_LookPale == 11 && CB_ID_FeelTired == 11

					&& CB_ID_BreathShortness == 11) {

						Symptom_Array = CB_LookPale.getText().toString() + ","
								+ CB_FeelTired.getText().toString() + ","
								+ CB_BreathShortness.getText().toString();

						Complaint += "Anemia" + "@"
								+ CB_LookPale.getText().toString() + ","
								+ CB_FeelTired.getText().toString() + ","
								+ CB_BreathShortness.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

					}

					if (CB_ID_HBP == 11 && CB_ID_Serizure == 11) {

						Complaint += "Eclampsia" + "@"
								+ CB_HBP.getText().toString() + ","
								+ CB_Serizure.getText().toString() + "420";

						Symptom_Array = CB_HBP.getText().toString() + ","
								+ CB_Serizure.getText().toString();

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

					}

					if (CB_ID_SmallerBaby == 11 && CB_ID_BabyMovingLess == 11) {

						Complaint += "Fetal Problems" + "@"
								+ CB_SmallerBaby.getText().toString() + ","
								+ CB_BabyMovingLess.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Symptom_Array = CB_SmallerBaby.getText().toString()
								+ "," + CB_BabyMovingLess.getText().toString();

					}

					if (CB_ID_SugarLevel == 11 && CB_ID_Hunger == 11
							&& CB_ID_ExtremeThirst == 11 && CB_ID_Fatigue == 11) {

						Complaint += "Gestational Diabetes" + "@"
								+ CB_Hunger.getText().toString() + ","
								+ CB_SugarLevel.getText().toString() + ","
								+ CB_ExtremeThirst.getText().toString() + ","
								+ CB_Fatigue.getText().toString() + "420";

						Symptom_Array = CB_Hunger.getText().toString() + ","
								+ CB_SugarLevel.getText().toString() + ","
								+ CB_ExtremeThirst.getText().toString() + ","
								+ CB_Fatigue.getText().toString();

					}

					if (CB_ID_Nausea == 11 && CB_ID_Dehydration == 11
							&& CB_ID_ExcessiveVomitting == 11
							&& CB_ID_Fainting == 11
							&& CB_ID_ReducedApptitite == 11
							&& CB_ID_Weightloss == 11) {

						Complaint += "Hyperemesis Gravidarium (HG)" + "@"
								+ CB_Nausea.getText().toString() + ","
								+ CB_Dehydration.getText().toString() + ","
								+ CB_ExcessiveVomitting.getText().toString()
								+ "," + CB_Fainting.getText().toString() + ","
								+ CB_ReducedApptitite.getText().toString()
								+ "," + CB_Weightloss.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Symptom_Array = CB_Nausea.getText().toString() + ","
								+ CB_Dehydration.getText().toString() + ","
								+ CB_ExcessiveVomitting.getText().toString()
								+ "," + CB_Fainting.getText().toString() + ","
								+ CB_ReducedApptitite.getText().toString()
								+ "," + CB_Weightloss.getText().toString();

					}
					if (CB_ID_AbdominalPain == 11

					&& CB_ID_Cramping == 11 && CB_ID_FluidTissuePassing == 11

					&& CB_ID_VaginalBleeding == 11) {

						Complaint += "Miscarriage" + "@"
								+ CB_Cramping.getText().toString() + ","
								+ CB_VaginalBleeding.getText().toString() + ","
								+ CB_AbdominalPain.getText().toString() + ","
								+ CB_FluidTissuePassing.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Symptom_Array = CB_Cramping.getText().toString() + ","
								+ CB_VaginalBleeding.getText().toString() + ","
								+ CB_AbdominalPain.getText().toString() + ","
								+ CB_FluidTissuePassing.getText().toString();

					}

					if (CB_ID_IncreasedAppitite == 11
							&& CB_ID_MorningSickness == 11
							&& CB_ID_ExcessiveWeight == 11
							&& CB_ID_FetalMovement == 11
							&& CB_ID_UterineLarger == 11) {

						Complaint += "Multiple Pregnency" + "@"
								+ CB_UterineLarger.getText().toString() + ","
								+ CB_FetalMovement.getText().toString() + ","
								+ CB_ExcessiveWeight.getText().toString() + ","
								+ CB_IncreasedAppitite.getText().toString()
								+ "," + CB_MorningSickness.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Symptom_Array = CB_UterineLarger.getText().toString()
								+ "," + CB_FetalMovement.getText().toString()
								+ "," + CB_ExcessiveWeight.getText().toString()
								+ ","
								+ CB_IncreasedAppitite.getText().toString()
								+ "," + CB_MorningSickness.getText().toString();

					}

					if (CB_ID_BackPain == 11 && CB_ID_Contraction == 11
							&& CB_ID_Cramping == 11
							&& CB_ID_FluidTissuePassing == 11
							&& CB_ID_PelvicPressure == 11) {

						Complaint += "Preterm Labour" + "@"
								+ CB_Cramping.getText().toString() + ","
								+ CB_Contraction.getText().toString() + ","
								+ CB_BackPain.getText().toString() + ","
								+ CB_FluidTissuePassing.getText().toString()
								+ "," + CB_PelvicPressure.getText().toString()
								+ "420";

						Toast.makeText(getApplicationContext(),
								"Complaint : " + Complaint, Toast.LENGTH_SHORT)
								.show();

						Symptom_Array = CB_Cramping.getText().toString() + ","
								+ CB_Contraction.getText().toString() + ","
								+ CB_BackPain.getText().toString() + ","
								+ CB_FluidTissuePassing.getText().toString()
								+ "," + CB_PelvicPressure.getText().toString();

					}

					if (Complaint.equals("")) {

						Toast.makeText(getApplicationContext(),
								"No Complaint ", Toast.LENGTH_SHORT).show();

					} else {

						String[] MAINTOKEN = Complaint.split("420");

						for (int i = 0; i < MAINTOKEN.length; i++) {

							System.out.println(MAINTOKEN[i]);

							String[] SubToken = MAINTOKEN[i].split("@");

							// System.out.println(SubToken[0]);

							// System.out.println(SubToken[1]);

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "InsertPregnancyComplaints";
								c.arg1a = "PregnancyComplaints";

								c.arg1_value = IDs_Class
										.getCurrentPregnancyCase_ID()
										+ "@"
										+ Current_Date
										+ "@"
										+ "abc"
										+ "@"
										+ "0"
										+ "@"
										+ String.valueOf(objWeek
												.WeekCalculator(Current_Date,
														IDs_Class.getLMP()))
										+ "@"
										+ SubToken[0]
										+ "@"
										+ SubToken[1]
										+ "@"
										+ SessionClass.getUser_id()
										+ "@"
										+ "1";

								c.selection = 1117;

								c.ad = ad;
								c.join();
								c.start();
								while (rslt == "START") {
									try {
										Thread.sleep(10);
									} catch (Exception ex) {
									}
								}

								Toast.makeText(getApplicationContext(),
										"Response : " + rslt,
										Toast.LENGTH_SHORT).show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}
						}

					}

					if (Concatinated_Symptom_String.equals("")) {

						Toast.makeText(getApplicationContext(), "No Symptom ",
								Toast.LENGTH_SHORT).show();

					} else

					{

						Toast.makeText(getApplicationContext(),
								"Symptom :  " + Symptom_Array,
								Toast.LENGTH_SHORT).show();

						String[] TOKEN = Concatinated_Symptom_String.split(",");

						for (int i = 0; i < TOKEN.length; i++) {

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "InsertPregnancyComplaints";
								c.arg1a = "PregnancyComplaints";

								c.arg1_value = IDs_Class
										.getCurrentPregnancyCase_ID()
										+ "@"
										+ Current_Date
										+ "@"
										+ "abc"
										+ "@"
										+ "0"
										+ "@"
										+ String.valueOf(objWeek
												.WeekCalculator(Current_Date,
														IDs_Class.getLMP()))
										+ "@"
										+ ""
										+ "@"
										+ TOKEN[i]
										+ "@"
										+ SessionClass.getUser_id() + "@" + "2";

								c.selection = 1117;

								c.ad = ad;
								c.join();
								c.start();
								while (rslt == "START") {
									try {
										Thread.sleep(10);
									} catch (Exception ex) {
									}
								}

								Toast.makeText(getApplicationContext(),
										"Response : " + rslt,
										Toast.LENGTH_SHORT).show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

						}
					}

					if (objWeek.WeekCalculator(Current_Date, IDs_Class.getLMP()) < 10) {

						DashBoardSession.setComplaints(11);

						Intent i = new Intent(Complaints.this, DashBoard.class);
						startActivity(i);
					}

					else {

						DashBoardSession.setComplaints(11);
						Intent i = new Intent(Complaints.this,
								Antenatal_Class.class);
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

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview

		Current_Date = (new StringBuilder()
		// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year)).toString();

	}
}
