package com.twitterAPI.restAssuredCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.twitterAPI.utils.PayloadGenerator;
import com.twitterAPI.utils.TestUtils;
import com.twitterAPI.utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {

	private static Logger log= LogManager.getLogger(BaseTest.class.getName());
	
	public static String doLogin() {
		Response response;
		log.info("Starting Test Case : doLogin");
		String loginPayload = PayloadGenerator.generatePayLoadString("TwitterLogin.json");
		String endPointURI = URL.getEndPoint();
		
		response = RESTcalls.POSTRequest(endPointURI, loginPayload);
		log.info(response.getBody().asString());
		
		String strResponse = TestUtils.getResponseString(response);		
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		
		String sessionID = jsonRes.getString("session.value");
		log.info("JIRA JSession ID : " + sessionID);
		return sessionID;
	}

}
