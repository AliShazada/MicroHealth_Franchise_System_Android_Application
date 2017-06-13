package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Postnatal_Alerts_GenerationClass extends Activity {

	public static String rslt = "";

	String MainString = null;

	String EComplaints = ""; // //////////
	String CComplaints = ""; // /////////

	String EPostPhysicalExamination = ""; // ////////
	String CPostPhysicalExamination = ""; // ////////

	String EDeliveryAlert = ""; // //////////
	String CDeliveryAlert = ""; // ///////////

	List<String> Emergency = new ArrayList<String>();

	List<String> complicated = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnatal_alert_generation);

		// //////////////////////................................
		try {

			rslt = "START";

			Caller3 c = new Caller3();

			c.Method_Name = "SelectPostnatalCDSSStatusForAndroid";
			c.arg1a = "PatID";

			c.arg1_value = IDs_Class.getPostnatal_list_PatientID();

			c.selection = 772;
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

		Toast.makeText(Postnatal_Alerts_GenerationClass.this,
				"ServerReponse: " + rslt, Toast.LENGTH_SHORT).show();

		// //////////////////////....................................................

		MainString = rslt;

		String[] TokenizedString = MainString.split("~");

		EComplaints = TokenizedString[0];

		if (EComplaints.equals("")) {

		} else {
			String[] split = EComplaints.split(",");

			Emergency.add("~! Complaints");

			for (int i = 0; i < split.length; i++) {
				Emergency.add(split[i]);
			}
		}

		EPostPhysicalExamination = TokenizedString[2];

		if (EPostPhysicalExamination.equals("")) {

		} else {
			String[] split = EPostPhysicalExamination.split(",");

			Emergency.add("~!Physical Examination");

			for (int i = 0; i < split.length; i++) {
				Emergency.add(split[i]);
			}
		}

		EDeliveryAlert = TokenizedString[4];

		if (EDeliveryAlert.equals("")) {
			String[] split = EDeliveryAlert.split(",");

			Emergency.add("~!Delivery Alert");

			for (int i = 0; i < split.length; i++) {
				Emergency.add(split[i]);
			}
		}

		CComplaints = TokenizedString[1];
		if (CComplaints.equals("")) {
		} else {
			String[] split = CComplaints.split(",");

			complicated.add("~Complaints");

			for (int i = 0; i < split.length; i++) {
				complicated.add(split[i]);
			}
		}

		CPostPhysicalExamination = TokenizedString[3];
		if (CPostPhysicalExamination.equals("")) {
		} else {
			String[] split = CPostPhysicalExamination.split(",");
			complicated.add("~Physical Examination");
			for (int i = 0; i < split.length; i++) {
				complicated.add(split[i].toString());
			}
		}

		CDeliveryAlert = TokenizedString[5].toString();
		if (CDeliveryAlert.equals("")) {

		} else {
			String[] split = CDeliveryAlert.split(",");
			complicated.add("~Delivery Alert");
			for (int i = 0; i < split.length; i++) {
				complicated.add(split[i].toString());
			}  
		}
		
		String listString = "";

		for (String s : Emergency)
		{
		    listString += s + "\t"; 
		}

		Toast.makeText(Postnatal_Alerts_GenerationClass.this,
				"list Emergency: " + listString , Toast.LENGTH_SHORT).show();

	}

}
