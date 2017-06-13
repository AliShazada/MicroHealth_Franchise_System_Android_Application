package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_MotherClass extends Activity {

	public static String rslt = "";
	String stockArr;

	public static List<String> List_from_Server;

	EditText First_Name, Middle_Name, Last_Name, EMother_dateoB, CNIC, Weight,
			Gfirst_Name, Glast_Name, EG_CNIC, EG_DOB, Mobile_no, Residence_no,
			tvDisplayDate;
	EditText GuardianDOB, Address_Field;
	Button btnChangeDate;
	Button Guardian_dob_change;

	Spinner EMother_BloodGroup, Height_feet_mother, Height_inches_mother,
			SP_P_martialStatus, SP_P_Race, SP_P_Religion, Sp_G_Relation,
			Sp_G_Religion, SP_G_Blood_Group;
	Spinner Sp_Country, Sp_province, Sp_district, Sp_city, Sp_tehsil, Sp_UC;

	String P_FName, P_MName, P_LName, P_DOB, P_Cnic, P_Blood, P_height,
			P_weight, P_martialStatus, P_Race, P_Religion, G_FName, G_LName,
			G_Relation, G_CNIC, G_DOB, G_Religion;
	String Country, Province, District, City, Tehsil, Union_Council,
			Local_office, Address;

	String Current_Date, valid_name;

	Button Save_AddMother, Cancel_AddMother;

	private int year;
	private int month;
	private int day;
	private int year2;
	private int month2;
	private int day2;

	int yearAge;
	int monthAge;
	int dayAge;

	int checker_district = 0;

	public static int Country_counter;
	public static int province_counter;
	public static int district_counter;
	public static int tehsil_counter;
	public static int city_counter;
	public static int Uc_counter;

	int Country_checker = 0;
	int province_checker = 0;
	int district_checker = 0;
	int city_checker = 0;
	int Uc_checker = 0;
	int Date_Checker = 0;

	int temp_disttict_chk = 0;
	int tehsil_checker = 0;

	static final int DATE_DIALOG_ID = 999;

	public String[][] Provinces_Array;
	public String[][] District_Array;
	public String[][] City_Array;
	public String[][] Tehsil_Array;
	public String[][] UC_Array;

	public ValidatorClass obj = new ValidatorClass();

	List<String> list_province = new ArrayList<String>();
	List<String> list_District = new ArrayList<String>();
	List<String> list_City = new ArrayList<String>();
	List<String> list_Tehsil = new ArrayList<String>();
	List<String> list_UC = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_motherform);

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		First_Name = (EditText) findViewById(R.id.Firstname_addM);
		Middle_Name = (EditText) findViewById(R.id.MiddleName_addm);
		Last_Name = (EditText) findViewById(R.id.lastname_addM);
		EMother_dateoB = (EditText) findViewById(R.id.date_addMot);
		CNIC = (EditText) findViewById(R.id.CNIC_am);
		Weight = (EditText) findViewById(R.id.weight_addMother);
		Gfirst_Name = (EditText) findViewById(R.id.Guardian_Firstname_AM);
		Glast_Name = (EditText) findViewById(R.id.Guardian_Lastname_AM);
		EG_CNIC = (EditText) findViewById(R.id.Guardian_CNIC_am);
		EG_DOB = (EditText) findViewById(R.id.Gardian_date_addMot);
		Mobile_no = (EditText) findViewById(R.id.Mobile_no_addmother);
		Residence_no = (EditText) findViewById(R.id.residence_no_addmother);
		Address_Field = (EditText) findViewById(R.id.Address_mother);

		Sp_G_Relation = (Spinner) findViewById(R.id.guardian_relation);
		Sp_G_Religion = (Spinner) findViewById(R.id.guardian_religion);
		SP_G_Blood_Group = (Spinner) findViewById(R.id.husband_Blood_Type);

		EMother_BloodGroup = (Spinner) findViewById(R.id.spinner1_blood_mother);
		Height_feet_mother = (Spinner) findViewById(R.id.spinner_height_feet_mother);
		Height_inches_mother = (Spinner) findViewById(R.id.spinner_height_inches_mother);
		SP_P_martialStatus = (Spinner) findViewById(R.id.maternal_status_mother);
		SP_P_Race = (Spinner) findViewById(R.id.race_mother);
		SP_P_Religion = (Spinner) findViewById(R.id.religion_mother);

		Sp_Country = (Spinner) findViewById(R.id.select_country_addmother);
		Sp_province = (Spinner) findViewById(R.id.select_province_addmother);
		Sp_district = (Spinner) findViewById(R.id.select_district_addmother);
		Sp_city = (Spinner) findViewById(R.id.select_city_addmother);
		Sp_tehsil = (Spinner) findViewById(R.id.select_Tehsil_mother);
		Sp_UC = (Spinner) findViewById(R.id.select_union_council_mother);

		Save_AddMother = (Button) findViewById(R.id.save_addMother_btn);
		Cancel_AddMother = (Button) findViewById(R.id.cancenl_addmother_btn);

		setCurrentDateOnView();
		addListenerOnButton();

		setCurrentDateOnView2();
		addListenerOnButton2();

		// =========================================================================================================
		First_Name.addTextChangedListener(new TextWatcher() {

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
				Is_Alphabets(First_Name);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Middle_Name.addTextChangedListener(new TextWatcher() {

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
				Is_Alphabets(Middle_Name);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Last_Name.addTextChangedListener(new TextWatcher() {

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
				Is_Alphabets(Last_Name);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Gfirst_Name.addTextChangedListener(new TextWatcher() {

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
				Is_Alphabets(Gfirst_Name);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Glast_Name.addTextChangedListener(new TextWatcher() {

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
				Is_Alphabets(Glast_Name);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Weight.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(Weight);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		CNIC.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(CNIC);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		EG_CNIC.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(EG_CNIC);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Mobile_no.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(Mobile_no);
			}
		});
		// =========================================================================================================

		// =========================================================================================================
		Residence_no.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Number(Residence_no);
			}
		});
		// =========================================================================================================

		// // Code to Populate DropDownList of Country ////////////////////

		List<String> list_country = new ArrayList<String>();
		list_country.add("Select Country");
		list_province.add("Select Province");

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "SelectAllCoutries";
			c.arg1a = "a";
			c.arg1_value = "";
			c.selection = 1;

			c.ad = ad;
			c.join();
			c.start();
			while (rslt == "START") {
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}

			String[] Country_Token = rslt.split("/");
			int ic = 0;
			for (ic = 0; ic < Country_Token.length; ic++) {

			}
			Country_counter = ic + 1;

			CountryClass cntry_obj[] = new CountryClass[Country_counter];

			String[] Country_Token2 = rslt.split("/");

			String Country_id = null;
			String Country_name = null;

			for (int ic2 = 0; ic2 < Country_Token.length; ic2++) {

				String[] SubCountry_Token = Country_Token2[ic2].split(",");

				for (int jc2 = 0; jc2 < SubCountry_Token.length; jc2++) {
					if (jc2 == 0) {
						Country_id = SubCountry_Token[jc2];
					} else if (jc2 == 1) {
						Country_name = SubCountry_Token[jc2];
					}

				}

				cntry_obj[ic2] = new CountryClass(Country_id, Country_name);

				list_country.add(Country_name);

				Country_id = null;
				Country_name = null;

			}

		} catch (Exception ex) {
			ad.setTitle("Error!");
			ad.setMessage(ex.toString());
		}

		// Toast.makeText(getApplicationContext(), "List : " + rslt,
		// Toast.LENGTH_SHORT).show();

		// list_country.add("sadds");

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_country);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_Country.setAdapter(dataAdapter);

		Sp_Country
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (Country_checker == 1) {
							// Toast.makeText(
							// Add_MotherClass.this,
							// "You Selected : "
							// + Sp_Country.getSelectedItem()
							// .toString() + " Level ",
							// Toast.LENGTH_SHORT).show();

							ConnectionDetector cd = new ConnectionDetector(
									getApplicationContext());

							Boolean isInternetPresent = cd
									.isConnectingToInternet(); // true
																// or
																// false

							if (isInternetPresent == true) {

								Make_Provinces();

							}

							else {
								Toast.makeText(getApplicationContext(),
										"Internet is not available",
										Toast.LENGTH_SHORT).show();
							}

						}
						Country_checker = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		// // Code to Populate DropDownList of Country
		// Closed.........................

		// Code to Populate the Provinces Drop Down List ..........

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = "SelectAllProvices";
			c.arg1a = "ID";
			c.arg1_value = CountryClass.getId();
			c.selection = 1;

			c.ad = ad;
			c.join();
			c.start();
			while (rslt == "START") {
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}

		} catch (Exception ex) {
			ad.setTitle("Error!");
			ad.setMessage(ex.toString());
		}

		if (rslt.indexOf("anyType") != -1) {
			Toast.makeText(Add_MotherClass.this, "Service not Available ",
					Toast.LENGTH_SHORT).show();
		} else {

			// /////////////////
			String[] Province_Token = rslt.split("/");
			int ic = 0;
			for (ic = 0; ic < Province_Token.length; ic++) {

			}
			province_counter = ic;

			final ProvinceClass Province_obj[] = new ProvinceClass[province_counter];

			Provinces_Array = new String[province_counter][2];

			String[] Province_Token2 = rslt.split("/");

			String Province_id = null;
			String Province_name = null;

			for (int ic2 = 0; ic2 < Province_Token2.length; ic2++) {

				String[] SubProvince_Token = Province_Token2[ic2].split(",");

				for (int jc2 = 0; jc2 < SubProvince_Token.length; jc2++) {
					if (jc2 == 0) {
						Province_id = SubProvince_Token[jc2];
					} else if (jc2 == 1) {
						Province_name = SubProvince_Token[jc2];
					}

				}

				Province_obj[ic2] = new ProvinceClass(Province_id,
						Province_name);

				Provinces_Array[ic2][0] = Province_id;
				Provinces_Array[ic2][1] = Province_name;

				list_province.add(Province_name);

				Province_id = null;
				Province_name = null;

			}
		}
		// //////////////
		// Toast.makeText(getApplicationContext(), "List : " + rslt,
		// Toast.LENGTH_SHORT).show();

		// ArrayAdapter<String> dataAdapter_prov = new
		// ArrayAdapter<String>(this,
		// android.R.layout.simple_spinner_item, list_province);
		// dataAdapter_prov
		// .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Sp_province.setAdapter(dataAdapter_prov);

		Sp_province
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						if (province_checker == 1) {

							ConnectionDetector cd = new ConnectionDetector(
									getApplicationContext());

							Boolean isInternetPresent = cd
									.isConnectingToInternet(); // true
																// or
																// false

							if (isInternetPresent == true) {
								list_District.clear();
								list_City.clear();
								list_Tehsil.clear();
								list_UC.clear();

								for (int i_pr = 0; i_pr < province_counter; i_pr++) {

									String temp = Provinces_Array[i_pr][1];
									//
									if (temp.equals(Sp_province
											.getSelectedItem().toString())) {

										// Toast.makeText(
										// Add_MotherClass.this,
										// Provinces_Array[i_pr][1]
										// + " Levsddsel ",
										// Toast.LENGTH_SHORT).show();
										// checker_district = 11;

										//
										// // ////////// Code to Populate the
										// Provinces
										// // Drop Down List ////
										//
										// List<String> list_District = new
										// ArrayList<String>();

										list_District.add("Select District");

										try {
											rslt = "START";
											Caller3 c = new Caller3();

											c.Method_Name = "SelectAllDistricts";
											c.arg1a = "ID";
											c.arg1_value = Provinces_Array[i_pr][0];
											c.selection = 1;

											c.ad = ad;
											c.join();
											c.start();
											while (rslt == "START") {
												try {
													Thread.sleep(10);
												} catch (Exception ex) {
												}
											}

										} catch (Exception ex) {
											ad.setTitle("Error!");
											ad.setMessage(ex.toString());
										}

										// if (rslt.indexOf("anyType") != -1) {
										// Toast.makeText(
										// Add_MotherClass.this,
										// "No Districts present in "
										// + temp,
										// Toast.LENGTH_SHORT).show();
										// } else {

										String[] District_Token = rslt
												.split("/");
										int ic = 0;
										for (ic = 0; ic < District_Token.length; ic++) {

										}
										district_counter = ic;

										District_Array = new String[District_Token.length][2];

										String[] District_Token2 = rslt
												.split("/");

										String District_id = null;
										String District_name = null;
										//
										for (int ic2 = 0; ic2 < District_Token2.length; ic2++) {

											String[] SubDistrict_Token = District_Token2[ic2]
													.split("@");

											for (int jc2 = 0; jc2 < SubDistrict_Token.length; jc2++) {
												if (jc2 == 0) {
													District_id = SubDistrict_Token[jc2];
												} else if (jc2 == 1) {
													District_name = SubDistrict_Token[jc2];
												}

											}

											District_Array[ic2][0] = District_id;
											District_Array[ic2][1] = District_name;

											list_District.add(District_name);

											District_id = null;
											District_name = null;

										}

										Make_Districts();

										// Toast.makeText(getApplicationContext(),
										// "List : " + rslt,
										// Toast.LENGTH_SHORT).show();

										// ////////// Code to Populate the
										// Provinces
										// Drop Down List Closed......

									}

								}
							} else {
								Toast.makeText(Add_MotherClass.this,
										"Internet is not available",
										Toast.LENGTH_SHORT).show();
							}

						}

						province_checker = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		// // Code to Populate the Provinces Drop Down List
		// Closed .......................

		// Code to Populate City Drop Down list ...........

		Sp_district
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						// Toast.makeText(Add_MotherClass.this,
						// "checker" + temp_disttict_chk,
						// Toast.LENGTH_SHORT).show();
						String temp;
						if (temp_disttict_chk == 1) {
							ConnectionDetector cd = new ConnectionDetector(
									getApplicationContext());

							Boolean isInternetPresent = cd
									.isConnectingToInternet(); // true
																// or
																// false
							if (isInternetPresent == true) {

								list_City.clear();
								list_Tehsil.clear();
								list_UC.clear();

								try {

									for (int i_pr = 0; i_pr < district_counter; i_pr++) {

										temp = District_Array[i_pr][1];

										if (temp.equals(Sp_district
												.getSelectedItem().toString())) {

											// Toast.makeText(
											// Add_MotherClass.this,
											// District_Array[i_pr][1]
											// + " is Selectn ",
											// Toast.LENGTH_SHORT).show();
											// checker_district = 11;

											//
											// // ////////// Code to Populate
											// the
											// Provinces
											// // Drop Down List ////
											//
											// List<String> list_District = new
											// ArrayList<String>();

											list_City.add("Select City");

											try {
												rslt = "START";
												Caller3 c = new Caller3();

												c.Method_Name = "SelectAllCity";
												c.arg1a = "ID";
												c.arg1_value = District_Array[i_pr][0];
												c.selection = 1;

												c.ad = ad;
												c.join();
												c.start();
												while (rslt == "START") {
													try {
														Thread.sleep(10);
													} catch (Exception ex) {
													}
												}

											} catch (Exception ex) {
												ad.setTitle("Error!");
												ad.setMessage(ex.toString());
											}

											// Toast.makeText(Add_MotherClass.this,
											// "Cities : " + rslt,
											// Toast.LENGTH_SHORT).show();

											if (rslt.indexOf("anyType") != -1) {
												Toast.makeText(
														Add_MotherClass.this,
														"No Cities present in "
																+ temp,
														Toast.LENGTH_SHORT)
														.show();
											} else {
												String[] City_Token = rslt
														.split("/");
												int ic = 0;
												for (ic = 0; ic < City_Token.length; ic++) {

												}
												city_counter = ic;

												City_Array = new String[City_Token.length][2];

												String[] City_Token2 = rslt
														.split("/");

												String City_id = null;
												String City_name = null;
												//
												for (int ic2 = 0; ic2 < City_Token2.length; ic2++) {

													String[] SubDistrict_Token = City_Token2[ic2]
															.split("@");

													for (int jc2 = 0; jc2 < SubDistrict_Token.length; jc2++) {
														if (jc2 == 0) {
															City_id = SubDistrict_Token[jc2];
														} else if (jc2 == 1) {
															City_name = SubDistrict_Token[jc2];
														}

													}

													City_Array[ic2][0] = City_id;
													City_Array[ic2][1] = City_name;

													list_City.add(City_name);

													City_id = null;
													City_name = null;

												}

												Make_Cities();
											}
										}
									}

								} catch (Exception exception) {
									// TODO: handle exception

									Toast.makeText(Add_MotherClass.this,
											exception.getMessage(),
											Toast.LENGTH_SHORT).show();
								}
							}

							else {
								Toast.makeText(Add_MotherClass.this,
										"No Internet Connection",
										Toast.LENGTH_SHORT).show();
							}
						}

						temp_disttict_chk = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		// // Code to Populate City Drop Down list
		// Closed ...........

		// Code to Populate Tehsil Drop Down list ...........

		Sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> adapterView, View view,
					int i, long l) {
				// TODO Auto-generated method stub

				// Toast.makeText(Add_MotherClass.this, "checker" +
				// city_checker,
				// Toast.LENGTH_SHORT).show();

				if (city_checker == 1) {

					ConnectionDetector cd = new ConnectionDetector(
							getApplicationContext());

					Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																				// or
																				// false

					if (isInternetPresent == true) {

						list_Tehsil.clear();
						list_UC.clear();

						for (int i_pr = 0; i_pr < city_counter; i_pr++) {

							String temp = City_Array[i_pr][1];

							//
							if (temp.equals(Sp_city.getSelectedItem()
									.toString())) {

								// Toast.makeText(Add_MotherClass.this,
								// City_Array[i_pr][1] + " City is Selectn ",
								// Toast.LENGTH_SHORT).show();
								// checker_district = 11;

								//
								// // ////////// Code to Populate the
								// Provinces
								// // Drop Down List ////
								//
								// List<String> list_District = new
								// ArrayList<String>();

								list_Tehsil.add("Select Tehsil");

								try {
									rslt = "START";
									Caller3 c = new Caller3();

									c.Method_Name = "SelectAllTehsil";
									c.arg1a = "ID";
									c.arg1_value = City_Array[i_pr][0];
									c.selection = 1;

									c.ad = ad;
									c.join();
									c.start();
									while (rslt == "START") {
										try {
											Thread.sleep(10);
										} catch (Exception ex) {
										}
									}

								} catch (Exception ex) {
									ad.setTitle("Error!");
									ad.setMessage(ex.toString());
								}

								// Toast.makeText(Add_MotherClass.this,
								// "Tehsils : " + rslt + " Level ",
								// Toast.LENGTH_SHORT).show();

								if (rslt.indexOf("anyType") != -1) {
									Toast.makeText(Add_MotherClass.this,
											"No Tehsil present in " + temp,
											Toast.LENGTH_SHORT).show();
								} else {

									String[] Tehsil_Token = rslt.split("/");
									int ic = 0;
									for (ic = 0; ic < Tehsil_Token.length; ic++) {

									}
									tehsil_counter = ic;

									Tehsil_Array = new String[Tehsil_Token.length][2];

									String[] Tehsil_Token2 = rslt.split("/");

									String Tehsil_id = null;
									String Tehsil_name = null;
									// //
									for (int ic2 = 0; ic2 < Tehsil_Token2.length; ic2++) {

										String[] SubTehsil_Token = Tehsil_Token2[ic2]
												.split("@");

										for (int jc2 = 0; jc2 < SubTehsil_Token.length; jc2++) {
											if (jc2 == 0) {
												Tehsil_id = SubTehsil_Token[jc2];
											} else if (jc2 == 1) {
												Tehsil_name = SubTehsil_Token[jc2];
											}

										}

										Tehsil_Array[ic2][0] = Tehsil_id;
										Tehsil_Array[ic2][1] = Tehsil_name;

										list_Tehsil.add(Tehsil_name);

										Tehsil_id = null;
										Tehsil_name = null;

									}
									//
									Make_Tehsils();
									// Toast.makeText(getApplicationContext(),
									// "List : " + rslt, Toast.LENGTH_SHORT)
									// .show();

								}
							}

						}
					} else {
						Toast.makeText(getApplicationContext(),
								"No internet connection available",
								Toast.LENGTH_SHORT).show();
					}

				}

				city_checker = 1;

			}

			// If no option selected
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		// // Code to populate the UC Drop down List ..........................

		Sp_tehsil
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> adapterView,
							View view, int i, long l) {
						// TODO Auto-generated method stub

						// Toast.makeText(Add_MotherClass.this,
						// "checker" + tehsil_checker, Toast.LENGTH_SHORT)
						// .show();

						if (tehsil_checker == 1) {

							list_UC.clear();

							for (int i_pr = 0; i_pr < tehsil_counter; i_pr++) {

								String temp = Tehsil_Array[i_pr][1];

								//
								if (temp.equals(Sp_tehsil.getSelectedItem()
										.toString())) {

									// Toast.makeText(
									// Add_MotherClass.this,
									// Tehsil_Array[i_pr][1]
									// + " City is Selectn ",
									// Toast.LENGTH_SHORT).show();
									// checker_district = 11;

									//
									// // ////////// Code to Populate the
									// Provinces
									// // Drop Down List ////
									//
									// List<String> list_District = new
									// ArrayList<String>();

									list_UC.add("Select Union Council");

									try {
										rslt = "START";
										Caller3 c = new Caller3();

										c.Method_Name = "SelectAllUnionCouncil";
										c.arg1a = "ID";
										c.arg1_value = Tehsil_Array[i_pr][0];
										c.selection = 1;

										c.ad = ad;
										c.join();
										c.start();
										while (rslt == "START") {
											try {
												Thread.sleep(10);
											} catch (Exception ex) {
											}
										}

									} catch (Exception ex) {
										ad.setTitle("Error!");
										ad.setMessage(ex.toString());
									}

									// Toast.makeText(
									// Add_MotherClass.this,
									// "Union Councils : " + rslt
									// + " Level ",
									// Toast.LENGTH_SHORT).show();

									if (rslt.indexOf("anyType") != -1) {
										Toast.makeText(
												Add_MotherClass.this,
												"No Union Coucil is present in "
														+ temp,
												Toast.LENGTH_SHORT).show();
									} else {

										String[] UC_Token = rslt.split("/");
										int ic = 0;
										for (ic = 0; ic < UC_Token.length; ic++) {

										}
										Uc_counter = ic;

										UC_Array = new String[UC_Token.length][2];

										String[] UC_Token2 = rslt.split("/");

										String UC_id = null;
										String UC_name = null;
										// //
										for (int ic2 = 0; ic2 < UC_Token2.length; ic2++) {

											String[] SubUC_Token = UC_Token2[ic2]
													.split("@");

											for (int jc2 = 0; jc2 < SubUC_Token.length; jc2++) {
												if (jc2 == 0) {
													UC_id = SubUC_Token[jc2];
												} else if (jc2 == 1) {
													UC_name = SubUC_Token[jc2];
												}

											}

											UC_Array[ic2][0] = UC_id;
											UC_Array[ic2][1] = UC_name;

											list_UC.add(UC_name);

											UC_id = null;
											UC_name = null;

										}
										//
										Make_UCs();
										// Toast.makeText(getApplicationContext(),
										// "List : " + rslt, Toast.LENGTH_SHORT)
										// .show();

									}
								}

							}

						}

						tehsil_checker = 1;

					}

					// If no option selected
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		// // Code to populate the UC Drop down List CLOSED
		// ..........................

		Cancel_AddMother.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(getApplicationContext(), "Cancelled !",
						Toast.LENGTH_SHORT).show();

				Intent i = new Intent(Add_MotherClass.this, MainMenu.class);
				startActivity(i);

			}
		});

		// Saving the Mother Form
		Save_AddMother.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// TODO Auto-generated method stub

				ConnectionDetector cd = new ConnectionDetector(
						getApplicationContext());

				Boolean isInternetPresent = cd.isConnectingToInternet(); // true
																			// or
																			// false

				if (isInternetPresent == true) {
					AgeCalculation objAge = new AgeCalculation();

					if (objAge.AgeCal(yearAge, monthAge, dayAge) < 13) {

						Toast.makeText(
								getApplicationContext(),
								"Age is less than 13 Mother cannot Registered !",
								Toast.LENGTH_SHORT).show();

					} else {

						int Error_Check = 222;

						if (Height_feet_mother.getSelectedItem().toString()
								.equals("In Feet")
								|| Height_inches_mother.getSelectedItem()
										.toString().equals("In inches")
								|| SP_P_martialStatus.getSelectedItem()
										.toString()
										.equals("Select Marital Status")
								|| Sp_G_Relation.getSelectedItem().toString()
										.equals("Guardian Relation"))

						{
							Toast.makeText(getApplicationContext(),
									"Select all the mendatory Dropdowns",
									Toast.LENGTH_SHORT).show();
							Error_Check = 111;
						}

						// if (obj.isInteger(CNIC.getText().toString()) == false
						// || obj.isInteger(EG_CNIC.getText().toString()) ==
						// false
						// || CNIC.getText().toString().length() <= 0)
						//
						// {
						// Error_Check = 111;
						// Toast.makeText(getApplicationContext(),
						// "CNIC must be in Numberics", Toast.LENGTH_SHORT)
						// .show();
						// }

						// if (obj.isInteger(Weight.getText().toString()) ==
						// false
						// || obj.isInteger(Mobile_no.getText().toString()) ==
						// false
						// || obj.isInteger(Residence_no.getText().toString())
						// ==
						// false
						// || Weight.getText().toString().length() <= 0) {
						//
						// Error_Check = 111;
						//
						// // Toast.makeText(
						// // getApplicationContext(),
						// //
						// "Weight,Mobile No. and Residence no. must be in Numberics",
						// // Toast.LENGTH_SHORT).show();
						// }

						// if
						// (First_Name.getText().toString().matches("[a-zA-Z]*")
						//
						// &&
						// Last_Name.getText().toString().matches("[a-zA-Z]*")
						// && Gfirst_Name.getText().toString()
						// .matches("[a-zA-Z]*")
						// &&
						// Glast_Name.getText().toString().matches("[a-zA-Z]*"))
						// {
						//
						// } else {
						//
						// Error_Check = 111;
						// Toast.makeText(getApplicationContext(),
						// "InValid Name Entry", Toast.LENGTH_SHORT).show();
						// }

						if (First_Name.getText().toString().toString().length() <= 0

								|| Last_Name.getText().toString().toString()
										.length() <= 0
								|| Gfirst_Name.getText().toString().toString()
										.length() <= 0
								|| Glast_Name.getText().toString().toString()
										.length() <= 0
								|| Address_Field.getText().toString().length() <= 0) {

							Toast.makeText(getApplicationContext(),
									"Fill all the mendatory TextFields",
									Toast.LENGTH_SHORT).show();
							Error_Check = 111;
						}

						if (Error_Check != 111) {

							IDs_Class.setMotherWeight(Weight.getText()
									.toString());

							IDs_Class.setPatientName(First_Name.getText()
									.toString()
									+ ""
									+ Last_Name.getText().toString());

							String Result_from_server;
							try {

								rslt = "START";
								Caller3 c = new Caller3();

								// =====================================
								c.Method_Name = "insertPerson";
								c.arg1a = "personInformation";

								c.arg1_value = Gfirst_Name.getText().toString()
										+ "@"
										+ ""
										+ "@"
										+ Glast_Name.getText().toString()
										+ "@"
										+ ""
										+ "@"
										+ ""
										+ "@"
										+ ""
										+ "@"
										+ GuardianDOB.getText().toString()
										+ "@"
										+ ""
										+ "@"
										+ EG_CNIC.getText().toString()
										+ "@"
										+ ""
										+ "@"
										+ ""
										+ "@"
										+ "0"
										+ "@"
										+ SP_G_Blood_Group.getSelectedItem()
												.toString()
										+ "@"
										+ SessionClass.getUser_id()
										+ "@"
										+ ""
										+ "@"
										+ Sp_G_Religion.getSelectedItem()
												.toString() + "@"
										+ Current_Date + "@" + Current_Date
										+ "@" + "Guardian" + "@" + "Male" + "@"
										+ "" + "@" + "Self";
								// =====================================

								// String other =
								// First_Name.getText().toString()
								// + "@"
								// + Middle_Name.getText().toString()
								// + "@"
								// + Last_Name.getText().toString()
								// + "@"
								// + ""
								// + "@"
								// + ""
								// + "@"
								// + ""
								// + "@"
								// + tvDisplayDate.getText().toString()
								// + "@"
								// + ""
								// + "@"
								// + CNIC.getText().toString()
								// + "@"
								// + SP_P_Race.getSelectedItem().toString()
								// + "@"
								// + SP_P_martialStatus.getSelectedItem()
								// .toString()
								// + "@"
								// + "GuaRD ID DAALO"
								// + "@"
								// + EMother_BloodGroup.getSelectedItem()
								// .toString()
								// + "@"
								// + SessionClass.getUser_id()
								// + "@"
								// + ""
								// + "@"
								// + SP_P_Religion.getSelectedItem().toString()
								// + "@"
								// + Current_Date
								// + "@"
								// + ""
								// + "Mother"
								// + "@"
								// + "Female"
								// + "@"
								// + Height_feet_mother.getSelectedItem()
								// .toString()
								// + "."
								// + Height_inches_mother.getSelectedItem()
								// .toString() + "@"
								// + Sp_G_Relation.getSelectedItem().toString();

								c.selection = 1;

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
								// " Server Response : " + rslt,
								// Toast.LENGTH_LONG)
								// .show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// Toast.makeText(getApplicationContext(),
							// "Server Responce : " + rslt, Toast.LENGTH_SHORT)
							// .show();

							Result_from_server = rslt;

							// second ///

							// Toast.makeText(getApplicationContext(),
							// "Guardian N : " + Result_from_server,
							// Toast.LENGTH_SHORT).show();

							//

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								// =====================================
								c.Method_Name = "insertPerson";
								c.arg1a = "personInformation";

								// c.arg1_value =
								// Gfirst_Name.getText().toString() +
								// "@"
								// + "" + "@" + Glast_Name.getText().toString()
								// + "@" + "" + "@" + "" + "@" + "" + "@"
								// + GuardianDOB.getText().toString() + "@" + ""
								// + "@" + EG_CNIC.getText().toString() + "@" +
								// ""
								// + "@" + "" + "@" + "" + "@"
								// +
								// SP_G_Blood_Group.getSelectedItem().toString()
								// + "@" + SessionClass.getUser_id() + "@" + ""
								// + "@"
								// + Sp_G_Religion.getSelectedItem().toString()
								// + "@" + Current_Date + "@" + "" + "Guardian"
								// + "@" + "Male" + "@" + "" + "@" + "Self";
								// =====================================

								c.arg1_value = First_Name.getText().toString()
										+ "@"
										+ Middle_Name.getText().toString()
										+ "@"
										+ Last_Name.getText().toString()
										+ "@"
										+ ""
										+ "@"
										+ ""
										+ "@"
										+ ""
										+ "@"
										+ tvDisplayDate.getText().toString()
										+ "@"
										+ "15"
										+ "@"
										+ CNIC.getText().toString()
										+ "@"
										+ SP_P_Race.getSelectedItem()
												.toString()
										+ "@"
										+ SP_P_martialStatus.getSelectedItem()
												.toString()
										+ "@"
										+ Result_from_server
										+ "@"
										+ EMother_BloodGroup.getSelectedItem()
												.toString()
										+ "@"
										+ SessionClass.getUser_id()
										+ "@"
										+ SessionClass.getUser_id()
										+ "@"
										+ SP_P_Religion.getSelectedItem()
												.toString()
										+ "@"
										+ Current_Date
										+ "@"
										+ Current_Date
										+ "@"
										+ "Mother"

										+ "@"
										+ "Female"
										+ "@"
										+ Height_feet_mother.getSelectedItem()
												.toString()
										+ "."
										+ Height_inches_mother
												.getSelectedItem().toString()
										+ "@"
										+ Sp_G_Relation.getSelectedItem()
												.toString();

								c.selection = 1;

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
								// " Server Response : " + rslt,
								// Toast.LENGTH_LONG)
								// .show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// Toast.makeText(getApplicationContext(),
							// "Patient ID : " + rslt,
							// Toast.LENGTH_SHORT).show();

							String Person_ID = rslt;

							// ////////////////////////////////////////////////

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "insertPatient";
								c.arg1a = "p" + "atientInformation";

								c.arg1_value = Person_ID
										+ "@"
										+ ""
										+ "@"
										+ Current_Date
										+ "@"
										+ Current_Date
										+ "@"
										+ SessionClass.getUser_id()
										+ "@"
										+ ""
										+ "@"
										+ Weight.getText().toString()
										+ "@"
										+ "Alive" + "@"
										+ SessionClass.getCompany_id();

								c.selection = 1;

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
								// " Server Response : " + rslt,
								// Toast.LENGTH_LONG)
								// .show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// Toast.makeText(getApplicationContext(),
							// "Patient ID Response : " + rslt,
							// Toast.LENGTH_SHORT)
							// .show();

							String Patient = rslt;

							IDs_Class.setAM_Patient_ID(rslt);

							IDs_Class.setPatient_ID(Person_ID);

							// // Insert Patient Address
							// ........................................................

							String Temp_UC_Name = null;
							String UC_ID_DropDown = null;
							for (int cc = 0; cc < Uc_counter; cc++) {
								Temp_UC_Name = UC_Array[cc][1];
								if (Temp_UC_Name.equals(Sp_UC.getSelectedItem()
										.toString())) {
									UC_ID_DropDown = UC_Array[cc][0];

									// Toast.makeText(getApplicationContext(),
									// "YE le  : " + UC_ID_DropDown,
									// Toast.LENGTH_SHORT).show();
								}
							}

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "InsertPatientAddress";
								c.arg1a = "personAddress";

								c.arg1_value = UC_ID_DropDown + "@" + Person_ID
										+ "@"
										+ Address_Field.getText().toString()
										+ "@"
										+ Address_Field.getText().toString()
										+ "@" + "" + "@" + "" + "@"
										+ Mobile_no.getText().toString() + "@"
										+ "" + "@"
										+ SessionClass.getLocalOffice_id();

								c.selection = 1;

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
								// " Server Response : " + rslt,
								// Toast.LENGTH_LONG)
								// .show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// Toast.makeText(getApplicationContext(),
							// "Insert Address Response : " + rslt,
							// Toast.LENGTH_SHORT).show();

							// // Insert Patient Address CLOSED
							// ................................................

							// // Updation of MR Number.......................

							// Toast.makeText(getApplicationContext(),
							// SessionClass.getLast_Name_id() +"dfssdf"+
							// Patient,
							// Toast.LENGTH_LONG).show();

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "UpdatePatientMRNumberByPatientID";
								c.arg1a = "mrNumber";
								c.arg2a = "patientID";

								c.arg1_value = SessionClass.getLast_Name_id()
										+ Patient;
								c.arg2_value = Patient;

								c.selection = 22;

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
								// " Server Response : " + rslt,
								// Toast.LENGTH_LONG)
								// .show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// ----------------------------

							try {

								rslt = "START";
								Caller3 c = new Caller3();

								c.Method_Name = "SetIsNeedResumeFlagToFalseByPatientID";
								c.arg1a = "PatientID";

								c.arg1_value = Patient;
								c.selection = 1120;

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
								// " YE DEKHO : " + rslt,
								// Toast.LENGTH_LONG).show();

							} catch (Exception ex) {
								ad.setTitle("Error!");
								ad.setMessage(ex.toString());
							}

							// ------------------------------------------

							// Toast.makeText(getApplicationContext(),
							// "Insert Address Response : " + rslt,
							// Toast.LENGTH_SHORT).show();

							// // Updation of MR Number closed
							// .......................

							// /////////////////// 4th ...............
							// ///////////////////////////////////////

							// ////////////////////////////////////

							// try {
							//
							// rslt = "START";
							// Caller3 c = new Caller3();
							//
							// c.Method_Name = "SelectAllCoutries";
							// c.arg1a = "a";
							//
							// c.arg1_value = "";
							//
							// c.selection = 4;
							//
							// c.ad = ad;
							// c.join();
							// c.start();
							//
							// String list_value = "kjj";
							//
							// int size1=List_from_Server.size();
							// String sizze=Integer.toString(size1);
							//
							// for(int i=0;i<List_from_Server.size();i++)
							// {
							// list_value+=List_from_Server.get(i);
							// }
							//
							// Toast.makeText(getApplicationContext(),
							// "Server List Response : " + sizze,
							// Toast.LENGTH_SHORT)
							// .show();
							//
							//
							// } catch (Exception ex) {
							// ad.setTitle("Error!");
							// ad.setMessage(ex.toString());
							// }
							//
							Toast.makeText(getApplicationContext(),
									"Saved Successfully !", Toast.LENGTH_SHORT)
									.show();

							Intent i = new Intent(Add_MotherClass.this,
									Genetic_History_Class.class);
							startActivity(i);
						}
					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Internet is not available", Toast.LENGTH_SHORT)
							.show();
				}

			}

		});

	}

	// =========================================================================================================
	public void Is_Alphabets(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			// edt.setError("Enter the Value");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
			// edt.setError("Accept Alphabets Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	// =========================================================================================================
	public void Is_Valid_Number(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			// edt.setError("Enter the Value");
			// valid_name = null;
		} else if (!edt.getText().toString().matches("[0-9 ]+")) {
			// edt.setError("Accept Numbers Only.");
			// valid_name = null;
		} else {
			// valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================

	public void Make_Provinces() {
		ArrayAdapter<String> dataAdapter_district = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, list_province);
		dataAdapter_district
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_province.setAdapter(dataAdapter_district);
	}

	public void Make_Districts() {
		ArrayAdapter<String> dataAdapter_district = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, list_District);
		dataAdapter_district
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_district.setAdapter(dataAdapter_district);
	}

	public void Make_Cities() {
		ArrayAdapter<String> dataAdapter_city = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_City);
		dataAdapter_city
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_city.setAdapter(dataAdapter_city);
	}

	public void Make_Tehsils() {
		ArrayAdapter<String> dataAdapter_tehsil = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, list_Tehsil);
		dataAdapter_tehsil
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_tehsil.setAdapter(dataAdapter_tehsil);
	}

	public void Make_UCs() {
		ArrayAdapter<String> dataAdapter_UC = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_UC);
		dataAdapter_UC
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Sp_UC.setAdapter(dataAdapter_UC);
	}

	// display current date
	public void setCurrentDateOnView2() {

		GuardianDOB = (EditText) findViewById(R.id.Gardian_date_addMot);
		GuardianDOB.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year2 = c.get(Calendar.YEAR);
		month2 = c.get(Calendar.MONTH);
		day2 = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		GuardianDOB.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month2 + 1).append("/").append(day2).append("/")
				.append(year2).append(" "));

	}

	public void setCurrentDateOnView() {

		tvDisplayDate = (EditText) findViewById(R.id.date_addMot);
		tvDisplayDate.setKeyListener(null);
		// dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		tvDisplayDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("/").append(day).append("/")
				.append(year).append(" "));

		Current_Date = (new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("/").append(day).append("/")
				.append(year).append(" ")).toString();

		yearAge = year;
		monthAge = month;
		dayAge = day;

	}

	public void addListenerOnButton() {

		btnChangeDate = (Button) findViewById(R.id.pic_date);

		btnChangeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Date_Checker = 11;
				showDialog(DATE_DIALOG_ID);

			}

		});

	}

	public void addListenerOnButton2() {

		Guardian_dob_change = (Button) findViewById(R.id.guardianDOB_pic_date_btn);

		Guardian_dob_change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Date_Checker = 22;
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

			if (Date_Checker == 11) {

				yearAge = year;
				monthAge = month;
				dayAge = day;

				tvDisplayDate.setText(new StringBuilder().append(month + 1)
						.append("/").append(day).append("/").append(year)
						.append(" "));
			} else if (Date_Checker == 22) {

				GuardianDOB.setText(new StringBuilder().append(month + 1)
						.append("/").append(day).append("/").append(year)
						.append(" "));
			}

		}
	};

	@Override
	public void onBackPressed() {
		// do nothing.
	}

}
