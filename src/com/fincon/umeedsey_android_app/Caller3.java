package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.R.bool;
import android.app.AlertDialog;

import com.fincon.umeedsey_android_app.*;

public class Caller3 extends Thread {

	public CallSoap3 cs;
	public String arg1_value, arg2_value, arg3_value;
	public String Method_Name, arg1a, arg2a, arg3a;
	public int selection = 0;

	// ======================
	protected AlertDialog ad;

	public void run() {
		// 77 is a prefix to call CDss service .... ... .. ..

		if (selection == 771) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_CDss(arg1_value, Method_Name, arg1a);
				PrenatalAlertgenerationClass.rslt = resp;
			} catch (Exception ex) {
				PrenatalAlertgenerationClass.rslt = ex.toString();
			}

		}
		if (selection == 772) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_CDss(arg1_value, Method_Name, arg1a);
				Postnatal_Alerts_GenerationClass.rslt = resp;
			} catch (Exception ex) {
				Postnatal_Alerts_GenerationClass.rslt = ex.toString();
			}

		}
		
		// 77 is a prefix to call CDss service .... ... .. ..
		if (selection == 1) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Add_MotherClass.rslt = resp;
			} catch (Exception ex) {
				Add_MotherClass.rslt = ex.toString();
			}

		}
		if (selection == 12) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Genetic_History_Class.rslt = resp;
			} catch (Exception ex) {
				Genetic_History_Class.rslt = ex.toString();
			}

		}
		if (selection == 13) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Medical_HistoryClass.rslt = resp;
			} catch (Exception ex) {
				Medical_HistoryClass.rslt = ex.toString();
			}

		}
		if (selection == 14) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Present_pregnancy_record.rslt = resp;
			} catch (Exception ex) {
				Present_pregnancy_record.rslt = ex.toString();
			}

		}

		if (selection == 15) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				PreviousPregnencyClass.rslt = resp;
			} catch (Exception ex) {
				PreviousPregnencyClass.rslt = ex.toString();
			}

		}

		if (selection == 16) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Previous_Delivery_Class.rslt = resp;
			} catch (Exception ex) {
				Previous_Delivery_Class.rslt = ex.toString();
			}

		}
		if (selection == 17) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Allergies_Class.rslt = resp;
			} catch (Exception ex) {
				Allergies_Class.rslt = ex.toString();
			}

		}

		if (selection == 18) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call_ZeroPr(Method_Name);
				Allergies_Class.rslt = resp;
			} catch (Exception ex) {
				Allergies_Class.rslt = ex.toString();
			}

		}

		if (selection == 19) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Antenatal_Class.rslt = resp;
			} catch (Exception ex) {
				Antenatal_Class.rslt = ex.toString();
			}

		}

		if (selection == 110) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Urnalysis_Class.rslt = resp;
			} catch (Exception ex) {
				Urnalysis_Class.rslt = ex.toString();
			}

		}

		if (selection == 111) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Phyical_Examination_class.rslt = resp;
			} catch (Exception ex) {
				Phyical_Examination_class.rslt = ex.toString();
			}

		}
		if (selection == 112) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Complete_Blood_Count_Class.rslt = resp;
			} catch (Exception ex) {
				Complete_Blood_Count_Class.rslt = ex.toString();
			}

		}
		if (selection == 113) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				HepatitisB_Service_Class.rslt = resp;
			} catch (Exception ex) {
				HepatitisB_Service_Class.rslt = ex.toString();
			}

		}

		if (selection == 114) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Blood_Sugar_Test_Class.rslt = resp;
			} catch (Exception ex) {
				Blood_Sugar_Test_Class.rslt = ex.toString();
			}

		}

		if (selection == 115) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Ultrasound_Class.rslt = resp;
			} catch (Exception ex) {
				Ultrasound_Class.rslt = ex.toString();
			}

		}
		if (selection == 116) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call_ZeroPr(Method_Name);
				Medication_Class.rslt = resp;
			} catch (Exception ex) {
				Medication_Class.rslt = ex.toString();
			}

		}
		if (selection == 117) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Medication_Class.rslt = resp;
			} catch (Exception ex) {
				Medication_Class.rslt = ex.toString();
			}

		}

		if (selection == 118) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Tubal_PregnancyClass.rslt = resp;
			} catch (Exception ex) {
				Tubal_PregnancyClass.rslt = ex.toString();
			}

		}

		if (selection == 119) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Delivery_Basic_info_Class.rslt = resp;
			} catch (Exception ex) {
				Delivery_Basic_info_Class.rslt = ex.toString();
			}

		}

		if (selection == 1110) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}

		}
		if (selection == 1111) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				APGAR_Class.rslt = resp;
			} catch (Exception ex) {
				APGAR_Class.rslt = ex.toString();
			}

		}

		if (selection == 1112) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}

		}
		if (selection == 1113) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}

		}
		if (selection == 1114) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Postnatal_Complaints_OM_Class.rslt = resp;
			} catch (Exception ex) {
				Postnatal_Complaints_OM_Class.rslt = ex.toString();
			}

		}
		if (selection == 1115) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Postnatal_Complaints_OM_Class.rslt = resp;
			} catch (Exception ex) {
				Postnatal_Complaints_OM_Class.rslt = ex.toString();
			}

		}

		if (selection == 1116) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Physical_Examination_of_Mother.rslt = resp;
			} catch (Exception ex) {
				Physical_Examination_of_Mother.rslt = ex.toString();
			}

		}

		if (selection == 1117) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Complaints.rslt = resp;
			} catch (Exception ex) {
				Complaints.rslt = ex.toString();
			}

		}

		if (selection == 1118) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Rubella.rslt = resp;
			} catch (Exception ex) {
				Rubella.rslt = ex.toString();
			}

		}

		if (selection == 1119) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				BloodType_Class.rslt = resp;
			} catch (Exception ex) {
				BloodType_Class.rslt = ex.toString();
			}

		}

		if (selection == 1120) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Add_MotherClass.rslt = resp;
			} catch (Exception ex) {
				Add_MotherClass.rslt = ex.toString();
			}

		}

		if (selection == 1121) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Present_pregnancy_record.rslt = resp;
			} catch (Exception ex) {
				Present_pregnancy_record.rslt = ex.toString();
			}

		}

		if (selection == 123456) {

			try {

				cs = new CallSoap3();
				ArrayList<String> resp = cs.Arraylist_Fun(arg1_value,
						Method_Name, arg1a);
				ListClass.rslt = resp;
			} catch (Exception ex) {
				// ListClass.rslt = ex.toString();
			}

		}

		else if (selection == 2) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_2(arg1_value, arg2_value, Method_Name,
						arg1a, arg2a);
				Login_Class.rslt = resp;
			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}
		} else if (selection == 22) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Add_MotherClass.rslt = resp;
			} catch (Exception ex) {
				Add_MotherClass.rslt = ex.toString();
			}
		} else if (selection == 221) {

			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Antenatal_Class.rslt = resp;
			} catch (Exception ex) {
				Antenatal_Class.rslt = ex.toString();
			}
		}

		else if (selection == 222) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Urnalysis_Class.rslt = resp;
			} catch (Exception ex) {
				Urnalysis_Class.rslt = ex.toString();
			}
		} else if (selection == 223) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Complete_Blood_Count_Class.rslt = resp;
			} catch (Exception ex) {
				Complete_Blood_Count_Class.rslt = ex.toString();
			}
		}

		else if (selection == 224) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Blood_Sugar_Test_Class.rslt = resp;
			} catch (Exception ex) {
				Blood_Sugar_Test_Class.rslt = ex.toString();
			}
		} else if (selection == 225) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				HepatitisB_Service_Class.rslt = resp;
			} catch (Exception ex) {
				HepatitisB_Service_Class.rslt = ex.toString();
			}
		} else if (selection == 226) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Medical_HistoryClass.rslt = resp;
			} catch (Exception ex) {
				Medical_HistoryClass.rslt = ex.toString();
			}
		} else if (selection == 227) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Delivery_Basic_info_Class.rslt = resp;
			} catch (Exception ex) {
				Delivery_Basic_info_Class.rslt = ex.toString();
			}
		}

		else if (selection == 228) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}
		} else if (selection == 229) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}
		}

		else if (selection == 2210) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				Rubella.rslt = resp;
			} catch (Exception ex) {
				Rubella.rslt = ex.toString();
			}
		}

		else if (selection == 2211) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_2android(arg1_value, arg2_value,
						Method_Name, arg1a, arg2a);
				BloodType_Class.rslt = resp;
			} catch (Exception ex) {
				BloodType_Class.rslt = ex.toString();
			}
		}

		else if (selection == 3) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3(arg1_value, arg2_value, arg3_value);
				Login_Class.rslt = resp;
			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}
		}

		else if (selection == 4) {
			try {
				cs = new CallSoap3();

				List<String> resp = null;
				Collections.copy(resp, cs.Call_List(arg1_value));

				Collections.copy(Add_MotherClass.List_from_Server, resp);

			} catch (Exception ex) {
				Login_Class.rslt = ex.toString();
			}
		} else if (selection == 331) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Urnalysis_Class.rslt = resp;
			} catch (Exception ex) {
				Urnalysis_Class.rslt = ex.toString();
			}
		} else if (selection == 332) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Phyical_Examination_class.rslt = resp;
			} catch (Exception ex) {
				Phyical_Examination_class.rslt = ex.toString();
			}
		}

		else if (selection == 333) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Complete_Blood_Count_Class.rslt = resp;
			} catch (Exception ex) {
				Complete_Blood_Count_Class.rslt = ex.toString();
			}
		} else if (selection == 334) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Blood_Sugar_Test_Class.rslt = resp;
			} catch (Exception ex) {
				Blood_Sugar_Test_Class.rslt = ex.toString();
			}
		} else if (selection == 335) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				HepatitisB_Service_Class.rslt = resp;
			} catch (Exception ex) {
				HepatitisB_Service_Class.rslt = ex.toString();
			}
		} else if (selection == 336) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Medication_Class.rslt = resp;
			} catch (Exception ex) {
				Medication_Class.rslt = ex.toString();
			}
		} else if (selection == 337) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				DeliveryDetail_informationClass.rslt = resp;
			} catch (Exception ex) {
				DeliveryDetail_informationClass.rslt = ex.toString();
			}
		}

		else if (selection == 338) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				CustomListView.rslt = resp;
			} catch (Exception ex) {
				CustomListView.rslt = ex.toString();
			}
		} else if (selection == 339) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				PostNatal_ListViewClass.rslt = resp;
			} catch (Exception ex) {
				PostNatal_ListViewClass.rslt = ex.toString();
			}
		}

		else if (selection == 3310) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Antenatal_Class.rslt = resp;
			} catch (Exception ex) {
				Antenatal_Class.rslt = ex.toString();
			}
		}

		else if (selection == 3311) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				Rubella.rslt = resp;
			} catch (Exception ex) {
				Rubella.rslt = ex.toString();
			}
		}

		else if (selection == 3312) {
			try {
				cs = new CallSoap3();
				String resp = cs.Call_3Android(arg1_value, arg2_value,
						arg3_value, Method_Name, arg1a, arg2a, arg3a);
				BloodType_Class.rslt = resp;
			} catch (Exception ex) {
				BloodType_Class.rslt = ex.toString();
			}
		}

		if (selection == 420420) {

			try {

				cs = new CallSoap3();
				bool resp = cs.CallBool(arg1_value, Method_Name, arg1a);
				Add_MotherClass.rslt = resp.toString();
			} catch (Exception ex) {
				Add_MotherClass.rslt = ex.toString();
			}

		}

		// for allergies 2 methodd

		if (selection == 18222) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call_ZeroPr(Method_Name);
				Allergies_Class2.rslt = resp;
			} catch (Exception ex) {
				Allergies_Class2.rslt = ex.toString();
			}

		}

		if (selection == 17222) {

			try {

				cs = new CallSoap3();
				String resp = cs.Call(arg1_value, Method_Name, arg1a);
				Allergies_Class2.rslt = resp;
			} catch (Exception ex) {
				Allergies_Class2.rslt = ex.toString();
			}

		}

		// ////////////

	}

}
