package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Allergies_Class extends Activity {

	public static String rslt = "";

	Spinner SP_DrugName;
	EditText ReactionType, Details;
	Button Save, Skip;
	int validator = 22;

	List<String> List_Drugs = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allergies);

		final AlertDialog ad = new AlertDialog.Builder(this).create();
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);

		SP_DrugName = (Spinner) findViewById(R.id.spinner_drug_name);
		Save = (Button) findViewById(R.id.save_allergies);
		Skip = (Button) findViewById(R.id.Skip_allergies);
		ReactionType = (EditText) findViewById(R.id.Reaction_type_allergies);
		Details = (EditText) findViewById(R.id.details_allergies);

		// // Code to Populate The Drop Down List of Drug Name.............
		try {

			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "selectDrug";
			c.selection = 18;
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

		List_Drugs.add("Select the Drug");
		String[] ServerResponse = rslt.split(",");
		for (int i = 0; i < ServerResponse.length; i++) {

			List_Drugs.add(ServerResponse[i]);
		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, List_Drugs);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SP_DrugName.setAdapter(dataAdapter);

		// // (Closed)Code to Populate The Drop Down List of
		// Drug Name.............

		Skip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(getApplicationContext(), "Skipped !.. ",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Allergies_Class.this, DashBoard.class);
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

					validator = 22;

					if (SP_DrugName.getSelectedItem().toString()
							.equals("Select the Drug")) {

						Toast.makeText(getApplicationContext(),
								"Select The Drug Name ", Toast.LENGTH_SHORT)
								.show();

						validator = 11;

					}
					if (ReactionType.getText().toString().length() <= 0) {

						Toast.makeText(getApplicationContext(),
								"Fill the Reaction Type !.. ",
								Toast.LENGTH_SHORT).show();

						validator = 11;

					}

					if (validator == 22) {

						try {

							rslt = "START";
							Caller3 c = new Caller3();

							c.Method_Name = "InsertAllergies";
							c.arg1a = "Allergies";

							c.arg1_value = IDs_Class
									.getCurrentPregnancyCase_ID()
									+ "@"
									+ IDs_Class.getPatient_ID()
									+ "@"
									+ SP_DrugName.getSelectedItem().toString()
									+ "@"
									+ "aa"
									+ "@"
									+ ReactionType.getText().toString()
									+ "@"
									+ SessionClass.getUser_id();

							// c.arg1_value="2@2@Cap. Fefol vit@aa@aa@E85279FF-014B-49D8-AFF7-72844EA23AAE";

							c.selection = 17;

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

						Toast.makeText(getApplicationContext(),
								"Saved Successfully !", Toast.LENGTH_SHORT)
								.show();

						builder.setMessage("Do you want to add more Allergies ?");

						builder.setPositiveButton("YES",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {

										// Code that is executed when clicking
										// YES

										dialog.dismiss();

										Intent i = new Intent(
												Allergies_Class.this,
												Allergies_Class.class);
										startActivity(i);
									}

								});

						builder.setNegativeButton("NO",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {

										// Code that is executed when clicking
										// NO

										dialog.dismiss();

										if (IDs_Class.getAllergies_check() == 11) {
											IDs_Class.setAllergies_check(0);

										//	DashBoardSession.setAllergies(11);

											Intent i = new Intent(
													Allergies_Class.this,
													DashBoard.class);
											startActivity(i);
										} else {
											
										//	DashBoardSession.setAllergies(11);

											Intent i = new Intent(
													Allergies_Class.this,
													Complaints.class);
											startActivity(i);
										}
									}

								});

						AlertDialog alert = builder.create();
						alert.show();

					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Internet is not available", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
