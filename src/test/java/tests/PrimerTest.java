package tests;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.PrimerTestRequest;
import utils.ServiceUtil;

public class PrimerTest {
	
	/***
	 * Este metodo es para el primer test y consiste en probar un registro de un cliente
	 * y validar que se haya registrado correctamente
	 * @author mauricio quiroz
	 * @param null
	 * @return void
	 */
	@Test
	public void primer_test() {
		System.out.println("Primer test");
		
		PrimerTestRequest request = new PrimerTestRequest("http://app.fakejson.com", "/q", "post", "najUNRCsa5esJdvlYTtL6g");
		request.setNombre("Mauricio");
		request.setApellido("Quiroz");
		request.setCorreo("mauricio.quiroz@tsoftlatam.com");
		JSONObject payload = request.getJSON();
		
		Response response = ServiceUtil.callService(request);
				
		Assert.assertNotNull(response.getStatusCode(), "El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(), 200, "Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("nombre"), request.getNombre(), "El nombre es distinto al que se envio al registrar");
		Assert.assertEquals(response.jsonPath().get("apellido"), request.getApellido(), "El apellido es distinto al que se envio al registrar");	
		Assert.assertEquals(response.jsonPath().get("correo"), request.getCorreo(), "El correo es distinto al que se envio al registrar");
	}			
	
}

