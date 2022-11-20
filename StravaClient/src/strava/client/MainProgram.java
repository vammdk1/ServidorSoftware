package strava.client;

import java.util.List;

import strava.client.controller.LoginController;
import strava.client.controller.RegisterController;
import strava.client.controller.RetoController;
import strava.client.controller.RetosAceptadosController;
import strava.client.controller.RetosActivosController;
import strava.client.controller.SesionEntrenamientoController;
import strava.client.gui.VentanaCrearReto;
import strava.client.gui.VentanaCrearSesionEntrenamiento;
import strava.client.gui.VentanaLogin;
import strava.client.gui.VentanaRegistro;
import strava.client.gui.VentanaRegistro2;
import strava.client.gui.VentanaRetosAceptados;
import strava.client.gui.VentanaRetosActivos;
import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;
import strava.server.data.domain.UsuarioStrava;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		//UsuarioStrava user = new UsuarioStrava("prueba", "prueba@gmail.com", "01-01-0001", 0, 0, 0, 0, null, "prueba");
		
		
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
		
		registerController.register("prueba", "prueba@gmail.com", "01-01-0001", 0, 0, 0, 0, "prueba");
		
		RetoController retoController = new RetoController(serviceLocator);
		VentanaCrearReto ventanaCrearReto = new VentanaCrearReto(retoController);
		
		SesionEntrenamientoController sesionEntrenamientoController = new SesionEntrenamientoController(serviceLocator);
		VentanaCrearSesionEntrenamiento ventanaCrearSesionEntrenamiento = new VentanaCrearSesionEntrenamiento(sesionEntrenamientoController);
		
		
		RetosAceptadosController retosAceptadosController = new RetosAceptadosController(serviceLocator);
		VentanaRetosAceptados ventanaRetosAceptados = new VentanaRetosAceptados(retosAceptadosController);
		
		RetosActivosController retosActivosController = new RetosActivosController(serviceLocator);
		VentanaRetosActivos ventanaRetosActivos = new VentanaRetosActivos(retosActivosController);
		
		//LoginDialog loginDialog = new LoginDialog(loginController);		
		
		//Login
		//loginDialog.login();		
		//Get Categories
		//Logout
		//loginDialog.logout();
	}
}