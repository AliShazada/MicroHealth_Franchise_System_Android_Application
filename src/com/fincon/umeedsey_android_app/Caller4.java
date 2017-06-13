package com.fincon.umeedsey_android_app;

import android.app.AlertDialog;

import com.fincon.umeedsey_android_app.*;


public class Caller4 extends Thread {

	public CallSoap3 cs;
	public String arg1_value, arg2_value, arg3_value;
	public String Method_Name, arg1a, arg2a, arg3a;
	public int selection = 0;
	
	// ======================
	protected AlertDialog ad;

	public void run() {
		if (selection == 1) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value,Method_Name,arg1a);
				Login_Class.rslt = resp;
			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}

		} else if (selection == 2) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_2(arg1_value, arg2_value,Method_Name,arg1a,arg2a);
				Login_Class.rslt = resp;
			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}
		} else if (selection == 3) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3(arg1_value, arg2_value, arg3_value);
				Login_Class.rslt = resp;
			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}
		}

	}

}
