package pinar.apitekrar;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest09 extends TestBase{

	@Test
	public void get09() {
		
		Response response=given().spec(spec02).when().get();
		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		
		//tum employee isimlerini yazdir
		//System.out.println(json.getList("data.employee_name"));
		
		//ikinci iscinin isminin Garret Winters oldugunu "verify "ediniz
		SoftAssert softAssert=new SoftAssert();
		//softAssert.assertEquals(json.getString("data[1].employee_name"), "Garrett Winters","isci ismi yanlis");

		//iscilerin arasinda Herrod Chandler'in var oldugunu "verify" ediniz
		//softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"));
		
		//24 tane isci oldugunu verify ediniz
		softAssert.assertEquals(json.getList("data.id").size(), 24,"24 isci yok");
		
		//7.iscinin maasinin 137500 oldugunu verify ediniz
		
		softAssert.assertAll();
	}
}
