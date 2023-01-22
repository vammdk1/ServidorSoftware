package strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;

public class UsuarioStravaDAO extends DataAccessObjectBase implements IDataAccessObject<UsuarioStrava>{

	private static UsuarioStravaDAO instance;
	
	private UsuarioStravaDAO() {}

	@Override
	public void save(UsuarioStrava object) {
		super.saveObject(object);
	}

	@Override
	public void delete(UsuarioStrava object) {
		super.deleteObject(object);
	}

	@Override
	public List<UsuarioStrava> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<UsuarioStrava> users = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<UsuarioStrava> extent = pm.getExtent(UsuarioStrava.class, true);

			for (UsuarioStrava user : extent) {
				users.add(user);
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

		return users;		
	}

	@Override
	public UsuarioStrava find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		UsuarioStrava result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE nombre == '" + param + "'");
			query.setUnique(true);
			result = (UsuarioStrava) query.execute();
			
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

	public static UsuarioStravaDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioStravaDAO();
		}
		
		return instance;
	}

}
