package com.twitterAPI.restAssuredCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.twitterAPI.utils.TestUtils;

import io.restassured.response.Response;

public class BaseAssertion {
       
	private static Logger log= LogManager.getLogger(TestUtils.class.getName());
	
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}
	
	public void verifyFalse(boolean flag) {
		Assert.assertFalse(flag);
	}
	
	public void verifyStausCode(Response response,int status) {
	Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}   
	
	public void verifyStatusMessage(Response response,String status) {
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
		}  
	
	
}
