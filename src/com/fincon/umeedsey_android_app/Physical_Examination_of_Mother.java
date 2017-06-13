package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Physical_Examination_of_Mother extends Activity {

	public static String rslt = "";

	Spinner SP_pallor, Sp_Uterine_involution, SP_vaginal_bleeding, SP_lochia,
			SP_perinium, Sp_Craked_nipples;

	EditText ET_Pulse, ET_Temp, ET_BPSys, ET_BPDys, ET_Hemoglobin;

	Button Btn_Save, Btn_Back;

	int Validator = 0;

	ValidatorClass obj = new ValidatorClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.physical_examination_of_mother);

		SP_pallor = (Spinner) findViewById(R.id.spinner2_pallor2);
		Sp_Uterine_involution = (Spinner) findViewById(R.id.spinner2_uterine_involution2);
		SP_vaginal_bleeding = (Spinner) findViewById(R.id.spinner2_vaginal_bleeding2);
		SP_lochia = (Spinner) findViewById(R.id.spinner2_lochia2);
		SP_perinium = (Spinner) findViewById(R.id.spinner2_perinium2);
		Sp_Craked_nipples = (Spinner) findViewById(R.id.spinner_craked_nipples2);

		ET_Pulse = (EditText) findViewById(R.id.pulse2);
		ET_Temp = (EditText) findViewById(R.id.Tempreture_peom2);
		ET_BPSys = (EditText) findViewById(R.id.BP_sys_peom2);
		ET_BPDys = (EditText) findViewById(R.id.BP_dys_peom2);
		ET_Hemoglobin = (EditText) findViewById(R.id.hemoglobin_peom2);

		Btn_Save = (Button) findViewById(R.id.button_save_peom2);
		Btn_Back = (Button) findViewById(R.id.button_back_peom2);

		// =========================================================================================================
		ET_Pulse.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_Pulse);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_BPSys.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_BPSys);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_BPDys.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_BPDys);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_Hemoglobin.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Number(ET_Hemoglobin);
			}
		});
		// =========================================================================================================

		Btn_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Validator = 0;

				if (obj.isInteger(ET_Pulse.getText().toString()) == false
						
						|| obj.isInteger(ET_BPSys.getText().toString()) == false
						|| obj.isInteger(ET_BPDys.getText().toString()) == false
						|| obj.isInteger(ET_Hemoglobin.getText().toString()) == false) {

					Toast.makeText(Physical_Examination_of_Mother.this,
							"Wrong Entry", Toast.LENGTH_SHORT).show();

				} else {

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertMotherPhysicalExamination";
						c.arg1a = "PhysicalExamination";

						c.arg1_value = IDs_Class.getPostNatalID()
								+ "53"
								+ SP_pallor.getSelectedItem().toString()
								+ IDs_Class.getPostNatalID()
								+ "54"
								+ Sp_Uterine_involution.getSelectedItem()
										.toString()
								+ IDs_Class.getPostNatalID()
								+ "55"
								+ SP_vaginal_bleeding.getSelectedItem()
										.toString()
								+ IDs_Class.getPostNatalID()
								+ "56"
								+ SP_lochia.getSelectedItem().toString()
								+ IDs_Class.getPostNatalID()
								+ "57"
								+ SP_perinium.getSelectedItem().toString()
								+ IDs_Class.getPostNatalID()
								+ "60"
								+ Sp_Craked_nipples.getSelectedItem()
										.toString()
								+ IDs_Class.getPostNatalID() + "61"
								+ ET_Pulse.getText().toString()
								+ IDs_Class.getPostNatalID() + "62"
								+ ET_Temp.getText().toString()
								+ IDs_Class.getPostNatalID() + "63"
								+ ET_BPSys.getText().toString() + "/"
								+ ET_BPDys.getText().toString()
								+ IDs_Class.getPostNatalID() + "64"
								+ ET_Hemoglobin.getText().toString();

						c.selection = 1116;
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

//					Toast.makeText(Physical_Examination_of_Mother.this,
//							"InsertPostnataVists" + rslt, Toast.LENGTH_SHORT)
//							.show();

//					Toast.makeText(Physical_Examination_of_Mother.this,
//							"Saved Successfully : " + rslt, Toast.LENGTH_SHORT)
//							.show();

					Intent i = new Intent(Physical_Examination_of_Mother.this,
							Postnatal_Complaints_OM_Class.class);

					startActivity(i);
				}

			}
		});

	}

	// =========================================================================================================
	public void Is_Valid_Number(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[0-9 ]+")) {
			edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================
	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
