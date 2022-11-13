package strava.server.data.domain;

import java.io.Serializable;
import java.util.Date;

public class UsuarioStrava extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contrasenna;

	public UsuarioStrava(String nombre, String email, String fechaNac, float peso, int altura, int pulsoxMinuto,
			int pulsoReposo,String contrasenna) {
		super(nombre, email, fechaNac, peso, altura, pulsoxMinuto, pulsoReposo);
		this.contrasenna=contrasenna;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	
	public boolean checkPassword(String password) {
		return this.contrasenna.equals(password);
	}

}
