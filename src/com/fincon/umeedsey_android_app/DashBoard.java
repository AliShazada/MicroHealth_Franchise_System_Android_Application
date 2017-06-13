package com.fincon.umeedsey_android_app;

import java.util.Calendar;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashBoard extends Activity {

	Button BTN_AntenatalVisit, BTN_Complaints, BTN_Urinalysis,
			BTN_PhysicalExaminaton, BTN_CBC, BTN_HepB, BTN_BloodTyping,
			BTN_RubellaTitre, BTN_BloodSugarTest, BTN_UltrasoundScan,
			BTN_MedicationAlert, BTN_Medication, BTN_OralGlucose,
			BTN_Misscarriage, BTN_ViewPreception, BTN_Allergies;
	Button BTN_Back;
	TextView TV_PName;

	int year;
	int month;
	int day;

	String Current_Date;

	WeekClass objWeek = new WeekClass();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		setCurrentDateOnView();

		BTN_Back = (Button) findViewById(R.id.button_back_dashboard);

		BTN_AntenatalVisit = (Button) findViewById(R.id.btn_dashboard_AntenatalVisit);
		BTN_Complaints = (Button) findViewById(R.id.btn_dashboard_complaints);
		BTN_Urinalysis = (Button) findViewById(R.id.btn_dashboard_urinalysis);
		BTN_PhysicalExaminaton = (Button) findViewById(R.id.btn_dashboard_physicalexaminatoin);
		BTN_CBC = (Button) findViewById(R.id.btn_dashboard_CBC);
		BTN_HepB = (Button) findViewById(R.id.btn_dashboard_HepatitisB);
		BTN_BloodTyping = (Button) findViewById(R.id.btn_dashboard_Blood_Typing);
		BTN_RubellaTitre = (Button) findViewById(R.id.btn_dashboard_Rubella_Titre);
		BTN_BloodSugarTest = (Button) findViewById(R.id.btn_dashboard_BloodSugarTest);
		BTN_UltrasoundScan = (Button) findViewById(R.id.btn_dashboard_UltrosoundScan);
		BTN_MedicationAlert = (Button) findViewById(R.id.btn_dashboard_MedicationAlert);
		BTN_Medication = (Button) findViewById(R.id.btn_dashboard_Medication);
		BTN_OralGlucose = (Button) findViewById(R.id.btn_dashboard_OralGlucose);
		BTN_Misscarriage = (Button) findViewById(R.id.btn_dashboard_Miscarriage);
		BTN_ViewPreception = (Button) findViewById(R.id.btn_dashboard_ViewPrescription);
		BTN_Allergies = (Button) findViewById(R.id.btn_dashboard_Allergies);

		TV_PName = (TextView) findViewById(R.id.text_patientname_sd);

		TV_PName.setText("Patient Name : " + IDs_Class.getPatientName());

		// / Check on Gestation Period //// .... .... ...

		// if (objWeek.WeekCalculator(Current_Date, IDs_Class.getLMP()) < 10) {

		if (Integer.parseInt(IDs_Class.getGestationWeek()) < 10) {

			BTN_AntenatalVisit.setVisibility(View.VISIBLE);

			BTN_Complaints.setVisibility(View.GONE);

			BTN_Urinalysis.setVisibility(View.GONE);

			BTN_PhysicalExaminaton.setVisibility(View.GONE);

			BTN_CBC.setVisibility(View.GONE);

			BTN_HepB.setVisibility(View.GONE);

			BTN_BloodTyping.setVisibility(View.GONE);

			BTN_RubellaTitre.setVisibility(View.GONE);

			BTN_BloodSugarTest.setVisibility(View.GONE);

			BTN_UltrasoundScan.setVisibility(View.GONE);

			// BTN_MedicationAlert.setVisibility(View.GONE);

			BTN_Medication.setVisibility(View.VISIBLE);

			// BTN_OralGlucose.setVisibility(View.GONE);

			BTN_Misscarriage.setVisibility(View.VISIBLE);

			// BTN_ViewPreception.setVisibility(View.VISIBLE);

			BTN_Allergies.setVisibility(View.VISIBLE);

		} else {

			BTN_AntenatalVisit.setVisibility(View.VISIBLE);

			BTN_Complaints.setVisibility(View.VISIBLE);

			BTN_Urinalysis.setVisibility(View.VISIBLE);

			BTN_PhysicalExaminaton.setVisibility(View.VISIBLE);

			BTN_CBC.setVisibility(View.VISIBLE);

			BTN_HepB.setVisibility(View.VISIBLE);

			BTN_BloodTyping.setVisibility(View.VISIBLE);

			BTN_RubellaTitre.setVisibility(View.VISIBLE);

			BTN_BloodSugarTest.setVisibility(View.VISIBLE);

			BTN_UltrasoundScan.setVisibility(View.VISIBLE);

			// BTN_MedicationAlert.setVisibility(View.VISIBLE);

			BTN_Medication.setVisibility(View.VISIBLE);

			// BTN_OralGlucose.setVisibility(View.VISIBLE);

			BTN_Misscarriage.setVisibility(View.VISIBLE);

			// BTN_ViewPreception.setVisibility(View.VISIBLE);

			BTN_Allergies.setVisibility(View.VISIBLE);

		}

		// / Check on Gestation Period Closed // /// /// .... ...

		if (DashBoardSession.getAntenatalVisit() == 11) {

			BTN_AntenatalVisit.setVisibility(View.GONE);

		} else {

			BTN_AntenatalVisit.setVisibility(View.VISIBLE);

		}
		if (DashBoardSession.getComplaints() == 11) {

			BTN_Complaints.setVisibility(View.GONE);

		} else {

			BTN_AntenatalVisit.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getUrinalysis() == 11) {

			BTN_Urinalysis.setVisibility(View.GONE);

		} else {

			BTN_Urinalysis.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getPhysicalExaminaton() == 11) {
			BTN_PhysicalExaminaton.setVisibility(View.GONE);

		} else {
			BTN_PhysicalExaminaton.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getCBC() == 11) {
			BTN_CBC.setVisibility(View.GONE);

		} else {
			BTN_CBC.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getHepB() == 11) {

			BTN_HepB.setVisibility(View.GONE);

		} else {

			BTN_HepB.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getBloodTyping() == 11) {

			BTN_BloodTyping.setVisibility(View.GONE);

		} else {
			BTN_BloodTyping.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getRubellaTitre() == 11) {

			BTN_RubellaTitre.setVisibility(View.GONE);

		} else {

			BTN_RubellaTitre.setVisibility(View.VISIBLE);

		}

		if (DashBoardSession.getBloodSugarTest() == 11) {

			BTN_BloodSugarTest.setVisibility(View.GONE);

		} else {
			BTN_BloodSugarTest.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getUltrasoundScan() == 11) {

			BTN_UltrasoundScan.setVisibility(View.GONE);

		} else {
			BTN_BloodSugarTest.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getMedicationAlert() == 11) {

			// BTN_MedicationAlert.setVisibility(View.GONE);

		} else {
			// BTN_MedicationAlert.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getOralGlucose() == 11) {

			// BTN_OralGlucose.setVisibility(View.GONE);

		} else {
			// BTN_OralGlucose.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getMisscarriage() == 11) {

			BTN_Misscarriage.setVisibility(View.GONE);

		} else {
			BTN_Misscarriage.setVisibility(View.VISIBLE);
		}

		if (DashBoardSession.getViewPreception() == 11) {

			// BTN_ViewPreception.setVisibility(View.GONE);

		} else {

			// BTN_ViewPreception.setVisibility(View.VISIBLE);

		}

		// if (DashBoardSession.getAllergies() == 11) {
		//
		// BTN_Allergies.setVisibility(View.GONE);
		//
		// } else {
		//
		// BTN_Allergies.setVisibility(View.VISIBLE);
		//
		// }

		if (Integer.parseInt((IDs_Class.getGestationWeek())) >= 28) {
			BTN_Misscarriage.setVisibility(View.GONE);
		}

		BTN_Urinalysis.setVisibility(View.GONE);

		BTN_AntenatalVisit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Antenatal_Class.class);
				startActivity(i);
			}
		});

		BTN_Complaints.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Complaints.class);
				startActivity(i);
			}
		});

		BTN_Urinalysis.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Urnalysis_Class.class);
				startActivity(i);
			}
		});
		BTN_PhysicalExaminaton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this,
						Phyical_Examination_class.class);

				startActivity(i);
			}
		});
		BTN_CBC.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this,
						Complete_Blood_Count_Class.class);

				startActivity(i);
			}
		});

		BTN_HepB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this,
						HepatitisB_Service_Class.class);

				startActivity(i);
			}
		});
		BTN_BloodTyping.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, BloodType_Class.class);
				startActivity(i);
			}
		});
		BTN_RubellaTitre.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Rubella.class);
				startActivity(i);
			}
		});
		BTN_BloodSugarTest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this,
						Blood_Sugar_Test_Class.class);
				startActivity(i);
			}
		});
		BTN_UltrasoundScan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Ultrasound_Class.class);
				startActivity(i);
			}
		});
		BTN_MedicationAlert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Medication_Class.class);
				// startActivity(i);
			}
		});

		BTN_Medication.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this, Medication_Class.class);
				startActivity(i);
			}
		});
		BTN_OralGlucose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		BTN_Misscarriage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DashBoard.this,
						Tubal_PregnancyClass.class);
				startActivity(i);
			}
		});

		BTN_ViewPreception.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent i = new Intent(DashBoard.this, .class);
				// startActivity(i);
			}
		});
		BTN_Allergies.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				IDs_Class.setAllergies_check(11);

				Intent i = new Intent(DashBoard.this, Allergies_Class.class);
				startActivity(i);
			}
		});

		BTN_Back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(DashBoard.this, MainMenu.class);
				startActivity(i);

			}
		});

	}

	public void setCurrentDateOnView() {

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview

		Current_Date = (new StringBuilder()
		// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year)).toString();

	}

}
