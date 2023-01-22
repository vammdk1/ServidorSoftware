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

public class UserDAO extends DataAccessObjectBase implements IDataAccessObject<User> {
	
	private static UserDAO instance;
	
	private UserDAO() {}

	@Override
	public void save(User object) {
		super.saveObject(object);
	}

	@Override
	public void delete(User object) {
		super.deleteObject(object);
	}

	@Override
	public List<User> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<User> users = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<User> extent = pm.getExtent(User.class, true);

			for (User user : extent) {
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
	public User find(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		User result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			result = (User) query.execute();
			
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

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}

	@Override
	public User findFromUser(String user, String param) {
		return UserDAO.getInstance().find(param);
	}
}
