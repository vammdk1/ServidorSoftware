package strava.client;

import java.util.List;

import strava.client.controller.LoginController;
import strava.client.gui.VentanaLogin;
import strava.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		new VentanaLogin(serviceLocator);
		
		LoginController loginController = new LoginController(serviceLocator);
		//LoginDialog loginDialog = new LoginDialog(loginController);		
		
		//Login
		//loginDialog.login();		
		//Get Categories
		//Logout
		//loginDialog.logout();
	}
}