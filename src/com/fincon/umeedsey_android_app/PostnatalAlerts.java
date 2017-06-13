package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostnatalAlerts extends Activity {

	TextView Tv_PatientName;
	Button Btn_save, Btn_Back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnatal_alerts);

		Btn_save = (Button) findViewById(R.id.button_save_postnatal_alerts);
		Btn_Back = (Button) findViewById(R.id.button_back_postnatal_alerts);

		Tv_PatientName = (TextView) findViewById(R.id.textView_postnatal_patientName);

		Tv_PatientName.setText(IDs_Class.getTemp_PatientName());

		Btn_save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(PostnatalAlerts.this,
						Delivery_Basic_info_Class.class);
				startActivity(i);

			}
		});

		Btn_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(PostnatalAlerts.this,
						PostNatal_ListViewClass.class);
				startActivity(i);

			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
