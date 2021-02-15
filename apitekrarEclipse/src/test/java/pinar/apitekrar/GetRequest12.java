package pinar.apitekrar;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GetRequest12 extends TestBase{
	//GSON: GSON, 1-)JSON formatindaki datalari JAva Objectlerine donusturur.(De-Serialization)
			//			  2-)Java Objectlerini JSON formatindaki datalara donusturur.(Serialization)   ///hatirlamak adina= alt alta yazmayi seri olarak ddusunebilirz

			//NOT : GSON ile ayni isi yapan OBJECTMAPPER CLASS da var
	@Test
	public void get12() {
		Response response=given().spec(spec03).when().get();
		response.prettyPrint();
		
		List<Map<String,Object>> mapList=response.as(ArrayList.class);
		System.out.println(mapList);
		System.out.println(mapList.get(1));
		//200 tane id oldugunu 'verify' ediniz
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(mapList.size(), 200,"200 kisi yoksa yaz");
	//	softAssert.assertEquals(mapList.size()==200,"200 kisi yoksa belirt");
		
		//121.elemanin completed degerinin true oldugunu verify ediniz//index olduguna dikkat
		softAssert.assertEquals(mapList.get(120).get("completed"),true,"yanlissa konsolda yaz");
		
		//Sondan bir onceki elemanin title'inin 'numquam repellendus a magnam' oldugunu verify ediniz
		softAssert.assertEquals((mapList.get(mapList.size()-2).get("title")),"numquam repellendus a magnam");
		
		softAssert.assertAll();
		
		
		
		
		
	}

}
