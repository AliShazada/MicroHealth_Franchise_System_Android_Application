package com.fincon.umeedsey_android_app;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.bool;

public class CallSoap3 {

	public String SOAP_ACTION = "null";// "http://tempuri.org/IService1/SendLoginInformation"										// ;

	public String OPERATION_NAME = "null";// "SendLoginInformation";// =
											// "confun";
	public final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ADDRESS = "http://192.168.1.149:8082/Service1.svc";
	private String arg1;
	private String arg2;
	private String arg3;

	// public CallSoap3(String Method_Name, String arg1a)
	// {
	// OPERATION_NAME=Method_Name;
	//
	// SOAP_ACTION = "http://tempuri.org/IService1/"+ OPERATION_NAME;
	//
	// arg1=arg1a;
	//
	// }
	// public CallSoap3(String Method_Name, String arg1a, String arg2a)
	// {
	// OPERATION_NAME=Method_Name;
	//
	// SOAP_ACTION = "http://tempuri.org/IService/"+ OPERATION_NAME;
	//
	// arg1=arg1a;
	// arg2=arg2a;
	//
	// }
	// public CallSoap3(String Method_Name, String arg1a, String arg2a, String
	// arg3a)
	// {
	// OPERATION_NAME=Method_Name;
	//
	// SOAP_ACTION = "http://tempuri.org/IService/"+ OPERATION_NAME;
	//
	// arg1=arg1a;
	// arg2=arg2a;
	// arg3=arg3a;
	//
	// }
	public CallSoap3() {

	}

	public String Call_ZeroPr(String methodname) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}

	public String Call(String a, String methodname, String arg1_name) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}
	
	public String Call_CDss(String a, String methodname, String arg1_name) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/CdssStatus.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/ICdssStatus/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}
	
	
	public bool CallBool(String a, String methodname, String arg1_name) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return (bool) response;
	}

	public String Call_2android(String a, String b, String methodname,
			String arg1_name, String arg2_name) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg2_name);
		pi.setValue(b);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}

	public String Call_2(String a, String b, String methodname,
			String arg1_name, String arg2_name) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg2_name);
		pi.setValue(b);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IService1/" + methodname,
					envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}

	public String Call_3(String a, String b, String c) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg2);
		pi.setValue(b);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg3);
		pi.setValue(c);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}

	public String Call_3Android(String a, String b, String c,
			String methodname, String arg1_name, String arg2_name,
			String arg3_name) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg2_name);
		pi.setValue(b);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName(arg3_name);
		pi.setValue(c);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return response.toString();
	}


	
	public ArrayList<String> Arraylist_Fun(String a, String methodname, String arg1_name) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, methodname);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1_name);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(
				"http://192.168.1.149:8082/AndroidService.svc");
		Object response = null;
		try {
			httpTransport.call("http://tempuri.org/IAndroidService/"
					+ methodname, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}
		return (ArrayList<String>) response;
	}

	@SuppressWarnings("unchecked")
	public List<String> Call_List(String a) {

		List<String> List_Result;

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME);
		PropertyInfo pi = new PropertyInfo();
		pi.setName(arg1);
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);

		// pi = new PropertyInfo();
		// pi.setName(arg2);
		// pi.setValue(b);
		// pi.setType(String.class);
		// request.addProperty(pi);
		//
		// pi = new PropertyInfo();
		// pi.setName(arg3);
		// pi.setValue(c);
		// pi.setType(String.class);
		// request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
		} catch (Exception exception) {
			response = exception.toString();
		}

		List_Result = (List<String>) response;

		return List_Result;
	}
}
