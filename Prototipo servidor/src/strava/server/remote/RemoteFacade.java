package strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioNoStrava;
import strava.server.data.domain.UsuarioStrava;
import strava.server.services.BaseDatos;
import strava.server.services.GeneralAppServices;
import strava.server.services.LoginAppService;



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
	public synchronized boolean registro (String nombre,String email,String fechaNac,float peso,int altura,int pulsoxMinuto,int pulsoReposo,String password) throws RemoteException {
		UsuarioStrava usuario = new UsuarioStrava(nombre, email, fechaNac, peso, altura, pulsoxMinuto, pulsoReposo,password);
		if(GeneralAppServices.registrarusuario(usuario)) {
			System.out.println("RemoteFacade Registro(): " + usuario.getEmail());
			return true;
		}else {
			throw new RemoteException("El correo ingresado:"+usuario.getEmail()+", ya se encuentra en uso");
		}
		
	}

	@Override
	public synchronized long inicioGoogle(String email) throws RemoteException {
		System.out.println("RemoteFacade loginGoogle()");
		
		//Perform login() using LoginAppService
		User user = loginService.loginGoogleFacebook(email, true);
			
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
	public synchronized long inicioFacebook(String email) throws RemoteException {
		System.out.println("RemoteFacade loginFacebook()");
		//Perform login() using LoginAppService
		User user = loginService.loginGoogleFacebook(email, false);
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
	public synchronized ArrayList<Reto> verRetosActivos() throws RemoteException {
		ArrayList<Reto> retosActivos = appServices.DevolverRetosActivos();
		if(retosActivos!=null) {
			return retosActivos;
		}
		throw new RemoteException("No hay retos activos");
	}

	@Override
	public synchronized boolean crearReto(User usuario,Reto reto) throws RemoteException {
		System.out.println("Creando Reto");
			if(GeneralAppServices.setReto(usuario,reto)) {
				return true; //para la pantalla sacar los datos del reto ?
			}
			throw new RemoteException("No se puedo crear el reto");
		//si se crea el reto , devolver reto
	}

	@Override
	public synchronized boolean crearSesionEntrenamiento(User usuario, SesionEntrenamiento sesion) throws RemoteException {
		if(GeneralAppServices.setSesion(usuario, sesion)) {
			return true;
		}
		throw new RemoteException("No se puedo la sesion");
		
	}

	@Override
	public synchronized ArrayList<Reto> verRetosAceptados(User usuario) throws RemoteException {
		ArrayList<Reto> retosAceptados = appServices.DevolverRetosAceptados(usuario);
		if(retosAceptados!=null) {
			return retosAceptados;
		}
		throw new RemoteException("No hay retos aceptados");
	}
	
	public synchronized User obtenerUsuario(long token) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			return this.serverState.get(token);
		}
		else {
			System.out.println("Error: no existe usuario para ese token");
			return null;
		}
		
	}
	
	public void aceptarReto(User usuario, Reto reto)  throws RemoteException {
		if(GeneralAppServices.aceptarReto(usuario,reto)) {
			return;  //para la pantalla sacar los datos del reto ?
		}
		else throw new RemoteException("No se puedo aceptar el reto");
	}
	


}