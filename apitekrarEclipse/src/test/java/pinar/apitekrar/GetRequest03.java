package pinar.apitekrar;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetRequest03 {

	/*
	 Positive Scenario:
	 When Asagidaki Endpoint'e bir GET request yolladim 
	 https://restful-booker.herokuapp.com/booking/7   
   And Accept type “application/json” dir
   Then 
   HTTP Status Code 200
   And Response format "application/json"
   And firstname "Sally"
   And lastname "Jackson"
   And checkin date "2017-04-19"
   And checkout date "2020-03-22"
	*/
	
	@Test 
	public void get01() {
		Response response=given().
				accept("application/json").
				when().
				get("https://restful-booker.herokuapp.com/booking/7");
		
		response.prettyPrint();
		response.
		then().
		assertThat().
		statusCode(200).
		contentType("application/json").
		body("firstname",Matchers.equalTo("Jim"),
			 "lastname",Matchers.equalTo("Wilson"),
			  "bookingdates.checkin",Matchers.equalTo("2018-10-26"),
			  "bookingdates.checkout",Matchers.equalTo("2019-03-08"),
			  "totalprice",Matchers.equalTo(417),
			  "depositpaid",Matchers.equalTo(false));
	}
	
	
	
	
	
	
	
	
	
	
}
