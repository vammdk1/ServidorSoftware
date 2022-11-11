package DatosUsuario;

import java.util.Date;

public class UsuarioStrava extends User{
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
	

}
