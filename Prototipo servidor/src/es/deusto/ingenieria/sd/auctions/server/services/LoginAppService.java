package es.deusto.ingenieria.sd.auctions.server.services;

import DatosUsuario.User;
import DatosUsuario.UsuarioStrava;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 		
		UsuarioStrava user = new UsuarioStrava("Thomas","thomas.e2001@gmail.com", "1/12/1999", 80, 180, 80, 160,null);		
		//user.setEmail("thomas.e2001@gmail.com");
		//user.setNickname("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setContrasenna(sha1);
		
		//TODO Reparar comprobado de contrasenna 
		if (user.getEmail().equals(email) /**&& user.checkPassword(password)**/) {		
			return user;
		} else {
			return null;
		}
	}
}