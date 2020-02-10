package com.ds.apitestcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCgetrequest {
	@Test
	public void TestCase1()
	{
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest = RestAssured.given();
		      
		Response httpresponse=httprequest.request(Method.GET,"/api/users?page=2");
		
		String Responsebody=httpresponse.getBody().asString();
		System.out.println(Responsebody);
		
		
		int  statuscode=httpresponse.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode,200);
		
		String statusline=httpresponse.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
		
		
	
		
		
		
	}

}
