package requests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class BaseRequest {
	
	private String url;
	private String path;
	private String method;
	private String token;
	private Map<String, String> queryParams;
	
	public BaseRequest(String url, String path, String method, String token) {
		super();
		this.url = url;
		this.path = path;
		this.method = method;
		this.token = token;
		queryParams= new HashMap<>();
	}
	
	public void addQueryParams(String nombre, String valor) {
		queryParams.put(nombre, valor);		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public JSONObject getJSON() {	
		return null;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}
}
