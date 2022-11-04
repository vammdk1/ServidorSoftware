package DatosUsuario;

import java.util.Date;

public class UsuarioNoStrava extends User{
	
	private	boolean GoogleFacebook=true;
	/**
	 * @param GoogleFacebookc True para google y False para Facebook
	 */
	public UsuarioNoStrava(String nombre, String email, Date fechaNac, float peso, int altura, int pulsoxMinuto,
			int pulsoReposo,boolean GoogleFacebook) {
		super(nombre, email, fechaNac, peso, altura, pulsoxMinuto, pulsoReposo);
		this.GoogleFacebook=GoogleFacebook;
		
	}
	public boolean isGoogleFacebook() {
		return GoogleFacebook;
	}
	public void setGoogleFacebook(boolean googleFacebook) {
		GoogleFacebook = googleFacebook;
	}

	
	

}
