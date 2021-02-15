package pinar.apitekrar;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.util.Collections;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest10 extends TestBase{

	/*When I send GET Request to URL
	 http://dummy.restapiexample.com/api/v1/employees
	 Then
	  Status code is 200
	  1)10'dan buyuk tum id’leri console’a yazdir
	  10'dan buyuk 14 tane id oldugunu verify et
	 
	// 2)30'dan kucuk tum yaslari console’a yazdir
	  30 dan kucuk en buyuk yasin 23 oldugunu verify et
	  3)Maasi 350000'den cok olan iscilerin isimlerini console’a yazdir
	  Charde Marshall’in maasinin 350000'den buyuk oldugunu verify et  */

	
	@Test
	public void get10() {
		Response response=given().
				spec(spec02).
				when().
				get();
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
		
		JsonPath json=response.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		  /*1)10'dan buyuk tum id’leri console’a yazdir
		  10'dan buyuk 14 tane id oldugunu verify et*/
		
		List<String> idList=json.getList("data.findAll{Integer.valueOf(it.id)>10}");
				//filtreleme yapmak icin bu sart ezberle=//for ve if ile de olur ama bu kullnilmali
				//tamamini bul su sarti sagliyorsa diyoruz yani id>10 olanlari
				//id string oldugu icin de integer e cevirdk
		
		System.out.println(idList);
		softAssert.assertEquals(idList.size(), 14);  ///10 dan buyuk id leri yukarda bulmustuk.(idList)
		softAssert.assertAll();
		
		/*2)30'dan kucuk tum yaslari console’a yazdir
		  30 dan kucuk en buyuk yasin 23 oldugunu verify et */
		List<String> ageList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		Collections.sort(ageList);
		softAssert.assertTrue((ageList.get(ageList.size()-1).equals("23")),"30'dan kucuk en buyuk yas 23 degil");
		
		// 3)Maasi 350000'den cok olan iscilerin isimlerini console’a yazdir
		
		List<String> maasList=json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
		System.out.println(maasList);
		
		// Charde Marshall’in maasinin 350000'den buyuk oldugunu verify et 
		softAssert.assertTrue(maasList.contains("Charde Marshall"));
		//softAssert.assertTrue(json.getList("data.employee_name").contains("Charde Marshall"));
		
		
		softAssert.assertAll();
		
		
	}
	
	
	
}
