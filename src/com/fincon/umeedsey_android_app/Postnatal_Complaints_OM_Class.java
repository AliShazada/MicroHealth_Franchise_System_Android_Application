package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Postnatal_Complaints_OM_Class extends Activity {

	public static String rslt = "";

	Spinner Sp_fever, SP_body_ache, SP_excessive_fatigue,
			SP_Difficulty_in_breathing, Sp_swelling_hand, SP_Dysuria_Frequency,
			SP_urinary_incontinence, Sp_lower_Abdomin_pain,
			SP_Heavy_vaginal_bleeding, SP_breast_engorgement;

	Button BTN_Save, BTN_Back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnatal_complaints_of_mother);

		Sp_fever = (Spinner) findViewById(R.id.spinner2_fever);
		SP_body_ache = (Spinner) findViewById(R.id.spinner2_body_ache_pcom);
		SP_excessive_fatigue = (Spinner) findViewById(R.id.spinner2_excessive_fatigue_pcom);
		SP_Difficulty_in_breathing = (Spinner) findViewById(R.id.spinner2_difficulty_in_breathing_pcom);
		Sp_swelling_hand = (Spinner) findViewById(R.id.spinner2_swelling_hand_face_feet);
		SP_Dysuria_Frequency = (Spinner) findViewById(R.id.spinner2_dysuria_Frequency);
		SP_urinary_incontinence = (Spinner) findViewById(R.id.spinner2_urinary_incontinence);
		Sp_lower_Abdomin_pain = (Spinner) findViewById(R.id.spinner2_lower_Abdomin_pain);
		SP_Heavy_vaginal_bleeding = (Spinner) findViewById(R.id.spinner2_heavy_vaginal_bleeding);
		SP_breast_engorgement = (Spinner) findViewById(R.id.spinner2_breast_engorgement);

		BTN_Back = (Button) findViewById(R.id.button_back_pcom);
		BTN_Save = (Button) findViewById(R.id.button_save_pcom);

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (Sp_fever.getSelectedItem().toString().equals("No Answer")
						|| SP_body_ache.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_excessive_fatigue.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_Difficulty_in_breathing.getSelectedItem()
								.toString().equals("No Answer")
						|| Sp_swelling_hand.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_Dysuria_Frequency.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_urinary_incontinence.getSelectedItem().toString()
								.equals("No Answer")
						|| Sp_lower_Abdomin_pain.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_Heavy_vaginal_bleeding.getSelectedItem()
								.toString().equals("No Answer")
						|| SP_breast_engorgement.getSelectedItem().toString()
								.equals("No Answer")) {
					
					Toast.makeText(Postnatal_Complaints_OM_Class.this,
							"Select the value of all Drop Downs.. !" + rslt, Toast.LENGTH_SHORT)
							.show();

				}

				else {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertPostnataVists";
						c.arg1a = "postnatalVists";

						c.arg1_value = IDs_Class.getPostnatal_list_PregID() + "@" + IDs_Class.getPostnatal_list_PersonID() + "@"
								+ SessionClass.getUser_id();

						c.selection = 1114;
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

					Toast.makeText(Postnatal_Complaints_OM_Class.this,
							"InsertPostnataVists" + rslt, Toast.LENGTH_SHORT)
							.show();
					IDs_Class.setPostNatalID(rslt);

					String TempContate = IDs_Class.getPostNatalID()
							+ "@"
							+ "39"
							+ "@"
							+ Sp_fever.getSelectedItem().toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "40"
							+ "@"
							+ SP_body_ache.getSelectedItem().toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "41"
							+ "@"
							+ SP_excessive_fatigue.getSelectedItem().toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "42"
							+ "@"
							+ SP_Difficulty_in_breathing.getSelectedItem()
									.toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "43"
							+ "@"
							+ Sp_swelling_hand.getSelectedItem().toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "48"
							+ "@"
							+ SP_Dysuria_Frequency.getSelectedItem().toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "49"
							+ "@"
							+ SP_urinary_incontinence.getSelectedItem()
									.toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "50"
							+ "@"
							+ Sp_lower_Abdomin_pain.getSelectedItem()
									.toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "51"
							+ "@"
							+ SP_Heavy_vaginal_bleeding.getSelectedItem()
									.toString()
							+ "|"
							+ IDs_Class.getPostNatalID()
							+ "@"
							+ "52"
							+ "@"
							+ SP_breast_engorgement.getSelectedItem()
									.toString();

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertMotherComplaints";
						c.arg1a = "MotherComplaints";

						c.arg1_value = TempContate;

						c.selection = 1115;
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

//					Toast.makeText(Postnatal_Complaints_OM_Class.this,
//							"InsertMotheb  rComplaints : " + rslt,
//							Toast.LENGTH_SHORT).show();

					Toast.makeText(Postnatal_Complaints_OM_Class.this,
							"Saved Successfully : " + rslt, Toast.LENGTH_SHORT)
							.show();

					Intent i = new Intent(Postnatal_Complaints_OM_Class.this,
							PostNatal_ListViewClass .class);
					

					startActivity(i);
				}

			}
		});

	}
	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
