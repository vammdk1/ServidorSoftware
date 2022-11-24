package strava.server.test;

import java.util.ArrayList;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.dto.UserDTO;
import strava.server.remote.RemoteFacade;
import strava.server.services.BaseDatos;

public class LocalTest {
	
	public static void main(String[] args) {	
	RemoteFacade facade = null;
	ArrayList<Reto> lr1 = null;
	ArrayList<SesionEntrenamiento> ls1= null;
	UserDTO usuario1 = null;
	//UsuarioStrava usuario2 = null;
	long token = 0l;
	long token2 = 02;
	long token3 = 03;
	
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
	
	System.exit(0);
	}
}
