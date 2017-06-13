package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends Activity {

	Button Add_mother, BTN_PostNatal, BTN_Prenatal, BTN_Logout;

	public MainMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu_activity);

		Add_mother = (Button) findViewById(R.id.btn_mother_reg_main);
		BTN_PostNatal = (Button) findViewById(R.id.btn_postnatal);
		BTN_Prenatal = (Button) findViewById(R.id.btn_prenatal);
		BTN_Logout = (Button) findViewById(R.id.button_logout_mainmenu);

		Add_mother.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub'

				Intent i = new Intent(MainMenu.this, Add_MotherClass.class);
				startActivity(i);

			}
		});

		BTN_PostNatal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent i = new Intent(MainMenu.this, PostnatalListClass.class);
				startActivity(i);

			}
		});

		BTN_Prenatal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(MainMenu.this, PrenatalListClass.class);
				startActivity(i);

			}
		});

		BTN_Logout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(MainMenu.this, "Log out !..", Toast.LENGTH_SHORT)
						.show();

				Intent i = new Intent(MainMenu.this, Login_Class.class);
				startActivity(i);

			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
