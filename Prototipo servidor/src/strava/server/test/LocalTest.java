package strava.server.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioNoStrava;
import strava.server.data.domain.UsuarioStrava;
import strava.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		ArrayList<Reto> lr1 = null;
		ArrayList<SesionEntrenamiento> ls1= null;
		UsuarioStrava usuario1 = null;
		UsuarioStrava usuario2 = null;
		UsuarioNoStrava google = null;
		UsuarioNoStrava facebook = null;
		long token = 0l;
		long token2 = 02;
		long token3 = 03;
		long token4 = 04;
		
		try {
			facade = new RemoteFacade();
			usuario1 = new UsuarioStrava("victor", "victor@prueba.com", "01/12/1999", 70, 176, 25, 160, "$!9PhNz,");
			usuario2 = new UsuarioStrava("victor", "victor@prueba.com", "01/12/1999", 70, 176, 25, 160, "$!9PhNz,");
			//google = new UsuarioNoStrava("pepe", "pepe@prieba.com", "01/01/01", 99, 99, 99, 99, "123456789",true);
			//facebook =  new UsuarioNoStrava("luis", "luis@prieba.com", "01/01/01", 99, 99, 99, 99, "123456789",false);
			
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 

		//registro
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.registro("victor", "victor@prueba.com", "01/12/1999", 70, 176, 25, 160, "$!9PhNz,");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.registro("victor", "victor@prueba.com", "01/12/1999", 70, 176, 25, 160, "$!9PhNz,");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		/**
		try {
			//TODO cambiar registro por un registro especial para usuarios distintos a strava
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.registro("pepe", "pepe@prieba.com", "01/01/01", 99, 99, 99, 99, "123456789");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.registro("luis", "luis@prieba.com", "01/01/01", 99, 99, 99, 99, "123456789");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
	**/
		//login
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			token = facade.login(usuario1.getEmail(), usuario1.getContrasenna());	
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			token2 = facade.login(usuario2.getEmail(), usuario2.getContrasenna());	
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////");
			facade.logout(token);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////");
			facade.logout(token2);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		/**
		//loginNoStrava
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			token3 = facade.inicioGoogle("pepe@prieba.com");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			token4 = facade.inicioFacebook("luis@prieba.com");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		**/
		//crearReto
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
			Date fechaInicio = format.parse("01-12-2022");
			Date fechaFin = format.parse("01-12-2122");
			facade.crearReto(usuario1, new Reto("prueba", fechaInicio , fechaFin, 1000, 240, "Carrera a pie"));
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		//ver retos activos
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.verRetosActivos();
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		//ver retos aceptados por un usuario
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			System.out.println("Retos aceptados:"+facade.verRetosAceptados(usuario1).toString());
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		/**aceptar reto
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			//facade.reto
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}**/
		/**
		//sesionEntrenamiento
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
			Date fechaInicio = format.parse("01-12-2022");
			facade.crearSesionEntrenamiento(usuario1,new SesionEntrenamiento("prueba Entrenamiento", "ciclismo", 1000, fechaInicio, 0.5f));
			System.out.println(usuario1.getSesiones());
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}**/
		/**
		//logout NoStrava
		try {
			System.out.println("/////////////////////////////////////////");
			facade.logout(token3);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		try {
			System.out.println("/////////////////////////////////////////");
			facade.logout(token4);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}**/

		//Force exit to stop RMI Server
		System.exit(0);
	}
}