package com.fincon.umeedsey_android_app;

public class ProvinceClass {

	public static String id;
	public static String Name;
	
	public ProvinceClass(String a, String b)
	{
		id=a;
		Name=b;
	}
	
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		ProvinceClass.id = id;
	}
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	
	
}
 