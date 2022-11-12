package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DatosUsuario.UsuarioNoStrava;
import DatosUsuario.UsuarioStrava;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;



public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;


	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		User user = loginService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public void Registro(UsuarioStrava usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InicioGoogle(UsuarioNoStrava usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InicioFacebook(UsuarioNoStrava usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VerRetosActivos(long token) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CrearReto(long token) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CrearSesionEntrenamiento(long token) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VerRetosAceptados(long token) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	


}