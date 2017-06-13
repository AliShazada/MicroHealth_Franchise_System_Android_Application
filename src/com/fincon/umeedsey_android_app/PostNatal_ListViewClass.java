package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Calendar;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PostNatal_ListViewClass extends Activity {

	public static String rslt = "";

	int year;
	int month;
	int day;

	String Current_Date;

	RelativeLayout relative_list;

	Button BTN_Button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnatal_listmain);

		setCurrentDateOnView();

		final ListView lv1 = (ListView) findViewById(R.id.ListView_postnatal);

		if (IDs_Class.getPrenatalListStatus().equals("Normal")) {
			lv1.setBackgroundColor(Color.parseColor("#006000"));
		} else if (IDs_Class.getPrenatalListStatus().equals("Complicated")) {
			lv1.setBackgroundColor(Color.parseColor("#FFA500"));
		} else if (IDs_Class.getPrenatalListStatus().equals("Emergency")) {
			lv1.setBackgroundColor(Color.parseColor("#FF0000"));
		}

		BTN_Button = (Button) findViewById(R.id.button_back_postnatalmain);

		BTN_Button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(PostNatal_ListViewClass.this,
						PostnatalListClass.class);
				startActivity(i);

			}
		});

		ConnectionDetector cd = new ConnectionDetector(getApplicationContext());

		Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																	// or
																	// false

		if (isInternetPresent == true) {

			try {
				rslt = "START";
				Caller3 c = new Caller3();

				c.Method_Name = "PostnatalPopulateListBox";
				c.arg1a = "cmwID";
				c.arg2a = "currentDate";
				c.arg3a = "Status";

				c.arg1_value = SessionClass.getCMW_id();
				c.arg2_value = Current_Date;
				c.arg3_value = IDs_Class.getPrenatalListStatus();

				c.selection = 339;
				c.join();
				c.start();
				while (rslt == "START") {
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}

			} catch (Exception ex) {

				Toast.makeText(PostNatal_ListViewClass.this,
						"Exception : " + ex.toString(),

						Toast.LENGTH_SHORT).show();

			}

			// Toast.makeText(PostNatal_ListViewClass.this,
			// "Server Response " + rslt, Toast.LENGTH_SHORT).show();

			if (rslt.indexOf("anyType") != -1) {
				Toast.makeText(PostNatal_ListViewClass.this,
						"No Records Available ", Toast.LENGTH_SHORT).show();
			} else {

				ArrayList<SearchResults_Postnatal> searchResults = GetSearchResults1();

				lv1.setAdapter(new PostNatal_BaseAdapterClass(this,
						searchResults));

				lv1.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> a, View v,
							int position, long id) {
						Object o = lv1.getItemAtPosition(position);
						SearchResults_Postnatal fullObject = (SearchResults_Postnatal) o;
						Toast.makeText(
								PostNatal_ListViewClass.this,
								"You have chosen: " + " "
										+ fullObject.getName_postnatal(),
								Toast.LENGTH_LONG).show();

						IDs_Class.setPostnatal_list_PersonID(fullObject
								.getPersonID_postnatal());
						IDs_Class.setPostnatal_list_PregID(fullObject
								.getPregnency_ID_postnatal());
						IDs_Class.setPostnatal_list_PatientID(fullObject
								.getPatient_ID_postnatal());

						String[] TOKEN_WEEKS = fullObject.getWeekNo_postnatal()
								.split(" ");

						IDs_Class.setGestationWeek(TOKEN_WEEKS[2]);

						// if
						// (fullObject.getDelivery_postnatal().equals("True")) {
						//
						// Intent i = new Intent(PostNatal_ListViewClass.this,
						// Physical_Examination_of_Mother.class);
						// startActivity(i);
						//
						// }
						//
						// else {
						//
						// Intent i = new Intent(PostNatal_ListViewClass.this,
						// PostnatalAlerts.class);
						// startActivity(i);
						//
						// }

						Intent i = new Intent(PostNatal_ListViewClass.this,
								Postnatal_Alerts_GenerationClass .class);
						startActivity(i);

					}
				});
			}
		} else {
			Toast.makeText(PostNatal_ListViewClass.this,
					"Internet is not available  ",

					Toast.LENGTH_SHORT).show();
		}
	}

	private ArrayList<SearchResults_Postnatal> GetSearchResults1() {
		ArrayList<SearchResults_Postnatal> results = new ArrayList<SearchResults_Postnatal>();

		SearchResults_Postnatal sr1;// = new SearchResults_Postnatal();

		Toast.makeText(PostNatal_ListViewClass.this,
				"CMW ID : " + SessionClass.getCMW_id(),

				Toast.LENGTH_SHORT).show();

		String[] MainString = rslt.split("%");

		for (int i = 0; i < MainString.length; i++) {

			String[] SubString = MainString[i].split("@");

			// Toast.makeText(PostNatal_ListViewClass.this,
			// "Main String : " + MainString[i], Toast.LENGTH_SHORT)
			// .show();

			sr1 = new SearchResults_Postnatal();

			for (int j = 0; j < SubString.length; j++) {

				if (j == 0) {

					sr1.setPersonID_postnatal(SubString[j]);

				} else if (j == 1) {
					sr1.setPregnency_ID_postnatal(SubString[j]);

				} else if (j == 2) {

					sr1.setPatient_ID_postnatal(SubString[j]);

				} else if (j == 3) {

					sr1.setName_postnatal(SubString[j]);

					IDs_Class.setTemp_PatientName(SubString[j]);

				} else if (j == 4) {

					sr1.setGardianname_postnatal(SubString[j]);

				} else if (j == 5) {

					sr1.setLMP_postnatal(SubString[j]);

				} else if (j == 6) {

					sr1.setEDD_postnatal(SubString[j]);

				} else if (j == 7) {

					sr1.setWeekNo_postnatal(SubString[j]);

				} else if (j == 8) {

					sr1.setMrNumber_postnatal(SubString[j]);

				} else if (j == 9) {

					sr1.setDelivery_postnatal(SubString[j]);

				}
				//
				// else if (j == 10) {
				//
				//
				//
				// }

			}
			results.add(sr1);

		}

		return results;
	}

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

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