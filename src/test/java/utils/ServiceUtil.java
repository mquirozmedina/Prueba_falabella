package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.BaseRequest;

public class ServiceUtil {
	
	public static Response callService(BaseRequest baseRequest) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(baseRequest.getUrl() + baseRequest.getPath());
		builder.setContentType("application/json");
		RequestSpecification request = RestAssured.given().spec(builder.build());
		baseRequest.getQueryParams().forEach((k,v) -> request.queryParam(k, v));
		if(baseRequest.getJSON() != null)
			request.body(baseRequest.getJSON());
		request.log().all();
		Response response = null;
		switch(baseRequest.getMethod().toLowerCase()) {
			case "post":
				response = request.post();
				break;
			case "patch":
				response = request.patch();
				break;
			case "put":
				response = request.put();
				break;
			case "delete":
				response = request.delete();
				break;
			case "get":
				response = request.get();
				break;
			default: 
				System.out.println("Metodo no controlado: " + baseRequest.getMethod());
		}			
		
		System.out.println("Status code: " + response.getStatusCode());
		response.prettyPrint();
		
		return response;
	}

}
