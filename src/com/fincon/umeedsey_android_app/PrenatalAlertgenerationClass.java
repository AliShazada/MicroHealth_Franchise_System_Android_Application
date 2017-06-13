package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class PrenatalAlertgenerationClass extends Activity {

	public static String rslt = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prenatalalertsgeneration);

		// //////////////////////................................
		try {

			rslt = "START";

			Caller3 c = new Caller3();

			c.Method_Name = "SelectCDSSStatusForAndroid";
			c.arg1a = "patID";

			c.arg1_value = IDs_Class.getAM_Patient_ID();

			c.selection = 771;
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

		Toast.makeText(
				PrenatalAlertgenerationClass.this,
				"ServerReponse: " + rslt, Toast.LENGTH_SHORT)
				.show();

		// //////////////////////....................................................

	}

}
