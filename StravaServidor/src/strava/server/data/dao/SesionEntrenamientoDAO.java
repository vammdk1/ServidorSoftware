package strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;

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
						
			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE name == '" + param + "'");
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

	public static SesionEntrenamientoDAO getInstance() {
		if (instance == null) {
			instance = new SesionEntrenamientoDAO();
		}
		
		return instance;
	}
}
