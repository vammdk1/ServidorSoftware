package strava.server.remote;

import java.io.Serializable;
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
import strava.server.data.dto.RetoAssembler;
import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoAssembler;
import strava.server.data.dto.SesionEntrenamientoDTO;
import strava.server.data.dto.UserDTO;
import strava.server.services.GeneralAppServices;
import strava.server.services.LoginAppService;



public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade, Serializable {	
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
	public synchronized boolean registro (UserDTO usuarioDTO, String password) throws RemoteException {
		//User usuario = usuariodto;
		if(GeneralAppServices.registrarusuario(usuarioDTO,password)) {
			System.out.println("RemoteFacade Registro(): " + usuarioDTO.getEmail());
			return true;
		}else {
			throw new RemoteException("El correo ingresado:"+usuarioDTO.getEmail()+", ya se encuentra en uso");
		}
		
	}
	
	@Override
	public synchronized boolean registroExterno (UserDTO usuarioDTO, String password, String provedor) throws RemoteException {
		//User usuario = usuariodto;
		if(GeneralAppServices.registrarusuario(usuarioDTO,password)) {
			System.out.println("RemoteFacade Registro(): " + usuarioDTO.getEmail());
			return true;
		}else {
			throw new RemoteException("El correo ingresado:"+usuarioDTO.getEmail()+", ya se encuentra en uso");
		}
		
	}

	@Override
	public synchronized long InicioExterno(String email, String password,String proveedor) throws RemoteException {
		System.out.println("RemoteFacade loginGoogle()");
		
		User user = loginService.loginGoogleFacebook(email, password,proveedor);
			
		if (user!=null) {
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
/**
	@Override
	public synchronized long inicioFacebook(String email, String password) throws RemoteException {
		System.out.println("RemoteFacade loginFacebook()");
		//Perform login() using LoginAppService
		User user = new User(null, email, null, 0, 0, 0, 0, Proveedor.GOOGLE);
		//If login() success user is stored in the Server State
		if (loginService.loginGoogleFacebook(email, password)) {
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
**/
	@Override
	public synchronized List<RetoDTO> verRetosActivos() throws RemoteException {
		ArrayList<Reto> retosActivos = appServices.DevolverRetosActivos();
		if(retosActivos!=null) {
			return RetoAssembler.getInstance().retoToDTO(retosActivos);
		}
		throw new RemoteException("No hay retos activos");
	}

	@Override
	public synchronized boolean crearReto(long token,RetoDTO reto) throws RemoteException {
		System.out.println("Creando Reto");
			if(GeneralAppServices.setReto(serverState.get(token),reto)) {
				return true; //para la pantalla sacar los datos del reto ?
			}
			throw new RemoteException("No se puedo crear el reto");
		//si se crea el reto , devolver reto
	}

	@Override
	public synchronized boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO sesion) throws RemoteException {
		
		if(GeneralAppServices.setSesion(serverState.get(token), sesion)) {
			
			return true;
		}
		throw new RemoteException("No se puedo crear la sesion de entrenamiento");
		
	}

	@Override
	public synchronized Map<RetoDTO, Float> verRetosAceptados(long token) throws RemoteException {
		Map<Reto, Float> retosAceptados = appServices.DevolverRetosAceptados(serverState.get(token));
		
		if(retosAceptados!=null) {
			return RetoAssembler.getInstance().retoToDTO(retosAceptados);
		}
		throw new RemoteException("No hay retos aceptados");
	}
	

	
	public void aceptarReto(long token, RetoDTO reto)  throws RemoteException {
		if(GeneralAppServices.aceptarReto(serverState.get(token),reto)) {
			return;  //para la pantalla sacar los datos del reto ?
		}
		else throw new RemoteException("No se puedo aceptar el reto");
	}

	@Override
	public List<SesionEntrenamientoDTO> verSesionesEntrenamiento(long token) throws RemoteException {
		List<SesionEntrenamiento> sesiones = appServices.DevolverSesionesEntrenamiento(serverState.get(token));

		if (sesiones != null) {
			return SesionEntrenamientoAssembler.getInstance().sesionEntrenamientoToDTO(sesiones);
		}
		
		System.out.println("No hay sesiones de entrenamiento creadas.");
		return null;
	}
	


}