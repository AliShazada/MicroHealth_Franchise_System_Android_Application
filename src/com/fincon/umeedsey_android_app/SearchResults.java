package com.fincon.umeedsey_android_app;

import android.widget.TextView;

public class SearchResults {
	
	private String PersonID;
	private String Pregnency_ID;
	private String Patient_ID;
	
	private String name = "";
	private String cityState = "";
	private String phone = "";
	
	private String GardianName="";

	private String LMP = "";
	private String EDD = "";
	private String WeekNo = "";
	private String MrNumber = "";

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public String getCityState() {
		return cityState;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public String getLMP() {
		return LMP;
	}

	public void setLMP(String lMP) {
		LMP = lMP;
	}

	public String getEDD() {
		return EDD;
	}

	public void setEDD(String eDD) {
		EDD = eDD;
	}

	public String getWeekNo() {
		return WeekNo;
	}

	public void setWeekNo(String weekNo) {
		WeekNo = weekNo;
	}

	public String getMrNumber() {
		return MrNumber;
	}

	public void setMrNumber(String mrNumber) {
		MrNumber = mrNumber;
	}

	public String getPersonID() {
		return PersonID;
	}

	public void setPersonID(String personID) {
		PersonID = personID;
	}

	public String getPregnency_ID() {
		return Pregnency_ID;
	}

	public void setPregnency_ID(String pregnency_ID) {
		Pregnency_ID = pregnency_ID;
	}

	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String patient_ID) {
		Patient_ID = patient_ID;
	}

	public String getGardianName() {
		return GardianName;
	}

	public void setGardianName(String gardianName) {
		GardianName = gardianName;
	}
}