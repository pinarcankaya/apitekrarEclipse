package pinar.apitekrar;


import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	protected RequestSpecification spec01;
	protected  RequestSpecification spec02;
	protected  RequestSpecification spec03;
	
	@Before
	public void setup01() {
		spec01 = new RequestSpecBuilder().
				 setBaseUri("https://restful-booker.herokuapp.com").
				 build();
		
	}
	@Before
	public void setUp02() {
		spec02=new RequestSpecBuilder().
				 setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
				 build();
		
		
	
	}
	@Before
	public void setup03() {
		spec03 = new RequestSpecBuilder().
				 setBaseUri("https://jsonplaceholder.typicode.com/todos").
				 build();
		
	}
	
	//return type response
	protected JSONObject jsonBookingDatesBody;
	protected JSONObject jsonRequestBody;
	
	protected Response createRequestBodyByJsonObjectClass() {
		
		jsonBookingDatesBody=new JSONObject();
		jsonBookingDatesBody.put("checkin","2020-05-02");///booking dates icindeki checkin icin obje olsuturudk
		jsonBookingDatesBody.put("checkout", "2020-05-05");
		///json objectleri key value olarak olusur bir ustte json datalarin icinde de json datalar var
		
		
		jsonRequestBody=new JSONObject();
		jsonRequestBody.put("firstname", "Pinar");
		jsonRequestBody.put("lastname", "Cankaya");
		jsonRequestBody.put("totalprice",123);
		jsonRequestBody.put("depositpaid",true);
		jsonRequestBody.put("bookingdates",jsonBookingDatesBody); //usttekei olusturdugumuz objeye esit
		jsonRequestBody.put("additionalneeds","Wifi");					//booking dates'in value'su bir jsondir bu yuzden karsisina bunu yaziyorz
		
		Response response=given().
				contentType(ContentType.JSON).
				spec(spec01).
				auth().
				basic("admin","password123").
				body(jsonRequestBody.toString()).///json tipinde stringe cevirdik
				when().post("/booking");
		return response;
	}
	
	protected Map<String, Object> requestBodyMap;
	protected Map<String, String> bookingDatesMap;
	
protected Response createRequestBodyByMap() {
		
		bookingDatesMap = new HashMap<>();
		bookingDatesMap.put("checkin", "2020-05-02");
		bookingDatesMap.put("checkout", "2020-05-05");
		
		requestBodyMap = new HashMap<>();
		requestBodyMap.put("firstname", "Pinar");
		requestBodyMap.put("lastname", "Cankaya");
		requestBodyMap.put("totalprice", 123);
		requestBodyMap.put("depositpaid", true);
		requestBodyMap.put("bookingdates", bookingDatesMap);
		requestBodyMap.put("additionalneeds", "Wifi");
		
		Response response = given(). 
	                           contentType(ContentType.JSON). // or "application/json"
	                           spec(spec01).
	                           auth().
	                           basic("admin","password123").
	                           body(requestBodyMap).
	                        when(). 
	                           post("/booking");
		
		return response;

}
	
	
	
	
	
	
	
	
}