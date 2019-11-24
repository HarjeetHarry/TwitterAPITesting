package com.twitterAPI.restAssuredCore;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.twitterAPI.utils.PayloadGenerator;
import com.twitterAPI.utils.URL;
import io.restassured.response.Response;

public class LoginTest {
	Response response;
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());
	public void doLogin() {
		String loginPayLoad = PayloadGenerator.generatePayLoadString("TwitterLogin.json");
		String endPointURI = URL.getEndPoint();
		response = RESTcalls.POSTRequest(endPointURI, loginPayLoad);
		log.info(response.getBody().asString());

	}
}
