package strava.server.test;

import java.util.ArrayList;
import java.util.Date;

import strava.server.data.dao.RetoDAO;
import strava.server.data.dao.SesionEntrenamientoDAO;
import strava.server.data.dao.UserDAO;
import strava.server.data.dao.UsuarioStravaDAO;
import strava.server.data.domain.Deportes;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
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
	User usuarioDAO = new UsuarioStrava("Alfonso", "alfonsoortega@gmail.com", "22/12/2001", 50, 175, 130, 100, Proveedor.LOCAL, "1234");
	Reto retoDAO = new Reto("Correr un poco", new Date(), new Date(), 10, 0, Deportes.RUNNING);
	SesionEntrenamiento sesionEntrenamientoDAO = new SesionEntrenamiento("Cumbia mientras corro", Deportes.RUNNING, 10, new Date(), 60);
	RetoDAO.getInstance().save(retoDAO);
	SesionEntrenamientoDAO.getInstance().save(sesionEntrenamientoDAO);
	usuarioDAO.anadirReto(retoDAO);
	usuarioDAO.anadirSesion(sesionEntrenamientoDAO);
	System.out.println(usuarioDAO.getSesiones());
	UserDAO.getInstance().save(usuarioDAO);
	//System.out.print(UserDAO.getInstance().find("Alfonso") + "\n");
	//System.out.println(RetoDAO.getInstance().find("Correr un poco"));
	//System.out.println(RetoDAO.getInstance().findFromUser(usuarioDAO.getNombre(), "Correr un poco"));
	//System.out.println(SesionEntrenamientoDAO.getInstance().find("Cumbia mientras corro"));
	//System.out.println(SesionEntrenamientoDAO.getInstance().findFromUser(usuarioDAO.getNombre(), "Cumbia mientras corro"));
	//UserDAO.getInstance().delete(usuarioDAO);
	//System.out.print("Usuario: " + UserDAO.getInstance().find("Alfonso") + "\n");
	
	System.exit(0);
	}
}
