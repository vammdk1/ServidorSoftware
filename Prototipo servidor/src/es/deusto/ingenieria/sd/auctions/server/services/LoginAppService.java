package es.deusto.ingenieria.sd.auctions.server.services;

import DatosUsuario.User;
import DatosUsuario.UsuarioStrava;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public User login(String email, String password) {
		//TODO: En este lugar se comprueban los datos para iniciar seción , usar el hashMapp para confirmar los datos	
		UsuarioStrava user = new UsuarioStrava(null, null, null, 0, 0, 0, 0, null);		
		user.setEmail("Victor.e2001@gmail.com");
		user.setNombre("Victor");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setContrasenna(sha1);
		
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
	}
}