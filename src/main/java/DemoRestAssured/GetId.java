package DemoRestAssured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetId {
	
	public static int my_id;
	

// getting id from json response.
	
@Test(priority =1) 
public void post_id()
{
	JSONObject request = new JSONObject();
	request.put("name", "Kushal");
	request.put("job", "QA");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	my_id =given().
		header("Content-Type","application/json").
			contentType("application/json").
			
		
	when().
		post("/users").jsonPath().getInt("id");  
	
	System.out.println(my_id);
		
	
	}

@Test(priority=2,dependsOnMethods = { "post_id" } )
public void Updateuser()
{
	JSONObject request = new JSONObject();
	request.put("name", "Kushal45");
	request.put("job", "QA1");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	given().
		header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		
	when().
		put("/users/"+my_id).
		
	then().
		log().
		all().
	
		//verify status code
		statusCode(200).
		
		
		
		//verify time 
		and().time(lessThan(5000L));
	}

}
