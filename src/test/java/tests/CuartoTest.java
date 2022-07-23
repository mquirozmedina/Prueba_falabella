package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CuartoTest {

	/***
	 * Este metodo es para el cuarto test y consiste en eliminar el registro de un cliente
	 * @author mauricio quiroz
	 * @param null
	 * @return void
	 */
	@Test
	public void cuarto_test() {
		System.out.println("Cuarto test");
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://app.fakejson.com/q");
		builder.setContentType("application/json");
		
		RequestSpecification request = RestAssured.given().spec(builder.build());
		JSONObject payload = new JSONObject();
		JSONObject data = new JSONObject();
		payload.put("token", "najUNRCsa5esJdvlYTtL6g");
		data.put("correo", "mauricio.quiroz@tsoflatam.com");
		payload.put("data",data);
		request.body(payload);
		Response response = request.delete();
		
		System.out.println("Status code: " + response.getStatusCode());
		response.prettyPrint();
		
		Assert.assertNotNull(response.getStatusCode(),"El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(),200,"Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("correo"),data.get("correo"),"El correo es distinto al que se envio a eliminar");	
	}
	
}
