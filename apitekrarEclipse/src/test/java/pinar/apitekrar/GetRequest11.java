package pinar.apitekrar;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.response.Response;

public class GetRequest11 extends TestBase {

	//GSON: GSON, 1-)JSON formatindaki datalari JAva Objectlerine donusturur.(De-Serialization)
		//			  2-)Java Objectlerini JSON formatindaki datalara donusturur.(Serialization)   ///hatirlamak adina= alt alta yazmayi seri olarak ddusunebilirz

		//NOT : GSON ile ayni isi yapan OBJECTMAPPER CLASS da var
	@Test
	public void get11() {
		Response response=given().spec(spec03).when().get("/2");
		response.prettyPrint();
		
		HashMap<String,Object> map=response.as(HashMap.class);  //De-Srialization
		System.out.println(map);
		System.out.println(map.keySet()); //[id, completed, title, userId]
		System.out.println(map.values()); //[2.0, false, quis ut nam facilis et officia qui, 1.0]
		
		//completed key'in degerinin false oldugunu 'verify' ediniz
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(map.get("completed"),false,"istenilen mesaj yazilir");
		
		//userid id ve title degerlerini verifiy ediniz
		softAssert.assertEquals(map.get("userId"),1.0);
		softAssert.assertEquals(map.get("title"), "quis ut nam facilis et officia qui");
		softAssert.assertEquals(map.get("id"), 2.0);
		softAssert.assertAll();
		
	}
}
