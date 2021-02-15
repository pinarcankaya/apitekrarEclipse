package pinar.apitekrar;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GetRequest01 {
	
//	@Test
//	public void getMethod01() {
//		 					  given(). 
//							  when().
//							  	  get("https://restful-booker.herokuapp.com/booking").
//							  then().
//							  	  assertThat().
//							  	  statusCode(200);
//							  	
	//}
	@Test
	public void getMethod02() {
		Response response= given().
						    accept("application/json").
						  when().
						    get("https://restful-booker.herokuapp.com/booking");
		response.prettyPrint();
		System.out.println(response.getContentType());
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeaders());
		System.out.println(response.statusCode());
		//System.out.println(response.getStatusLine());
		//assertEquals(200, response.statusCode()); 
		
		
		
		response.
		then().
		assertThat().
		statusCode(200).
		contentType("application/json");
		
						    
	}

	
	
	
	
	
}
