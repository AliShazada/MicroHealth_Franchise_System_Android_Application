package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Class extends Activity {

	public static String rslt = "";

	String LoginName;
	String LoginPassword;
	EditText ed1;
	EditText ed2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		// Button b1=(Button)findViewById(R.id.button1);
		final AlertDialog ad = new AlertDialog.Builder(this).create();

		ed1 = (EditText) findViewById(R.id.username_login);
		ed2 = (EditText) findViewById(R.id.password_login);

		LoginName = ed1.getText().toString();

		LoginPassword = ed2.getText().toString();

		Button b1 = (Button) findViewById(R.id.login_button_login);

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				//
				//
				//

				// ConnectivityManager conMgr = (ConnectivityManager)
				// getSystemService(Context.CONNECTIVITY_SERVICE);
				//
				// if (conMgr.getNetworkInfo(0).getState() ==
				// NetworkInfo.State.CONNECTED
				// || conMgr.getNetworkInfo(1).getState() ==
				// NetworkInfo.State.CONNECTING) {
				//
				// // notify user you are online
				// Toast.makeText(getApplicationContext(), " You are online ",
				// Toast.LENGTH_LONG).show();
				//
				//
				// } else if (conMgr.getNetworkInfo(0).getState() ==
				// NetworkInfo.State.DISCONNECTED
				// || conMgr.getNetworkInfo(1).getState() ==
				// NetworkInfo.State.DISCONNECTED) {
				//
				// // notify user you are not online
				// Toast.makeText(getApplicationContext(),
				// " Internet is not available", Toast.LENGTH_LONG)
				// .show();
				// }

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {
					Toast.makeText(getApplicationContext(),
							"Internet is available", Toast.LENGTH_SHORT).show();

					try {

						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "SendLoginInformation";

						c.arg1a = "username";
						c.arg2a = "password";

						c.arg1_value = ed1.getText().toString();
						c.arg2_value = ed2.getText().toString();
						c.selection = 2;

						c.ad = ad;
						c.join();
						c.start();
						while (rslt == "START") {
							try {
								Thread.sleep(10);
							} catch (Exception ex) {
							}
						}

						// Toast.makeText(getApplicationContext(),
						// " Server Response : " + rslt, Toast.LENGTH_LONG)
						// .show();

					} catch (Exception ex) {
						ad.setTitle("Error!");
						ad.setMessage(ex.toString());
					}

					// Toast.makeText(getApplicationContext(),
					// " Server Response " + rslt, Toast.LENGTH_LONG)
					// .show();

					if (rslt.equals("No Record")) {
						Toast.makeText(getApplicationContext(),
								" Invalid User Name or Password",
								Toast.LENGTH_LONG).show();
					} else {

//						Toast.makeText(getApplicationContext(),
//								" Server Response : " + rslt, Toast.LENGTH_LONG)
//								.show();
						Toast.makeText(getApplicationContext(),
								" Login Successful", Toast.LENGTH_SHORT).show();

						String[] ServerResponse = rslt.split(",");

						for (int i = 0; i < ServerResponse.length; i++) {

							if (i == 0) {
								SessionClass.setCMW_id(ServerResponse[i]);
							} else if (i == 1) {
								SessionClass.setDoc_id(ServerResponse[i]);
							} else if (i == 2) {
								SessionClass.setUser_id(ServerResponse[i]);
							} else if (i == 4) {
								SessionClass.setUC_id(ServerResponse[i]);
							} else if (i == 5) {
								SessionClass.setCompany_id(ServerResponse[i]);
							} else if (i == 6) {
								SessionClass
										.setLocalOffice_id(ServerResponse[i]);
							} else if (i == 7) {
								SessionClass.setLast_Name_id(ServerResponse[i]);
							}
						}

						Intent i = new Intent(Login_Class.this, MainMenu.class);
						startActivity(i);
					}
				} else if (isInternetPresent == false) {
					Toast.makeText(getApplicationContext(),
							"Internet is not available . Check the Internet",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
