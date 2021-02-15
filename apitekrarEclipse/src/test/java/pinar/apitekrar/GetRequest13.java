package pinar.apitekrar;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest13 extends TestBase{


	//GSON: GSON, 1-)JSON formatindaki datalari JAva Objectlerine donusturur.(De-Serialization)
			//			  2-)Java Objectlerini JSON formatindaki datalara donusturur.(Serialization)   ///hatirlamak adina= alt alta yazmayi seri olarak ddusunebilirz

			//NOT : GSON ile ayni isi yapan OBJECTMAPPER CLASS da var
	
	@Test
	public void get13() {
		Response response=given().
				spec(spec02).
				when().
				get();  //bunu API dev'ler belirliyor neye gore sececegimizi/ona gore icinden aratiyorz

		response.prettyPrint();
		//ilk 5 ismin Tiger Nixon,Garrett Winters,Ashton Cox,Cedric Kelly,Airi Satou oldugunu dogrulayiniz
		JsonPath json=response.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		///1.yol   //tavsiye edilmez
		softAssert.assertEquals(json.getString("data[0].employee_name"), "Tiger Nixon");
		softAssert.assertEquals(json.getString("data[1].employee_name"), "Garrett Winters");
		softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
		softAssert.assertEquals(json.getString("data[3].employee_name"),"Cedric Kelly");
		softAssert.assertEquals(json.getString("data[4].employee_name"),"Airi Satou");
		
		
		//2.yol--kullanilabilir
		List<String> isimListesi=new ArrayList<>();
		isimListesi.add("Tiger Nixon");
		isimListesi.add("Garrett Winters");
		isimListesi.add("Ashton Cox");
		isimListesi.add("Cedric Kelly");
		isimListesi.add("Airi Satou");
		
		
			for(int i=0; i<isimListesi.size(); i++) {
		softAssert.assertEquals(json.getString("data[" + i +"].employee_name"), isimListesi.get(i));
			
		}
			//3.yol--en iyisi
			List<Map>  actualList=json.getList("data");
			System.out.println(actualList);
		
			Map<Integer,String> expectedMap=new HashMap<>();
			expectedMap.put(0, "Tiger Nixon");
			expectedMap.put(1, "Garrett Winters");
			expectedMap.put(2, "Ashton Cox");
			expectedMap.put(3, "Cedric Kelly");
			expectedMap.put(4, "Airi Satou");
			
			for (int i = 0; i < expectedMap.size(); i++) {
				softAssert.assertEquals(actualList.get(i).get("employee_name"), expectedMap.get(i));
			}
			softAssert.assertAll();
			
	}
}
