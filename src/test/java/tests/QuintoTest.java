package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import requests.QuintoTestRequest;
import utils.ServiceUtil;

public class QuintoTest {
	/***
	 * Este metodo es para el quinto test y consiste en obtener el perfil del registro de un cliente
	 * y validar los datos recibidos sean igual al registrado anteriormente.
	 * @author mauricio quiroz
	 * @param null
	 * @return void
	 */
	@Test
	public void quinto_test() {
		System.out.println("Quinto test");
		
		QuintoTestRequest request = new QuintoTestRequest("https://app.fakejson.com", "/q/8MGBgkxP", "get", "najUNRCsa5esJdvlYTtL6g");
		request.addQueryParams("token", "najUNRCsa5esJdvlYTtL6g");		
		Response response = ServiceUtil.callService(request);
				
		Assert.assertNotNull(response.getStatusCode(), "El status code no puede ser nullo");
		Assert.assertEquals(response.getStatusCode(), 200, "Fallo la validacion de status code");
		Assert.assertEquals(response.jsonPath().get("nombre"), "Mauricio" , "El nombre es distinto al que se envio al registrar");
		Assert.assertEquals(response.jsonPath().get("apellido"), "Quiroz" , "El apellido es distinto al que se envio al registrar");	
		Assert.assertEquals(response.jsonPath().get("correo"), "mquirozmedina@gmail.com" , "El correo es distinto al que se envio al registrar");
	}		

}
