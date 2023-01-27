package DemoRestAssured;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetRequest {
	
	@Test
	public void getrequest()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void Getuser()
	{
		baseURI = "https://reqres.in/";
		
		given()
			.get("api/users?page=2").
		then().
			log().
			all().
			
			//verify status code
			statusCode(200).
			
			//verify body data
			body("data[2].id",Matchers.equalTo(9)).
			
			//verify time 
			
			and().time(lessThan(1000L));
			
	}

	
}


