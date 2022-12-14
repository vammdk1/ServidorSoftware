package strava.server.gateway;

import java.rmi.Naming;

import facebook.remote.IFacebookLogin;

public class FacebookServiceGateway implements IServerGateway {
	
	private static FacebookServiceGateway instance;
	private IFacebookLogin facebookLoginService;
	
	private FacebookServiceGateway() { //Implementar la interfaz en lugar de guardarla 
		try {		
			String URL = "//127.0.0.1:1099/FacebookLogin";
			this.facebookLoginService = (IFacebookLogin) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote service: " + ex);
		}
	}
	
	public static FacebookServiceGateway getInstance() {
		if(instance == null) {
			instance = new FacebookServiceGateway();
		}
		
		return instance;
	}
	
	public boolean iniciarSesion(String user, String password) {
		return FacebookLogin(user, password);
	}
	
	public boolean FacebookLogin(String user, String password) {
		System.out.println("   - Validating user from Facebook Service Gateway");
		
		try {
			return this.facebookLoginService.facebookLogin(user, password);
		} catch (Exception ex) {
			System.out.println("   $ Error validating user: " + ex.getMessage());
			return false;
		}
	}

	public void facebookRegister(String user, String password) {
		try {
			this.facebookLoginService.facebookRegister(user, password); 
		} catch (Exception ex) {
			System.out.println("   $ Error creating user: " + ex.getMessage());
		}
	}
}
