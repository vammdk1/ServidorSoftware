package strava.client;

import java.util.List;

import strava.client.controller.LoginController;
import strava.client.controller.RegisterController;
import strava.client.controller.RetoController;
import strava.client.gui.VentanaCrearReto;
import strava.client.gui.VentanaLogin;
import strava.client.gui.VentanaRegistro;
import strava.client.gui.VentanaRegistro2;
import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		VentanaLogin ventanaLogin = new VentanaLogin(loginController);
		
		RegisterController registerController = new RegisterController(serviceLocator);
		VentanaRegistro ventanaRegistro = new VentanaRegistro(registerController);
		VentanaRegistro2 ventanaRegistro2 = new VentanaRegistro2(registerController);
		
		VentanaUsuario ventanaUsuario = new VentanaUsuario(loginController);
		
		RetoController retoController = new RetoController(serviceLocator);
		VentanaCrearReto ventanaCrearReto = new VentanaCrearReto(retoController);
		
		//LoginDialog loginDialog = new LoginDialog(loginController);		
		
		//Login
		//loginDialog.login();		
		//Get Categories
		//Logout
		//loginDialog.logout();
	}
}