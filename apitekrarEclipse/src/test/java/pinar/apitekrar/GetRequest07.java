package pinar.apitekrar;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetRequest07 extends TestBase {

	//Among the data there are someones whose first name is “Susan”
	//firsname i susan olan biri var mi.id sini bulalim
	
	@Test
	public void get07() {
		Response response=given().
				spec(spec01).when().get("booking?firstname=Susan");
		response.prettyPrint();
		assertTrue(response.body().asString().contains("bookingid"));
	
	
	
	}
}
