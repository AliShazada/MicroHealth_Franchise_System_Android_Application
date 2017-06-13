package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostnatalListClass extends Activity {

	Button BTN_Normal, BTN_Complicated, BTN_Emergency, BTN_Back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnatal_list);

		BTN_Normal = (Button) findViewById(R.id.button_NormalPatient_postnatallist);
		BTN_Complicated = (Button) findViewById(R.id.button_complicatedPatient_postnatalList);
		BTN_Emergency = (Button) findViewById(R.id.button_emergencyPatient_postnatalList);
		BTN_Back = (Button) findViewById(R.id.button_back_postnatallist);

		BTN_Normal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Normal");
				Intent i = new Intent(PostnatalListClass.this,
						PostNatal_ListViewClass.class);
				startActivity(i);

			}
		});

		BTN_Complicated.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Complicated");
				Intent i = new Intent(PostnatalListClass.this,
						PostNatal_ListViewClass.class);
				startActivity(i);

			}
		});

		BTN_Emergency.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setPrenatalListStatus("Emergency");
				Intent i = new Intent(PostnatalListClass.this,
						PostNatal_ListViewClass.class);
				startActivity(i);

			}
		});

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(PostnatalListClass.this, MainMenu.class);
				startActivity(i);

			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
