package com.fincon.umeedsey_android_app;

public class ServerResponseClass {

	public static String rslt = "";

	public static String SingleArgument_Function(String Methodname,
			String ArgumentName, String ArgumentValue, int Selector) {

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = Methodname;
			c.arg1a = ArgumentName;
			c.arg1_value = ArgumentValue;
			c.selection = Selector;

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

		return rslt;
	}

	public static String DoubleArgument_Function(String Methodname,
			String FirstArgumentName, String FirstArgumentValue,
			String SecondArgumentName, String SecondArgumentValue, int Selector) {

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = Methodname;
			c.arg1a = FirstArgumentName;
			c.arg1_value = FirstArgumentValue;
			c.arg2a = SecondArgumentName;
			c.arg2_value = SecondArgumentValue;

			c.selection = Selector;

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

		return rslt;
	}

	public static String TripleArgument_Function(String Methodname,
			String FirstArgumentName, String FirstArgumentValue,
			String SecondArgumentName, String SecondArgumentValue,
			String ThirdArgumentName, String ThirdArgumentValue, int Selector) {

		try {
			rslt = "START";
			Caller3 c = new Caller3();

			c.Method_Name = Methodname;
			c.arg1a = FirstArgumentName;
			c.arg1_value = FirstArgumentValue;
			c.arg2a = SecondArgumentName;
			c.arg2_value = SecondArgumentValue;
			c.arg3a = ThirdArgumentName;
			c.arg3_value = ThirdArgumentValue;

			c.selection = Selector;

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

		return rslt;
	}
}
