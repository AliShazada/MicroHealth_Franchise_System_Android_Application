package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HepB_Class extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hepititis_b_service_antigen);

		RadioGroup RG_HEP;
		RadioButton RB_HEP;
		int ID_Hep;
		EditText ET_Remarks;
		Button BTN_Save, BTN_Skip;

		ET_Remarks = (EditText) findViewById(R.id.details_allergies);

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
