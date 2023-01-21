package strava.server.test;

import java.util.ArrayList;

import strava.server.data.dao.UserDAO;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.dto.ProveedorDTO;
import strava.server.data.dto.UserDTO;
import strava.server.remote.RemoteFacade;
import strava.server.services.BaseDatos;

public class LocalTest {
	
	public static void main(String[] args) {	
	RemoteFacade facade = null;
	ArrayList<Reto> lr1 = null;
	ArrayList<SesionEntrenamiento> ls1= null;
	UserDTO usuario1 = new UserDTO();
	//UsuarioStrava usuario2 = null;
	long token = 0l;
	long token2 = 02;
	long token3 = 03;
	
	
	try {
		facade = new RemoteFacade();
		System.out.println("/////////////////////////////////////////////////////////////////////////");
		usuario1.setEmail("Prueba");
		usuario1.setProveedor(ProveedorDTO.FACEBOOK);
		facade.registro(usuario1, "Prueba");
	} catch (Exception e) {
		System.out.println("\t# Error: " + e.getMessage());	
	}
	
	try {
		System.out.println("/////////////////////////////////////////////////////////////////////////");
		token=facade.InicioExterno("Prueba","Prueba","FACEBOOK");
		System.out.println(token);
	} catch (Exception e) {
		System.out.println("\t# Error: " + e.getMessage());	
	}
	/**
	//ver datos en el servidor
	try {
		BaseDatos.getDatos();
	} catch (Exception e) {
		System.out.println("\t# Error: " + e.getMessage());	
	}**/
	User usuarioDAO = new User("Alfonso", "alfonsoortega@gmail.com", "22/12/2001", 50, 175, 130, 100, Proveedor.LOCAL);
	UserDAO.getInstance().save(usuarioDAO);
	System.out.print(UserDAO.getInstance().find("Alfonso") + "\n");
	UserDAO.getInstance().delete(usuarioDAO);
	System.out.print("Usuario: " + UserDAO.getInstance().find("Alfonso") + "\n");
	
	System.exit(0);
	}
}
