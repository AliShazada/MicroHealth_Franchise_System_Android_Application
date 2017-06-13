package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Previous_Delivery_Class extends Activity {

	public static String rslt = "";

	RadioGroup RG_Skilled_Person, RG_Sex;
	RadioButton RB_skill, RB_Sex;

	EditText ET_Duration, ET_Others, ET_Details, ET_HospitaName, ET_BabyName,
			ET_BabyWeight, tvDisplayDate;
	Spinner SP_labour_duration, SP_delivery_Place, SP_No_of_Babies,
			SP_DeliveryMode, SP_BabyStatus;
	CheckBox CB_Obstructed_Labour, CB_Retained_Placenta, CB_PPH, CB_BP,
			CB_Eclampia;

	Button Save, Save_Baby, btnChangeDate;

	RelativeLayout relative_baby;

	TextView childs_value, no_of_babies_value;

	int RG_Skilled_Person_ID, RG_SEX_ID;

	String CB_CheckObstructed_LabourID = "";
	String CB_CheckRetained_PlacentaID = "";
	String CB_CheckPPHID = "";
	String CB_CheckBPID = "";
	String CB_CheckEclampiaID = "";
	String Complications = null;

	int year;
	int month;
	int day;
	int CHECK_Place = 0;
	int CurrentBaby_counter, Total_Babies;
	int Check_Baby_No = 0;
	static final int DATE_DIALOG_ID = 999;

	int DeadStatus = 0;

	int validator = 22;
	int Validator_Ralativelayout = 0;

	String Current_Date;

	DateCheckClass objDate = new DateCheckClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.previous_delivery);

		setCurrentDateOnView();
		addListenerOnButton();

		RG_Skilled_Person = (RadioGroup) findViewById(R.id.radio_skilled_person);
		RG_Sex = (RadioGroup) findViewById(R.id.radio_sex_PreDel);

		// RB_skill_yes = (RadioButton)
		// findViewById(R.id.radio_skilled_person_y);
		// RB_skill_no = (RadioButton)
		// findViewById(R.id.radio_skilled_person_n);

		SP_labour_duration = (Spinner) findViewById(R.id.spinner2_labour_duration);
		SP_delivery_Place = (Spinner) findViewById(R.id.spiner_delivery_place);
		SP_No_of_Babies = (Spinner) findViewById(R.id.No_of_babies_prev_delivery);
		SP_BabyStatus = (Spinner) findViewById(R.id.spinner_baby_Status_PreDel);
		SP_DeliveryMode = (Spinner) findViewById(R.id.spinner_DeliveryMode_PreDel);

		ET_Duration = (EditText) findViewById(R.id.text_duration);
		ET_Others = (EditText) findViewById(R.id.other_PV);
		ET_Details = (EditText) findViewById(R.id.Details_optional_PV);
		ET_HospitaName = (EditText) findViewById(R.id.editText_Hospital);
		ET_BabyName = (EditText) findViewById(R.id.BabyName_PreDel);
		ET_BabyWeight = (EditText) findViewById(R.id.EditText_baby_weight_PreDel);

		CB_Obstructed_Labour = (CheckBox) findViewById(R.id.checkBox_obctstructed_laboour_PV);
		CB_Retained_Placenta = (CheckBox) findViewById(R.id.checkBox_Retained_placenta_PV);
		CB_PPH = (CheckBox) findViewById(R.id.checkBox_PPH_PV);
		CB_BP = (CheckBox) findViewById(R.id.checkBox_BP_PV);
		CB_Eclampia = (CheckBox) findViewById(R.id.checkBox_Eclampsia_PV);

		Save = (Button) findViewById(R.id.Save_previous_delivery);
		Save_Baby = (Button) findViewById(R.id.Baby_Save_PreDel);

		relative_baby = (RelativeLayout) findViewById(R.id.Relative_Baby);

		childs_value = (TextView) findViewById(R.id.childs_value);
		no_of_babies_value = (TextView) findViewById(R.id.no_of_babies_value);

		ET_Duration.setKeyListener(null);
		ET_Duration.setText(IDs_Class.getDuration());

		tvDisplayDate.setText(IDs_Class.getPreviousPregnencyDate());

		SP_delivery_Place
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (CHECK_Place == 1) {

							if (SP_delivery_Place.getSelectedItem().toString()
									.equals("Hospital(EmoNC)")
									|| SP_delivery_Place.getSelectedItem()
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
									.equals("Select No.of Babies")) {
								relative_baby.setVisibility(View.GONE);
							} else {

								Save.setVisibility(View.GONE);
								relative_baby.setVisibility(View.VISIBLE);

								no_of_babies_value.setText(SP_No_of_Babies
										.getSelectedItem().toString());

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

								DeadStatus = 1;

							} else {
								ET_BabyName.setVisibility(View.VISIBLE);
								ET_BabyWeight.setVisibility(View.VISIBLE);
								DeadStatus = 0;
							}

						}
						Check_Baby_No = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		Save_Baby.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				RG_SEX_ID = RG_Sex.getCheckedRadioButtonId();
				RB_Sex = (RadioButton) findViewById(RG_SEX_ID);

				Validator_Ralativelayout = 0;

				if (SP_BabyStatus.getSelectedItem().toString()
						.equals("Select Baby Status")
						|| SP_DeliveryMode.getSelectedItem().toString()
								.equals("Select Delivery Mode")) {

					Toast.makeText(Previous_Delivery_Class.this,
							"All the DropDowns are not selected !",
							Toast.LENGTH_SHORT).show();

					Validator_Ralativelayout = 11;
				}

				if (ET_BabyWeight.getText().toString().length() <= 0
						|| ET_BabyName.getText().toString().length() <= 0) {

					if (DeadStatus != 1) {

						Validator_Ralativelayout = 11;
						Toast.makeText(Previous_Delivery_Class.this,
								"Fill all the Text Boxes !..",
								Toast.LENGTH_SHORT).show();
					}

				}
				int result = objDate.DateChecker(Current_Date, tvDisplayDate
						.getText().toString());

				if (result != 1) {
					Validator_Ralativelayout = 11;
					Toast.makeText(Previous_Delivery_Class.this,
							"Incorrect Previous Delivery Date !..",
							Toast.LENGTH_SHORT).show();

				}

				if (Validator_Ralativelayout == 0) {

					childs_value.setText(String
							.valueOf(CurrentBaby_counter + 1));

					CurrentBaby_counter++;

					if (CurrentBaby_counter > Total_Babies) {
						relative_baby.setVisibility(View.GONE);
						Save.setVisibility(View.VISIBLE);

					}

					ET_BabyWeight.setText("");
					ET_BabyName.setText("");
					SP_BabyStatus.setSelection(0);
					SP_DeliveryMode.setSelection(0);

					Toast.makeText(Previous_Delivery_Class.this, " Saved ! ",
							Toast.LENGTH_SHORT).show();

				}

			}
		});

		Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				RG_Skilled_Person_ID = RG_Skilled_Person
						.getCheckedRadioButtonId();
				RB_skill = (RadioButton) findViewById(RG_Skilled_Person_ID);

				validator = 22;

				if (SP_labour_duration.getSelectedItem().toString()
						.equals("Select Labour Duration")
						|| SP_delivery_Place.getSelectedItem().toString()
								.equals("Select Delivery Place")
						|| SP_No_of_Babies.getSelectedItem().toString()
								.equals("Select No.of Babies")) {

					validator = 11;
					Toast.makeText(Previous_Delivery_Class.this,
							"All the DropDowns are not selected !..",
							Toast.LENGTH_SHORT).show();
				}
				if (RG_Skilled_Person.getCheckedRadioButtonId() == -1) {
					validator = 11;
					Toast.makeText(Previous_Delivery_Class.this,
							"Select the Radio Option  !.." + rslt,
							Toast.LENGTH_SHORT).show();
				}
				if (validator == 22) {

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

						c.Method_Name = "PastDeliveries";
						c.arg1a = "PastDeliveries";

						c.arg1_value = IDs_Class.getPatient_ID()
								+ "|"
								+ IDs_Class.getLnPOH()
								+ "|"
								+ SP_labour_duration.getSelectedItem()
										.toString()
								+ "|"
								+ tvDisplayDate.getText().toString()
								+ "|"
								+ SP_delivery_Place.getSelectedItem()
										.toString() + "|"
								+ RB_skill.getText().toString() + "|"
								+ ET_Duration.getText().toString() + "|"
								+ ET_Details.getText().toString() + "|"
								+ Complications + "|"
								+ SP_No_of_Babies.getSelectedItem().toString()
								+ "|" + ET_HospitaName.getText().toString()
								+ "|";

						// c.arg1_value =
						// "2|2|Less than 12 hours|8-27-2014|Home Station|Yes|Tubal Pregnancy|Detail||2||";

						c.selection = 16;

						// c.ad = ad;
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

					Toast.makeText(Previous_Delivery_Class.this,
							"Saved Succesfully !..", Toast.LENGTH_SHORT).show();
					Toast.makeText(Previous_Delivery_Class.this,
							"Result " + rslt, Toast.LENGTH_SHORT).show();

					// IDs_Class.setCurrentPregnancyCase_ID(rslt);

					int tempGravida = IDs_Class.getGravida_counter();

					tempGravida--;

					IDs_Class.setGravida_counter(tempGravida);

					if (IDs_Class.getGravida_counter() == 0) {

						Intent i = new Intent(Previous_Delivery_Class.this,
								Allergies_Class.class);
						startActivity(i);
					} else {
						Intent i = new Intent(Previous_Delivery_Class.this,
								PreviousPregnencyClass.class);
						startActivity(i);
					}

				}
			}
		});

	}

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.date_of_previous_delivery);
		tvDisplayDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		// tvDisplayDate.setText(new StringBuilder()
		// // Month is 0 based, just add 1
		// .append(month + 1).append("-").append(day).append("-")
		// .append(year).append(" "));

		Current_Date = (new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" ")).toString();

	}

	public void addListenerOnButton() {

		btnChangeDate = (Button) findViewById(R.id.button_add_date_prevdel);

		btnChangeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showDialog(DATE_DIALOG_ID);

			}

		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			tvDisplayDate.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}
}
