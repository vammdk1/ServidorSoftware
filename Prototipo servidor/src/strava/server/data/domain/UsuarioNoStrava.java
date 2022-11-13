package strava.server.data.domain;

import java.util.Date;

public class UsuarioNoStrava extends User{
	
	private	boolean GoogleFacebook=true;
	/**
	 * @param GoogleFacebookc True para google y False para Facebook
	 */
	public UsuarioNoStrava(String nombre, String email, String fechaNac, float peso, int altura, int pulsoxMinuto,
			int pulsoReposo,String password,boolean GoogleFacebook) {
		super(nombre, email, fechaNac, peso, altura, pulsoxMinuto, pulsoReposo);
	
		this.GoogleFacebook=GoogleFacebook;
		
	}
	public boolean isGoogleFacebook() {
		return GoogleFacebook;
	}
	public void setGoogleFacebook(boolean googleFacebook) {
		this.GoogleFacebook = googleFacebook;
	}
	
	public boolean getGoogleFacebook() {
		return GoogleFacebook;
	}
	
	//TODO
	/**getContrasennaDeProovedor
	public boolean checkPasswordProovedor(String password) {
		return this.password.equals(password);
	}**/

	
	

}
