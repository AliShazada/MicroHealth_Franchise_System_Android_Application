package com.fincon.umeedsey_android_app;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ListClass extends Activity {

	RadioGroup rg;
	RadioButton rb;
	Button save;
	int id;
	String listString = "";
	static ArrayList<String> rslt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gh);

		rg = (RadioGroup) findViewById(R.id.radio_test);
		save = (Button) findViewById(R.id.button1_abc);

		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				id = rg.getCheckedRadioButtonId();

				rb = (RadioButton) findViewById(id);

				if (rg.getCheckedRadioButtonId() == -1) {
					// empty selection
					Toast.makeText(getApplicationContext(),
							"Nothing is selected", Toast.LENGTH_SHORT).show();

				} else {
					// user selected one radio button.
					Toast.makeText(getApplicationContext(),
							rb.getText() + "is selected", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

		// // ////////////////////////////////////////////////
		//
		// try {
		//
		// Caller3 c = new Caller3();
		//
		// c.Method_Name = "abc";
		// c.arg1a = "MethodDummy";
		// c.arg1_value = "oy34";
		//
		// c.selection = 123456;
		//
		// c.join();
		// c.start();
		//
		// for (String s : rslt) {
		// listString += s + "\t";
		// }
		//
		// Toast.makeText(getApplicationContext(), "Response : " + listString,
		// Toast.LENGTH_SHORT).show();
		//
		// // Toast.makeText(getApplicationContext(),
		// // " Server Response : " + rslt, Toast.LENGTH_LONG).show();
		//
		// } catch (Exception ex) {
		//
		// }

	}

}
