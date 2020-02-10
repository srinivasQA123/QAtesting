package com.ds.apitestcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tcpostrequest {
	@Test
	public void data()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestparams = new JSONObject();
		 requestparams.put("name","srinu");
		 requestparams.put("job", "testing");
		 
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestparams.toJSONString());
		Response httpresponse = httprequest.request(Method.POST,"api/users");
		  String body=httpresponse.getBody().asString();
		  System.out.println(body);
		  
		 int statuscode= httpresponse.getStatusCode();
		 System.out.println(statuscode);
		 Assert.assertEquals(statuscode, 201);
		
	}

}
