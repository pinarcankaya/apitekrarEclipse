package pinar.apitekrar;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest05 {

	/*When I send a GET request to REST API URL 
	   https://restful-booker.herokuapp.com/booking/5  
	Then HTTP Status Code 200 olsun
	And Response content type “application/JSON” olsun
	And “firstname” “Jim” olsun
	And “totalprice” 602 olsun
	 And “checkin” “2015-06-12" olsun*/
	
	@Test
	public void get05() {
		Response response=given().
				when().
				get(" https://restful-booker.herokuapp.com/booking/5");
		
		response.prettyPrint();
		response.
		then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("firstname", Matchers.equalTo("Susan"),
			 "totalprice",Matchers.equalTo(712),
			  "bookingdates.checkin",Matchers.equalTo("2020-06-20"));
		
		
		
		
	}
}
