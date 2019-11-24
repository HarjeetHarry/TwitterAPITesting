package com.twitterAPI.restAssuredCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTcalls {

	private static Logger log= LogManager.getLogger(RESTcalls.class.getName());
		    
	public static Response GETRequest(String uRI) {
		log.info("Inside GET_Request Call");
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POST_Request Call");
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response POSTRequest(String uRI, String strJSON, String sessionID) {
		log.info("Inside POST_Request Call");
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie" , "JSESSIONIDID=" + sessionID + " ");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response PUTRequest(String uRI, String strJSON) {
		log.info("Inside PUT_Request Call");
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETE_Request Call");
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
}
