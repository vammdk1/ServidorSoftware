package strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;

public class SesionEntrenamientoDAO extends DataAccessObjectBase implements IDataAccessObject<SesionEntrenamiento> {

	private static SesionEntrenamientoDAO instance;
	
	private SesionEntrenamientoDAO() {}

	@Override
	public void save(SesionEntrenamiento object) {
		super.saveObject(object);
	}

	@Override
	public void delete(SesionEntrenamiento object) {
		super.deleteObject(object);
	}

	@Override
	public List<SesionEntrenamiento> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<SesionEntrenamiento> sesionesEntrenamiento = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<SesionEntrenamiento> extent = pm.getExtent(SesionEntrenamiento.class, true);

			for (SesionEntrenamiento category : extent) {
				sesionesEntrenamiento.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sesionesEntrenamiento;		
	}

	@Override
	public SesionEntrenamiento find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		SesionEntrenamiento result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + SesionEntrenamiento.class.getName() + " WHERE titulo == '" + param + "'");
			query.setUnique(true);
			result = (SesionEntrenamiento) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Category: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
	public SesionEntrenamiento findFromUser(String user, String sesion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		SesionEntrenamiento sesionEntrenamientoResult = null; 
		User usuarioResult = null;

		try {
			tx.begin();
						
			Query<?> query1 = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE nombre == '" + user + "'");
			
			query1.setUnique(true);
			usuarioResult = (User) query1.execute();
			
			sesionEntrenamientoResult = SesionEntrenamientoDAO.getInstance().find(sesion);
			System.out.println("findFromUser Retos: " + usuarioResult.getRetos());
			
			for (SesionEntrenamiento sesionEntrenamientoKeys : usuarioResult.getSesiones()) {
				if (sesionEntrenamientoKeys.getTitulo() == sesion) {
					break;
				}
				sesionEntrenamientoResult = null;
			}
			
			System.out.println("findFromUser Retos 2: " + usuarioResult.getRetos());
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Category: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sesionEntrenamientoResult;
	}

	public static SesionEntrenamientoDAO getInstance() {
		if (instance == null) {
			instance = new SesionEntrenamientoDAO();
		}
		
		return instance;
	}
}
