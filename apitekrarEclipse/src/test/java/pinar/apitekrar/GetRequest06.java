package pinar.apitekrar;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest06 extends TestBase{

	//TestBase class olusturup her testte kullanilan datalari TestBase class'a koyup 
		//tekrar tekrar ayni seyleri yazmaktan kurtuluruz
		
		/*When I send a GET request to REST API URL
			https://restful-booker.herokuapp.com/booking/5
		    Then HTTP Status Code should be 200
		    And response content type is “application/JSON”
		    And response body should be like;
		    {
			    “firstname”: “Sally”,
			    “lastname”: “Ericsson”,
			    “totalprice”: 111,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2017-05-23",
			        “checkout”: “2019-07-02"
			     }*/
	
	
	@Test
	public void get06() {
		Response response=given().
				spec(spec01).
				when().
				get("booking/5");
		response.prettyPrint();
		
		response.
		then().
		assertThat().
		statusCode(200).
		contentType(ContentType.JSON).
		body("firstname",equalTo("Sally"),
			"lastname",equalTo("Ericsson"),
			"totalprice",equalTo(111),
			"depositpaid",equalTo(false),
			"bookingdates.checkin",equalTo("2017-05-23"),
			"bookingdates.checkin",equalTo("2017-05-23")); //(import yerine static ve .* koyduk)
	}
	
	
	
	
	
}
