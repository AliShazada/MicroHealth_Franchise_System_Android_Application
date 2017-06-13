package com.fincon.umeedsey_android_app;

public class CountryClass {

	public CountryClass(String id, String name) {
		super();
		CountryClass.id = id;
		Name = name;
	}

	public static String id;
	public static String Name;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		CountryClass.id = id;
	}

	public static String getName() {
		return Name;
	}

	public static void setName(String name) {
		Name = name;
	}

}
