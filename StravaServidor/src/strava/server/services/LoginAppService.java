package strava.server.services;

import strava.server.data.domain.Proveedor; 
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.sockets.EchoStrava;

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
	
	public boolean loginGoogleFacebook(String email,String password,Proveedor GoogleOFacebook) {
		//TODO comprobar en la base de datos que el usuario esté registrado
		User user = new User("",email, "", 0, 0, 0, 0, GoogleOFacebook);
		if(GoogleOFacebook.equals(Proveedor.GOOGLE )) {
			String[] args = {"127.0.0.2","8001",email,password};
			return EchoStrava.main(args);			
			
		}else {
			//TODO mandar a facebook
			return false;
		}
	

	}
}