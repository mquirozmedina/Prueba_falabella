package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.SegundoTestRequest;
import utils.ServiceUtil;

public class SegundoTest {

	/***
	 * Este metodo es para el segundo test y consiste en probar la actualizacion de un cliente con PATCH
	 * @author mauricio quiroz
	 * @param null
	 * @return void
	 */
	@Test
	public void segundo_test() {
		System.out.println("Segundo test");
		
		
		SegundoTestRequest request = new SegundoTestRequest("http://app.fakejson.com", "/q", "patch", "najUNRCsa5esJdvlYTtL6g");
		request.setCorreo("mauricio.quiroz@tsoftlatam.com");
		JSONObject payload = request.getJSON();
		
		Response response = ServiceUtil.callService(request);
		
		Assert.assertNotNull(response.getStatusCode(), "El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(),200, "Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("correo"), request.getCorreo(), "El correo es distinto al que se envio a actualizar");	
	}
	
}
