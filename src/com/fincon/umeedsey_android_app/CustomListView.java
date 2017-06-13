package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Calendar;

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

public class CustomListView extends Activity {

	public static String rslt = "";

	int year;
	int month;
	int day;
	Button BTN_Back;
	String Current_Date;

	ConversionClass objConvert = new ConversionClass();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setCurrentDateOnView();

		final ListView lv1 = (ListView) findViewById(R.id.ListView01);

		if (IDs_Class.getPrenatalListStatus().equals("Normal")) {
			lv1.setBackgroundColor(Color.parseColor("#006000"));
		} else if (IDs_Class.getPrenatalListStatus().equals("Complicated")) {
			lv1.setBackgroundColor(Color.parseColor("#FFA500"));
		} else if (IDs_Class.getPrenatalListStatus().equals("Emergency")) {
			lv1.setBackgroundColor(Color.parseColor("#FF0000"));
		}

		BTN_Back = (Button) findViewById(R.id.button_mainlistPre_back);

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(CustomListView.this,
						PrenatalListClass.class);
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

				c.Method_Name = "PopulateListBox";
				c.arg1a = "cmwID";
				c.arg2a = "currentDate";
				c.arg3a = "Status";

				c.arg1_value = SessionClass.getCMW_id();
				c.arg2_value = Current_Date;
				c.arg3_value = IDs_Class.getPrenatalListStatus();

				c.selection = 338;
				c.join();
				c.start();
				while (rslt == "START") {
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}

			} catch (Exception ex) {

				Toast.makeText(CustomListView.this,
						"Exception : " + ex.toString(),

						Toast.LENGTH_SHORT).show();

			}

			// Toast.makeText(CustomListView.this, "Server Response " + rslt,
			// Toast.LENGTH_SHORT).show();

			if (rslt.indexOf("anyType") != -1) {
				Toast.makeText(CustomListView.this, "No Records Available ",
						Toast.LENGTH_SHORT).show();
			} else {

				ArrayList<SearchResults> searchResults = GetSearchResults();
				// relative_list.setBackgroundColor(Color.BLUE);

				lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));

				lv1.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> a, View v,
							int position, long id) {
						Object o = lv1.getItemAtPosition(position);
						SearchResults fullObject = (SearchResults) o;
						Toast.makeText(CustomListView.this,
								fullObject.getName(), Toast.LENGTH_LONG).show();
						// Toast.makeText(CustomListView.this,
						// "Person ID: " + " " + fullObject.getPersonID(),
						// Toast.LENGTH_LONG).show();
						// Toast.makeText(
						// CustomListView.this,
						// "Pregnency Case ID : " + " "
						// + fullObject.getPregnency_ID(),
						// Toast.LENGTH_LONG).show();
						//
						// Toast.makeText(
						// CustomListView.this,
						// "Patient ID: " + " "
						// + fullObject.getPatient_ID(),
						// Toast.LENGTH_LONG).show();

						IDs_Class.setCurrentPregnancyCase_ID(fullObject
								.getPregnency_ID());

						IDs_Class.setPatient_ID(fullObject.getPersonID());

						IDs_Class.setAM_Patient_ID(fullObject.getPatient_ID());

						// ////////////////.................

						String[] TOKEN_PName = fullObject.getName().split(":");

						IDs_Class.setPatientName(TOKEN_PName[1]);

						// ////////////////.................

						// Toast.makeText(
						// CustomListView.this,
						// "LMP"
						// + "  : " + objConvert.DateFormator(fullObject
						// .getLMP()),
						// Toast.LENGTH_LONG).show();

						IDs_Class.setLMP(objConvert.DateFormator(fullObject
								.getLMP()));

						// ////////////////.................

						IDs_Class.setEDD(objConvert.DateFormator(fullObject
								.getEDD()));

						// ////////////////.................

						String[] TOKEN_WEEKS = fullObject.getWeekNo()
								.split(" ");

						IDs_Class.setGestationWeek(TOKEN_WEEKS[4]);

						//
						// // /////////////////.................

						String[] TOKEN_MR = fullObject.getMrNumber().split(" ");

						IDs_Class.setMRNumber(TOKEN_MR[2]);
						//
						// // /////////////////.................

						// Intent i = new Intent(CustomListView.this,
						// DashBoard.class);
						// startActivity(i);

						Intent i = new Intent(CustomListView.this,
								PrenatalAlertgenerationClass.class);
						startActivity(i);

					}
				});

			}
		}

		else {

			Toast.makeText(getApplicationContext(),
					"Internet is not available", Toast.LENGTH_SHORT).show();

		}
	}

	private ArrayList<SearchResults> GetSearchResults() {
		ArrayList<SearchResults> results = new ArrayList<SearchResults>();

		SearchResults sr1;// = new SearchResults();

		String[] MainString = rslt.split("%");

		for (int i = 0; i < MainString.length; i++) {

			String[] SubString = MainString[i].split("@");
			sr1 = new SearchResults();

			// Toast.makeText(CustomListView.this, MainString[i],
			// Toast.LENGTH_LONG).show();

			for (int j = 0; j < SubString.length; j++) {

				if (j == 0) {

					sr1.setPersonID(SubString[j]);

				} else if (j == 1) {
					sr1.setPregnency_ID(SubString[j]);

				} else if (j == 2) {

					sr1.setPatient_ID(SubString[j]);

				} else if (j == 3) {

					sr1.setName(SubString[j]);

				} else if (j == 4) {

					sr1.setGardianName(SubString[j]);

				} else if (j == 5) {

					sr1.setLMP(SubString[j]);

				} else if (j == 6) {

					sr1.setEDD(SubString[j]);

				} else if (j == 7) {

					sr1.setWeekNo(SubString[j]);

				} else if (j == 8) {

					sr1.setMrNumber(SubString[j]);

				}

			}
			// Toast.makeText(
			// CustomListView.this,
			// "1 : " + SubString[0] + "2 : " + SubString[1] + "3 : "
			// + SubString[2] + "4 : " + SubString[3] + "5 : "
			// + SubString[4] + "6 : " + SubString[5] + "7 : "
			// + SubString[6] + "8 : " + SubString[7] + "9 : "
			// + SubString[8], Toast.LENGTH_LONG).show();
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