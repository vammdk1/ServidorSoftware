package strava.client.controller;

import java.rmi.RemoteException;

import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;

//This class implements Controller pattern.
public class LoginController {	
	
	private static LoginController instance = new LoginController();
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;
	//This attibute stores the token when login success
	private long token = -1; //-1 = login has not been done or fails

	private LoginController() {
		this.serviceLocator = ServiceLocator.getInstance();
	}
	
	public boolean login(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().login(email, password);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public boolean loginFacebook(String email, String password) {
		return false;
	}
	
	public boolean loginGoogle(String email, String password) {
		return false;
	}
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
			//VentanaUsuario.setUsuario(null);
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}

	public long getToken() {
		return token;
	}

	public static LoginController getInstance() {
		return instance;
	}
}