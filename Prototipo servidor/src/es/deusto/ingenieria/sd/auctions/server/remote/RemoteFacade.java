package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DatosUsuario.User;
import DatosUsuario.UsuarioNoStrava;
import DatosUsuario.UsuarioStrava;
import Funcionalidad.Reto;
import Funcionalidad.SesionEntrenamiento;
import es.deusto.ingenieria.sd.auctions.server.services.BaseDatos;
import es.deusto.ingenieria.sd.auctions.server.services.GeneralAppServices;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;



public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;


	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private GeneralAppServices appServices = new GeneralAppServices();

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
	public synchronized boolean Registro (User usuario) throws RemoteException {
		if(BaseDatos.RegistrarUsuario(usuario)) {
			System.out.println("RemoteFacade Registro(): " + usuario.getEmail());
			return true;
		}else {
			throw new RemoteException("El correo ingresado ya se encuentra en uso");
		}
		
	}

	@Override
	public synchronized long InicioGoogle(UsuarioNoStrava usuario) throws RemoteException {
		System.out.println("RemoteFacade loginGoogle()");
		
		//Perform login() using LoginAppService
		User user = loginService.loginGoogleFacebook(usuario.getEmail(), true);
			
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
	public synchronized long InicioFacebook(UsuarioNoStrava usuario) throws RemoteException {
		System.out.println("RemoteFacade loginFacebook()");
		//Perform login() using LoginAppService
		User user = loginService.loginGoogleFacebook(usuario.getEmail(), false);
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
	public synchronized ArrayList<Reto> VerRetosActivos() throws RemoteException {
		ArrayList<Reto> retosActivos = appServices.DevolverRetosActivos();
		if(retosActivos!=null) {
			return retosActivos;
		}
		throw new RemoteException("No hay retos activos");
	}

	@Override
	public synchronized boolean CrearReto(Reto reto) throws RemoteException {
		//hace falta el token para crear el reto ?/ como evitar retos duplicados (usar el nombre)
			if(GeneralAppServices.setReto(reto)) {
				return true; //para la pantalla sacar los datos del reto ?
			}
			throw new RemoteException("No se puedo crear el reto");
		//si se crea el reto , devolver reto
	}

	@Override
	public synchronized boolean CrearSesionEntrenamiento(User usuario, SesionEntrenamiento sesion) throws RemoteException {
		if(GeneralAppServices.setSesion(usuario, sesion)) {
			return true;
		}
		throw new RemoteException("No se puedo la sesion");
		
	}

	@Override
	public synchronized ArrayList<Reto> VerRetosAceptados(User usuario) throws RemoteException {
		ArrayList<Reto> retosAceptados = appServices.DevolverRetosAceptados(usuario);
		if(retosAceptados!=null) {
			return retosAceptados;
		}
		throw new RemoteException("No hay retos aceptados");
	}




	


}