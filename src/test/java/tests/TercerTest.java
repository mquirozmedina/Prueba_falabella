package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.PrimerTestRequest;
import requests.TercerTestRequest;
import utils.ServiceUtil;

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
	
		TercerTestRequest request = new TercerTestRequest("http://app.fakejson.com", "/q", "put", "najUNRCsa5esJdvlYTtL6g");
		request.setNombre("Mauricio");
		request.setApellido("Quiroz");
		request.setCorreo("mauricio.quiroz@tsoftlatam.com");
		JSONObject payload = request.getJSON();
		
		Response response = ServiceUtil.callService(request);
		
		Assert.assertNotNull(response.getStatusCode(),"El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(),200,"Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("nombre"), request.getNombre(), "El nombre es distinto al que se mando a actualizar");
		Assert.assertEquals(response.jsonPath().get("apellido"), request.getApellido(), "El apellido es distinto al que se mando a actualizar");	
		Assert.assertEquals(response.jsonPath().get("correo"),request.getCorreo(), "El correo es distinto al que se mando a actualizar");	
	}
}
