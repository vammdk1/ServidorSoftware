package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogleServices  {
	public boolean GoogleLogin(String email, String password) throws RemoteException;
	public void GoogleRegister(String email, String password) throws RemoteException;
}
