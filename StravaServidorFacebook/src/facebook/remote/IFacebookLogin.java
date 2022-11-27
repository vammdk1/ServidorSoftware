package facebook.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacebookLogin extends Remote {
	public boolean facebookLogin(String user, String password) throws RemoteException;
	public void facebookRegister(String user, String password) throws RemoteException;
}
