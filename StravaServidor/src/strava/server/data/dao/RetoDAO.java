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
						
			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE nombre == '" + param + "'");
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
	
	public Reto findFromUser(String user, String reto) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		Reto retoResult = null; 
		User usuarioResult = null;

		try {
			tx.begin();
						
			Query<?> query1 = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE nombre == '" + user + "'");
			
			query1.setUnique(true);
			usuarioResult = (User) query1.execute();
			
			retoResult = RetoDAO.getInstance().find(reto);
			System.out.println("findFromUser Retos: " + usuarioResult.getRetos());
			
			for (Reto retoKeys : usuarioResult.getRetos().keySet()) {
				if (retoKeys.getNombre() == reto) {
					break;
				}
				retoResult = null;
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

		return retoResult;
	}

	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}
		
		return instance;
	}

}
