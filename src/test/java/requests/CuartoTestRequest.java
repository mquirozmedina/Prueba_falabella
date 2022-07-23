package requests;

import org.json.simple.JSONObject;

public class CuartoTestRequest extends BaseRequest{
	private String correo;

	public CuartoTestRequest(String url, String path, String method, String token) {
		super(url, path, method, token);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public JSONObject getJSON() {
		
		JSONObject payload = new JSONObject();
		JSONObject data = new JSONObject();
		payload.put("token", getToken());
		if(correo != null) data.put("correo", correo);
		payload.put("data",data);
		return payload;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
