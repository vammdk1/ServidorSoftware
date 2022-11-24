package strava.server.services;

import strava.server.data.dto.UserDTO;

//TODO: Implement Singleton Pattern
public class LoginAppServiceGoogle {
		
	public boolean login(String email) {	
		System.out.println("Usuario Google:"+email);
		UserDTO user = new UserDTO();
		user.setEmail(email);
		//Generate the hash of the password
		
		return true;
	}
	
}