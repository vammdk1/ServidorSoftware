package strava.server.factory;

import strava.server.gateway.FacebookServiceGateway;
import strava.server.gateway.GoogleServiceGateway;
import strava.server.gateway.IServerGateway;

public class GatewayFactory {
	
	private static GatewayFactory instance; 
	
	private GatewayFactory() {
		
	}
	
	public void createExternalAccount(String proveedor, String email, String password) {
		if (proveedor.equals("FACEBOOK")) {
			System.out.println("Es usuario Facebook");
			FacebookServiceGateway.getInstance().facebookRegister(email, password);
		} 
		
		else if (proveedor.equals("GOOGLE")) {
			//TODO que pasa con esto ?
		} else {
			System.out.println("Esta intentando crear una cuenta en un proveedor no externo. Por favor, pruebe con otro proveedor.");
		}
	}
	
	public boolean loginExterno(String email, String password, String proveedor) {
		IServerGateway iServerGateway = null;
		if (proveedor.equals("FACEBOOK")) {
			iServerGateway = FacebookServiceGateway.getInstance();
		} else if (proveedor.equals("GOOGLE")) {
			iServerGateway = GoogleServiceGateway.getInstance();
		}
		
		return iServerGateway.iniciarSesion(email, password);
	}
	
	
	public static GatewayFactory getInstance() {
		if (instance == null) {
			instance = new GatewayFactory();
		}
		
		return instance;
	}

}