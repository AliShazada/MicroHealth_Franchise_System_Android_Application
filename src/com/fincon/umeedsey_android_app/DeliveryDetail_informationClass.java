package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DeliveryDetail_informationClass extends Activity {

	public static String rslt = "";

	Spinner Sp_labour_Duration, SP_Delivery_Place, SP_No_of_Babies,
			SP_BabyStatus, Sp_DeliveryMode;

	EditText ET_Duration, ET_Others, ET_Details, ET_HospitaName, ET_BabyName,
			ET_BabyWeight, tvDisplayDate;

	RadioButton RB_SkilledPerson, RB_ChildSex;

	RadioGroup RG_SkilledPerson, RG_ChildSex;

	Button BTN_Save, BTN_Save_Baby;

	RelativeLayout relative_baby;

	TextView childs_value, no_of_babies_value;

	CheckBox CB_Obstructed_Labour, CB_Retained_Placenta, CB_PPH, CB_BP,
			CB_Eclampia;

	int RB_SkilledPerson_ID, RB_ChildSex_ID;
	int CHECK_Place = 0;
	int Check_Baby_No = 0;
	int CurrentBaby_counter;
	int Total_Babies;
	int year;
	int month;
	int day;
	int Validator_Ralativelayout = 0;

	int DeadStatus = 0;

	String CB_CheckObstructed_LabourID = "";
	String CB_CheckRetained_PlacentaID = "";
	String CB_CheckPPHID = "";
	String CB_CheckBPID = "";
	String CB_CheckEclampiaID = "";
	String Complications = null;
	String BabyDetail_String = "";
	String Current_Date;

	public ValidatorClass obj = new ValidatorClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delivery_detail_information);
		setCurrentDateOnView();

		CB_Obstructed_Labour = (CheckBox) findViewById(R.id.checkBox_obctstructed_laboour_PV_delivery_detail);
		CB_Retained_Placenta = (CheckBox) findViewById(R.id.checkBox_Retained_placenta_PV_delivery_detail);
		CB_PPH = (CheckBox) findViewById(R.id.checkBox_PPH_PV_delivery_detail);
		CB_BP = (CheckBox) findViewById(R.id.checkBox_BP_PV_delivery_detail);
		CB_Eclampia = (CheckBox) findViewById(R.id.checkBox_Eclampsia_PV_delivery_detail);

		Sp_labour_Duration = (Spinner) findViewById(R.id.spinner2_labour_duration_delivery_detail);
		SP_Delivery_Place = (Spinner) findViewById(R.id.spiner_delivery_place_delivery_detail);
		SP_No_of_Babies = (Spinner) findViewById(R.id.No_of_babies_prev_delivery_detail);
		SP_BabyStatus = (Spinner) findViewById(R.id.spinner_baby_Status_PreDel_DD);
		Sp_DeliveryMode = (Spinner) findViewById(R.id.spinner_DeliveryMode_PreDel_DD);

		ET_Others = (EditText) findViewById(R.id.other_PV_delivery_detail);
		ET_Details = (EditText) findViewById(R.id.Details_optional_PV_delivery_detail);
		ET_HospitaName = (EditText) findViewById(R.id.editText_Hospital_DD);
		ET_BabyName = (EditText) findViewById(R.id.BabyName_PreDel_DD);
		ET_BabyWeight = (EditText) findViewById(R.id.EditText_baby_weight_PreDel_DD);

		RG_SkilledPerson = (RadioGroup) findViewById(R.id.radio_skilled_person_delivery_detail);
		RG_ChildSex = (RadioGroup) findViewById(R.id.radio_sex_PreDel_DD);

		BTN_Save = (Button) findViewById(R.id.save_deliveryDetailInformation);

		BTN_Save_Baby = (Button) findViewById(R.id.Baby_Save_PreDel_DD);

		relative_baby = (RelativeLayout) findViewById(R.id.Relative_Baby_DeliveryDetail);

		childs_value = (TextView) findViewById(R.id.childs_value_DD);
		no_of_babies_value = (TextView) findViewById(R.id.no_of_babies_value_DD);

		// =========================================================================================================
		ET_BabyWeight.addTextChangedListener(new TextWatcher() {

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
				// Is_Valid_Number(ET_BabyWeight);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		ET_BabyName.addTextChangedListener(new TextWatcher() {

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
				// Is_Alphabets(ET_BabyName);
			}
		});
		// =========================================================================================================

		SP_Delivery_Place
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (CHECK_Place == 1) {

							if (SP_Delivery_Place.getSelectedItem().toString()
									.equals("Hospital(EmoNC)")
									|| SP_Delivery_Place.getSelectedItem()
											.toString()
											.equals("Hospital(CEmoNC)")) {
								ET_HospitaName.setVisibility(View.VISIBLE);

							} else {
								ET_HospitaName.setVisibility(View.GONE);
							}

						}
						CHECK_Place = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		SP_No_of_Babies
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (Check_Baby_No == 1) {

							if (SP_No_of_Babies.getSelectedItem().toString()
									.equals("No. of Babies")) {
								relative_baby.setVisibility(View.GONE);
							} else {

								BTN_Save.setVisibility(View.GONE);

								relative_baby.setVisibility(View.VISIBLE);

								no_of_babies_value.setText(SP_No_of_Babies
										.getSelectedItem().toString());

								Total_Babies = Integer
										.parseInt(no_of_babies_value.getText()
												.toString());

								CurrentBaby_counter = 1;

							}

						}
						Check_Baby_No = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		SP_BabyStatus
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (Check_Baby_No == 1) {

							if (SP_BabyStatus.getSelectedItem().toString()
									.equals("Death/StillBirth")) {
								ET_BabyName.setVisibility(View.GONE);
								ET_BabyWeight.setVisibility(View.GONE);
								
								DeadStatus=1;

							}
							else
							{
								ET_BabyName.setVisibility(View.VISIBLE);
								ET_BabyWeight.setVisibility(View.VISIBLE);
								DeadStatus=0;
							}

						}
						Check_Baby_No = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		BTN_Save_Baby.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				RB_ChildSex_ID = RG_ChildSex.getCheckedRadioButtonId();
				RB_ChildSex = (RadioButton) findViewById(RB_ChildSex_ID);

				Validator_Ralativelayout = 0;

				if (RG_ChildSex.getCheckedRadioButtonId() == -1) {
					Toast.makeText(DeliveryDetail_informationClass.this,
							"Select the Sex !.", Toast.LENGTH_SHORT).show();
				}
				
				if (ET_BabyWeight.getText().toString().length() <= 0
						|| ET_BabyName.getText().toString().length() <= 0) {
					
					if(DeadStatus!=1)
					{
						
					
					Validator_Ralativelayout = 11;
					Toast.makeText(DeliveryDetail_informationClass.this,
							"Fill all the Text Boxes !..", Toast.LENGTH_SHORT)
							.show();
					}

				}

				if (SP_BabyStatus.getSelectedItem().toString()
						.equals("Select Baby Status")
						|| SP_BabyStatus.getSelectedItem().toString()
								.equals("Select Delivery Mode")) {

					Toast.makeText(DeliveryDetail_informationClass.this,
							"All the DropDowns are not selected !",
							Toast.LENGTH_SHORT).show();

					Validator_Ralativelayout = 11;
				}
				if (obj.isInteger(ET_BabyWeight.getText().toString()) == false) {
					Validator_Ralativelayout = 11;

				}
				if (ET_BabyName.getText().toString().matches("[a-zA-Z]*")) {

				} else {
					Validator_Ralativelayout = 11;
				}

				if (Validator_Ralativelayout == 0) {

					childs_value.setText(String
							.valueOf(CurrentBaby_counter + 1));

					if (Total_Babies == 1) {
						BabyDetail_String += RB_ChildSex.getText() + "@"
								+ SP_BabyStatus.getSelectedItem().toString()
								+ "@" + ET_BabyWeight.getText().toString()
								+ "@" + IDs_Class.getPastDeliveryID() + "@"
								+ SessionClass.getUser_id() + "@"
								+ Sp_DeliveryMode.getSelectedItem().toString()
								+ "@" + ET_BabyName.getText().toString() + "@"
								+ String.valueOf(CurrentBaby_counter);
					} else if (CurrentBaby_counter == Total_Babies) {
						BabyDetail_String += RB_ChildSex.getText() + "@"
								+ SP_BabyStatus.getSelectedItem().toString()
								+ "@" + ET_BabyWeight.getText().toString()
								+ "@" + IDs_Class.getPastDeliveryID() + "@"
								+ SessionClass.getUser_id() + "@"
								+ Sp_DeliveryMode.getSelectedItem().toString()
								+ "@" + ET_BabyName.getText().toString() + "@"
								+ String.valueOf(CurrentBaby_counter);
					} else {

						BabyDetail_String += RB_ChildSex.getText() + "@"
								+ SP_BabyStatus.getSelectedItem().toString()
								+ "@" + ET_BabyWeight.getText().toString()
								+ "@" + IDs_Class.getPastDeliveryID() + "@"
								+ SessionClass.getUser_id() + "@"
								+ Sp_DeliveryMode.getSelectedItem().toString()
								+ "@" + ET_BabyName.getText().toString() + "@"
								+ String.valueOf(CurrentBaby_counter) + "/";
					}

					CurrentBaby_counter++;

					if (CurrentBaby_counter > Total_Babies) {
						relative_baby.setVisibility(View.GONE);
						BTN_Save.setVisibility(View.VISIBLE);

						Toast.makeText(DeliveryDetail_informationClass.this,
								"String : " + BabyDetail_String,
								Toast.LENGTH_SHORT).show();
					}

					ET_BabyWeight.setText("");
					ET_BabyName.setText("");
					SP_BabyStatus.setSelection(0);
					Sp_DeliveryMode.setSelection(0);

					Toast.makeText(DeliveryDetail_informationClass.this,
							" Saved ! ", Toast.LENGTH_SHORT).show();

				}

			}
		});

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				RB_SkilledPerson_ID = RG_SkilledPerson
						.getCheckedRadioButtonId();
				RB_SkilledPerson = (RadioButton) findViewById(RB_SkilledPerson_ID);

				if (Sp_labour_Duration.getSelectedItem().toString()
						.equals("Select Labour Duration")
						|| SP_Delivery_Place.getSelectedItem().equals(
								"Select Delivery Place")
						|| SP_No_of_Babies.getSelectedItem().equals(
								"Select No.of Babies")) {
					Toast.makeText(DeliveryDetail_informationClass.this,
							"All the DropDowns are not selected !",
							Toast.LENGTH_SHORT).show();
				} else {

					if (CB_Obstructed_Labour.isChecked()) {
						CB_CheckObstructed_LabourID = CB_Obstructed_Labour
								.getText().toString();

						Complications = Complications
								+ CB_CheckObstructed_LabourID + ",";
					}
					if (CB_Retained_Placenta.isChecked()) {
						CB_CheckRetained_PlacentaID = CB_Retained_Placenta
								.getText().toString();

						Complications = Complications
								+ CB_CheckRetained_PlacentaID + ",";

					}
					if (CB_PPH.isChecked()) {
						CB_CheckPPHID = CB_PPH.getText().toString();

						Complications = Complications + CB_CheckPPHID + ",";
					}
					if (CB_BP.isChecked()) {
						CB_CheckBPID = CB_BP.getText().toString();

						Complications = Complications + CB_CheckBPID + ",";
					}
					if (CB_Eclampia.isChecked()) {
						CB_CheckEclampiaID = CB_Eclampia.getText().toString();
						Complications = Complications + CB_CheckEclampiaID
								+ ",";
					}

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertPastDeliveries";
						c.arg1a = "pastDeliveries";
						c.arg2a = "PastDelID";

						c.arg1_value = IDs_Class.getPostnatal_list_PersonID()
								+ "@"
								+ IDs_Class.getPast_Obstetic_History_ID()
								+ "@"
								+ Sp_labour_Duration.getSelectedItem()
										.toString()
								+ "@"
								+ IDs_Class.getDeliveryDate()
								+ "@"
								+ SP_Delivery_Place.getSelectedItem()
										.toString() + "@"
								+ RB_SkilledPerson.getText().toString() + "@"
								+ IDs_Class.getPregnencyDuration() + "@"
								+ ET_Details.getText().toString() + "@"
								+ Complications + "@"
								+ SP_No_of_Babies.getSelectedItem().toString()
								+ "@" + ET_HospitaName.getText().toString();

						c.arg2_value = IDs_Class.getPastDeliveryID();

						c.selection = 228;
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

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "Server Response" + rslt, Toast.LENGTH_SHORT)
					// .show();

					IDs_Class.setPastDeliveryID(rslt);

					Toast.makeText(DeliveryDetail_informationClass.this,
							"Saved Successfully", Toast.LENGTH_SHORT).show();

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertNumberOfBabies";
						c.arg1a = "NumberOfBabies";
						c.arg2a = "PastDelID";
						c.arg1_value = BabyDetail_String;
						c.arg2_value = IDs_Class.getPastDeliveryID();

						c.selection = 228;
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

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "InsertNumberOfBabies : " + rslt,
					// Toast.LENGTH_SHORT).show();

					Toast.makeText(DeliveryDetail_informationClass.this,
							"Saved Successfully", Toast.LENGTH_SHORT).show();

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "InsertDeliveryCheck";
						c.arg1a = "DeliveryCheck";

						c.arg1_value = IDs_Class.getPostnatal_list_PregID()
								+ "@" + IDs_Class.getPostnatal_list_PersonID()
								+ "@" + Current_Date + "@"
								+ IDs_Class.getPast_Obstetic_History_ID();

						c.selection = 1113;
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

					// Toast.makeText(
					// DeliveryDetail_informationClass.this,
					// "5" + "@" + "10" + "@" + Current_Date + "@"
					// + IDs_Class.getPast_Obstetic_History_ID(),
					// Toast.LENGTH_SHORT).show();

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "InsertDeliveryCheck : " + rslt, Toast.LENGTH_SHORT)
					// .show();

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "UpdatePostnatalFlagChekc";
						c.arg1a = "PaitenID";
						c.arg2a = "PregnacyID";
						c.arg3a = "date";

						c.arg1_value = IDs_Class.getPostnatal_list_PatientID();
						c.arg2_value = IDs_Class.getPostnatal_list_PregID();
						c.arg3_value = Current_Date;

						c.selection = 337;
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

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "UpdatePostnatalFlagChekc : " + rslt,
					// Toast.LENGTH_SHORT).show();

					try {
						rslt = "START";
						Caller3 c = new Caller3();

						c.Method_Name = "UpdatePregnancyCaseClosing";
						c.arg1a = "PregnancyID";
						c.arg2a = "date";

						c.arg1_value = IDs_Class.getPostnatal_list_PregID();
						c.arg2_value = Current_Date;

						c.selection = 229;
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

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "UpdatePostnatalFlagChekc : " + rslt,
					// Toast.LENGTH_SHORT).show();

					// Toast.makeText(DeliveryDetail_informationClass.this,
					// "IDs_Class.getDeliveryDate()  : " +
					// IDs_Class.getDeliveryDate(),
					// Toast.LENGTH_SHORT).show();
					//
					if (Current_Date.equals(IDs_Class.getDeliveryDate())) {

						Intent i = new Intent(
								DeliveryDetail_informationClass.this,
								APGAR_Class.class);
						startActivity(i);
					} else {

						Toast.makeText(DeliveryDetail_informationClass.this,
								"Clear", Toast.LENGTH_SHORT).show();

						Intent i = new Intent(
								DeliveryDetail_informationClass.this,
								Physical_Examination_of_Mother.class);
						startActivity(i);
					}

				}

			}
		});

	}

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		Current_Date = (new StringBuilder()
		// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year)).toString();

	}

	// =========================================================================================================
	public void Is_Alphabets(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Alphabets Only.");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
			edt.setError("Accept Alphabets Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

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
