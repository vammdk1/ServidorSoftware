package strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import strava.server.data.domain.*;

public class RetoDAO extends DataAccessObjectBase implements IDataAccessObject<Reto> {
	
	private static RetoDAO instance;
	
	private RetoDAO() {}

	@Override
	public void save(Reto object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Reto object) {
		super.deleteObject(object);
	}

	@Override
	public List<Reto> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<Reto> retos = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Reto> extent = pm.getExtent(Reto.class, true);

			for (Reto category : extent) {
				retos.add(category);
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

		return retos;		
	}

	@Override
	public Reto find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		Reto result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT R.* FROM USER_RETOS UR, RETO R, USER U " + " WHERE R.NOMBRE == '" + param + "' AND R.RETO_ID == UR.RETO_ID_KID AND UR.USER_ID_OID == U.USER_ID");
			query.setUnique(true);
			result = (Reto) query.execute();
			
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

	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}
		
		return instance;
	}

}
