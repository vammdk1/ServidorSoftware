package facebook.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class FacebookLoginService extends UnicastRemoteObject implements IFacebookLogin {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, String> facebookUsers = new HashMap<>();
	
	private static FacebookLoginService instance;
	
	protected FacebookLoginService() throws RemoteException {
		super();
		facebookLogin(null, null);
	}
	
	public static FacebookLoginService getInstance() {
		if (instance == null) {
			try {
				instance = new FacebookLoginService();
			} catch(Exception e) {
				System.err.println("  # Error initializing service(): " + e.getMessage());
			}
		}
		
		return instance;
	}
	
	public boolean facebookLogin(String user, String password) throws RemoteException {
		if (facebookUsers.containsKey(user)) {
			if (facebookUsers.get(user).equals(password)) {
				return true;
			}
			else {
				System.out.println("La contrasena para usuario " + user + " es incorrecta");
				return false;
			}
		} 
		else 
		{
			System.out.println("El usuario " + user + " no existe");
			return false;
		}
	}
}
