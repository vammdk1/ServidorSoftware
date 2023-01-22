package strava.server.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class UsuarioStrava extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6746389110586704136L;
	/**
	 * 
	 */
	private String contrasenna;

	public UsuarioStrava(String nombre, String email, String fechaNac, float peso, int altura, int pulsoxMinuto,
			int pulsoReposo, Proveedor proveedor, String contrasenna) {
		super(nombre, email, fechaNac, peso, altura, pulsoxMinuto, pulsoReposo, proveedor);
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
