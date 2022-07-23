package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TercerTest {

	
	/***
	 * Este metodo es para el tercer test y consiste en actualizar el registro de un cliente con PUT
	 * @author mauricio quiroz
	 * @param null
	 * @return void
	 */
	@Test
	public void tercer_test() {
		System.out.println("Tercer test");
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://app.fakejson.com/q");
		builder.setContentType("application/json");
		
		RequestSpecification request = RestAssured.given().spec(builder.build());
		JSONObject payload = new JSONObject();
		JSONObject data = new JSONObject();
		payload.put("token", "najUNRCsa5esJdvlYTtL6g");
		data.put("nombre", "alejandro");
		data.put("apellido", "quiroz");
		data.put("correo", "mauricio.quiroz@tsoflatam.com");
		payload.put("data",data);
		request.body(payload);
		Response response = request.put();
		
		System.out.println("Status code: " + response.getStatusCode());
		response.prettyPrint();
		
		Assert.assertNotNull(response.getStatusCode(),"El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(),200,"Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("nombre"),data.get("nombre"),"El nombre es distinto al que se mando a actualizar");
		Assert.assertEquals(response.jsonPath().get("apellido"),data.get("apellido"),"El apellido es distinto al que se mando a actualizar");	
		Assert.assertEquals(response.jsonPath().get("correo"),data.get("correo"),"El correo es distinto al que se mando a actualizar");	
	}
}
