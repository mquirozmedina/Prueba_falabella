package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.CuartoTestRequest;
import utils.ServiceUtil;

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
	
		CuartoTestRequest request = new CuartoTestRequest("http://app.fakejson.com", "/q", "delete", "najUNRCsa5esJdvlYTtL6g");
		request.setCorreo("mauricio.quiroz@tsoftlatam.com");
		JSONObject payload = request.getJSON();
		
		Response response = ServiceUtil.callService(request);
		
		Assert.assertNotNull(response.getStatusCode(),"El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(),200,"Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("correo"), request.getCorreo(), "El correo es distinto al que se envio a eliminar");	
	}
	
}
