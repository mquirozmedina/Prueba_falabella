package requests;

import org.json.simple.JSONObject;

public class BaseRequest {
	
	private String url;
	private String path;
	private String method;
	private String token;
	
	public BaseRequest(String url, String path, String method, String token) {
		super();
		this.url = url;
		this.path = path;
		this.method = method;
		this.token = token;
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
}
