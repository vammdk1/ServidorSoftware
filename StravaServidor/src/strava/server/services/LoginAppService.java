package strava.server.services;

import strava.server.data.domain.Proveedor; 
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 		
		System.out.println(email+"||"+password);
		UsuarioStrava user = new UsuarioStrava("",email,"", 0, 0, 0, 0, Proveedor.LOCAL, password);
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);	
		user.setContrasenna(sha1);
		
		return BaseDatos.comprobarCuenta(user);
	}
	
	public User loginGoogleFacebook(String email,Proveedor GoogleOFacebook) {
		//TODO: Get User using DAO and check 		
		User user = new User("",email, "", 0, 0, 0, 0, GoogleOFacebook);
		//Generate the hash of the password
		
		return BaseDatos.comprobarCuenta(user);
	}
}