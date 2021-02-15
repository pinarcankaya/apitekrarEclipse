package pinar.apitekrar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetRequest02 {

	/*
	 Positive Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking 
	 and()  Accept Type'i "application/json" dir.
	 then() status code 200'dur 
	 and()  content type  "application/json" dir.        
	*/
	@Test
	public void getMethod03() {
		Response response=given().
				accept("application/json").
				get("https://restful-booker.herokuapp.com/booking");
		
		response.prettyPrint();
		
		response.
		then().
		assertThat().
		statusCode(200).
		contentType("application/json");
	}
	/*
	 Negative Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking/1001 
	 and()  Accept Type'i "application/json" dir.
	 then() status code 404'dur.    
	 */
	@Test
	public void getMethod04() {
		Response response=given().
				accept("application/json").
				get("https://restful-booker.herokuapp.com/booking/1001");
		response.prettyPrint();
		response.then().assertThat().statusCode(404);
	}
	/*
	 Negative Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking/1001 
	 then() status code 404'dur
	 and()  Response body'de "Not Found" var  
	 and()  Response body'de "Suleyman" yok
	 */
	
	@Test
	public void getMethod05() {
		Response response=given().
				get(" https://restful-booker.herokuapp.com/booking/1001 ");
		response.prettyPrint();
		assertEquals(404,response.getStatusCode());
		assertTrue(response.asString().contains("Not Found"));
		assertFalse(response.asString().contains("Pinar"));
	}
	
	
	
	
	
	
}
