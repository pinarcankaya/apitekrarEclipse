package pinar.apitekrar;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest01 extends TestBase{

	@Test
	public void post01() {
		String jsonRequestBody = "{\n" + 
				"\"firstname\": \"Pinar\",\n" + 
				"\"lastname\": \"Cankaya\",\n" + 
				"\"totalprice\": 123,\n" + 
				"\"depositpaid\": true,\n" + 
				"\"bookingdates\": {\n" + 
				"\"checkin\": \"2020-05-02\",\n" + 
				"\"checkout\": \"2020-05-05\"\n" + 
				"},\n" + 
				"\"additionalneeds\": \"Wifi\"\n" + 
				"}";
		Response response=given().
				contentType(ContentType.JSON).//json icerikli olsun diyoruz
				spec(spec01).
				auth().
				basic("admin", "password123"). //kullanici bilgisini yaziyorz
				body(jsonRequestBody).
				when().
				post("/booking");  //testbase'de nerde bittigine dikkat
		
		
		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		///1.yol--datalarin string kalmasi tavsiye edilmez
		softAssert.assertEquals(json.get("booking.firstname"), "Pinar");
		
		
		
		softAssert.assertAll();
		
		
		
	}
}
