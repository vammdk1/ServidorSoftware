package es.deusto.ingenieria.sd.auctions.server.test;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
			//Get Categories
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
			
		
		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login("thomas.e2001@gmail.com", sha1);			
			//Make a bid
			//Logout
			facade.logout(token);
			//Get articles again to check if the bid has been registered
			
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
		
	}
}