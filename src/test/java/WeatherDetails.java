import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class WeatherDetails {

	@Test
	void getWeatherDetails()
	{
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console window
		
		String responseBoyd =response.getBody().asString();
		System.out.println("Response Body is:" + responseBoyd);
		
		//status code validation
		
		int statuscode=response.getStatusCode();
		System.out.println("Status Code is"+ statuscode);
		Assert.assertEquals(statuscode,200);
		
		
		
		//String statusLine=response.getStatusLine();
		//System.out.println("status line is "+statusLine);
		//Assert.assertEquals(statusLine, "HTTP/1.1 200 ok");
		
	}
	
}
