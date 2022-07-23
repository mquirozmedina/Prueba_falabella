package requests;

import org.json.simple.JSONObject;

public class PrimerTestRequest extends BaseRequest {
	private String nombre;
	private String apellido;
	private String correo;
	
	public PrimerTestRequest(String url, String path, String method, String token) {
		super(url, path, method, token);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public JSONObject getJSON() {
		
		JSONObject payload = new JSONObject();
		JSONObject data = new JSONObject();
		payload.put("token", getToken());
		data.put("nombre", nombre);
		data.put("apellido", apellido);
		data.put("correo", correo);
		payload.put("data",data);
		return payload;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
