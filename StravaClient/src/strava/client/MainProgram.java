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
import strava.server.data.dto.ProveedorDTO;

public class MainProgram {

	public static void main(String[] args) {	
		//UsuarioStrava user = new UsuarioStrava("prueba", "prueba@gmail.com", "01-01-0001", 0, 0, 0, 0, null, "prueba");
		
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		ServiceLocator.getInstance().setService(args[0], args[1], args[2]);
		
		VentanaLogin ventanaLogin = new VentanaLogin(LoginController.getInstance());
		
		VentanaRegistro ventanaRegistro = new VentanaRegistro(RegisterController.getInstance());
		VentanaRegistro2 ventanaRegistro2 = new VentanaRegistro2(RegisterController.getInstance());
		
		VentanaUsuario ventanaUsuario = new VentanaUsuario(LoginController.getInstance(), SesionEntrenamientoController.getInstance());
		
		RegisterController.getInstance().register("prueba", "prueba@gmail.com", "01-01-0001", 0, 0, 0, 0, "prueba", ProveedorDTO.LOCAL);
		
		VentanaCrearReto ventanaCrearReto = new VentanaCrearReto(RetoController.getInstance());
		
		
		VentanaCrearSesionEntrenamiento ventanaCrearSesionEntrenamiento = new VentanaCrearSesionEntrenamiento(SesionEntrenamientoController.getInstance());
		
		
		VentanaRetosAceptados ventanaRetosAceptados = new VentanaRetosAceptados(RetosAceptadosController.getInstance());
		
		VentanaRetosActivos ventanaRetosActivos = new VentanaRetosActivos(RetosActivosController.getInstance());
		//LoginDialog loginDialog = new LoginDialog(loginController);		
		
		//Login
		//loginDialog.login();		
		//Get Categories
		//Logout
		//loginDialog.logout();
	}
}