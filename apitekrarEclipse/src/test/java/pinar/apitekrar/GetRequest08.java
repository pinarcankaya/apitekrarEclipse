package pinar.apitekrar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest08  extends TestBase{

	@Test
	public void get08() {
		spec01.pathParam("bookingid",3);
		Response response=given().   
				spec(spec01).when().get("booking/{bookingid}");
		response.prettyPrint();
		
		//response tum body i aliyordu status code,content type vs.body kullanarak getiriyordk
		//json objesi ile body kullnamadan sadece istedigimiz datalari getiriyoruz
		//key yazarak value'lara ulasabiliyorz
		JsonPath json=response.jsonPath(); 
//		System.out.println(json.getString("firstname"));
//		assertEquals("firstname istenilen gibi degil","Jim",json.getString("firstname"));
//		System.out.println(json.getString("lastname"));
//		assertEquals("lastname istenilen gibi degil", "Jones", json.getString("lastname"));
//		System.out.println(json.getInt("totalprice"));
//		assertEquals("total price istenilen gibi degil", 998, json.getInt("totalprice"));
		System.out.println(json.getBoolean("depositpaid"));
		assertEquals("depositpaid istenilen gibi degil", true, json.getBoolean("depositpaid"));
		System.out.println(json.getString("bookingdates.checkin"));
		assertEquals("checkin date istenilen gibi degil", "2018-12-05", json.getString("bookingdates.checkin"));
		System.out.println(json.getString("bookingdates.checkout"));
		assertEquals("checkout date istenilen gibi degil", "2018-10-05", json.getString("bookingdates.checkout"));
	}
}
