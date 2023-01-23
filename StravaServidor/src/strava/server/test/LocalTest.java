package strava.server.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import strava.server.data.dao.RetoDAO;
import strava.server.data.dao.SesionEntrenamientoDAO;
import strava.server.data.dao.UserDAO;
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
	
	private static PersistenceManagerFactory pmf;
	
	public static void main(String[] args) {	
	RemoteFacade facade = null;
	ArrayList<Reto> lr1 = null;
	ArrayList<SesionEntrenamiento> ls1= null;
	UserDTO usuario1 = new UserDTO();
	//UsuarioStrava usuario2 = null;
	long token = 0l;
	long token2 = 02;
	long token3 = 03;
	
	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	Transaction tx = pm.currentTransaction();
	/**
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
	}**/
	/**
	//ver datos en el servidor
	try {
		BaseDatos.getDatos();
	} catch (Exception e) {
		System.out.println("\t# Error: " + e.getMessage());	
	}**/

	User usuarioDAO = new UsuarioStrava("Alfonso", "alfonsoortega@gmail.com", "22/12/2001", 50, 175, 130, 100, Proveedor.LOCAL, "1234");
	
	tx.begin();
	System.out.println("   * Storing an user: " + usuarioDAO);
	pm.makePersistent(usuarioDAO);
	tx.commit();
	
	Reto retoDAO = new Reto("Correr un poco", new Date(), new Date(), 10, 0, Deportes.RUNNING);
	SesionEntrenamiento sesionEntrenamientoDAO = new SesionEntrenamiento("Cumbia mientras corro", Deportes.RUNNING, 10, new Date(), 60);
	SesionEntrenamiento sesionEntrenamientoDAO2 = new SesionEntrenamiento("Cumbia mientras corro 2", Deportes.RUNNING, 10, new Date(), 60);
	RetoDAO.getInstance().save(retoDAO);
	SesionEntrenamientoDAO.getInstance().save(sesionEntrenamientoDAO);
	SesionEntrenamientoDAO.getInstance().save(sesionEntrenamientoDAO2);
	
	usuarioDAO.anadirReto(retoDAO);
	usuarioDAO.anadirSesion(sesionEntrenamientoDAO);
	System.out.println(usuarioDAO.getSesiones());
	//-------------------------------------------------
	
	
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing an object: " + usuarioDAO);
			pm.makePersistent(usuarioDAO);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		tx = pm.currentTransaction();
		List<User> products = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Products.");

			tx.begin();
			Extent<User> extent = pm.getExtent(User.class, true);

			for (User product : extent) {
				products.add(product);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		

	System.out.println(products.get(0).getSesiones().toString());
	System.out.println("Usuario: " + UserDAO.getInstance().find("alfonsoortega@gmail.com"));
	SesionEntrenamientoDAO.getInstance().find("Cumbia mientras corro");
	System.out.println("SEDAO" + SesionEntrenamientoDAO.getInstance().findFromUser(usuarioDAO.getNombre(), "Cumbia mientras corro"));
	System.out.println("SEDAO" + SesionEntrenamientoDAO.getInstance().findFromUser(usuarioDAO.getNombre(), "Cumbia mientras corro 2"));
	System.out.println(RetoDAO.getInstance().getAll());
	
	
	//UserDAO.getInstance().save(usuarioDAO);
	//-----------------------------------------------------------------------------------------
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
