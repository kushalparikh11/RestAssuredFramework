package DemoRestAssured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest {
	
	public static String myid;
	
	@Test
	public void CreateRequest()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Kushal");
		request.put("job", "QA");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			
		when().
			post("/users").
			
		then().
			log().
			all().
		
			//verify status code
			statusCode(201).
			
			
			
			//verify time 
			and().time(lessThan(5000L));
		
		

	}
}



