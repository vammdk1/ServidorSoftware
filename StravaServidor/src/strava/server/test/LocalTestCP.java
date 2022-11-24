package strava.server.test;

import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import strava.server.data.domain.Deportes;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.data.dto.UserDTO;
import strava.server.remote.RemoteFacade;
import strava.server.services.BaseDatos;

public class LocalTestCP {

	public static void main(String[] args) {	
		/**
		RemoteFacade facade = null;
		ArrayList<Reto> lr1 = null;
		ArrayList<SesionEntrenamiento> ls1= null;
		UserDTO usuario1 = null;
		//UsuarioStrava usuario2 = null;
		long token = 0l;
		long token2 = 02;
		long token3 = 03;
		long token4 = 04;
		
		try {
			facade = new RemoteFacade();
			//usuario1 = new UsuarioStrava("victor", "victor@prueba.com", "01/12/1999", 70, 176, 25, 160, Proveedor.LOCAL, "$!9PhNz,");
			usuario1 = new UserDTO();
			usuario1.setNombre("victor");usuario1.setAltura(100);usuario1.setEmail("a@");usuario1.setPeso(10);
			usuario1.setFechancto("01");usuario1.setFrecuenciacardmax(0);usuario1.setFrecuenciacardreposo(0);
			
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		//registro
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			facade.registro(usuario1,"123456");
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		
		//ver datos en el servidor
		try {
			BaseDatos.getDatos();
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		
		*/
	
		//login
		/**
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
		}**/
		
		
		//loginNoStrava
		
		//crearReto
		
		//ver retos activos
		
		//ver retos aceptados por un usuario
		
		/**aceptar reto
		try {
			System.out.println("/////////////////////////////////////////////////////////////////////////");
			//facade.reto
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}
		
		//sesionEntrenamiento
		
		
		//logout NoStrava
		
		
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
		**/
		//Force exit to stop RMI Server
		System.exit(0);
	}
}