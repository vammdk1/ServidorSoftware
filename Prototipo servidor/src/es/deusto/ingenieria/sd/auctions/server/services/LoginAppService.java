package es.deusto.ingenieria.sd.auctions.server.services;

import DatosUsuario.User;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 		
		User user = new User("Thomas","thomas.e2001@gmail.com", "1/12/1999", 80, 180, 80, 160);		
		//user.setEmail("thomas.e2001@gmail.com");
		//user.setNickname("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
	}
}