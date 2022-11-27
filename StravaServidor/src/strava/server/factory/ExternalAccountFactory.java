package strava.server.factory;

import strava.server.data.domain.Proveedor;
import strava.server.gateway.FacebookServiceGateway;

public class ExternalAccountFactory {
	
	private static ExternalAccountFactory instance; 
	
	private ExternalAccountFactory() {
		
	}
	
	public void createExternalAccount(Proveedor proveedor, String email, String password) {
		if (proveedor == Proveedor.FACEBOOK) {
			FacebookServiceGateway.getInstance().facebookRegister(email, password);
		} 
		
		else if (proveedor == Proveedor.GOOGLE) {
			
		} else {
			System.out.println("Esta intentando crear una cuenta en un proveedor no externo. Por favor, pruebe con otro proveedor.");
		}
	}
	
	public static ExternalAccountFactory getInstance() {
		if (instance == null) {
			instance = new ExternalAccountFactory();
		}
		
		return instance;
	}
}