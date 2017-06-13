package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrenatalListClass extends Activity {

	Button BTN_Normal, BTN_Complicated, BTN_Emergency, BTN_Back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prenatal_list);

		BTN_Normal = (Button) findViewById(R.id.button_NormalPatient);
		BTN_Complicated = (Button) findViewById(R.id.button_complicatedPatient);
		BTN_Emergency = (Button) findViewById(R.id.button_emergencyPatient);
		BTN_Back = (Button) findViewById(R.id.button_back_prenatal_list);

		BTN_Normal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Normal");
				Intent i = new Intent(PrenatalListClass.this,
						CustomListView.class);
				startActivity(i);

			}
		});

		BTN_Complicated.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Complicated");
				Intent i = new Intent(PrenatalListClass.this,
						CustomListView.class);
				startActivity(i);

			}
		});

		BTN_Emergency.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Emergency");
				Intent i = new Intent(PrenatalListClass.this,
						CustomListView.class);

				startActivity(i);

			}
		});

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(PrenatalListClass.this, MainMenu.class);
				startActivity(i);

			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
