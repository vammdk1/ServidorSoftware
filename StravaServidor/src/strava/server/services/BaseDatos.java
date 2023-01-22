package strava.server.services;


import java.rmi.RemoteException;
import java.util.ArrayList; 
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import strava.server.data.dao.RetoDAO;
import strava.server.data.dao.UserDAO;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.gateway.FacebookServiceGateway;
import strava.server.gateway.GoogleServiceGateway;

public class BaseDatos {
	
	//private static ArrayList<Reto> RetosActivos = new ArrayList<>();
	private static ArrayList<SesionEntrenamiento> SesionesEntrenamiento = new ArrayList<>();

	/**
	 * 
	 * @param usuario 
	 * @return devuelve un usuario o un null que bloquea el inicio de sesion
	 */
	public static User comprobarCuenta(User usuario) {
		User user = UserDAO.getInstance().find(usuario.getEmail());
			if (user != null) {
				if(!user.getProveedor().equals("LOCAL")) {
					System.out.println("Es un usuario NoStrava:"+ usuario.getEmail()+ "||" + usuario.getProveedor());
					return user;
				} else {
					String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex((((UsuarioStrava) user).getContrasenna()));
					System.out.println("Es un usuario Strava:"+((UsuarioStrava) usuario).getContrasenna()+"||"+sha1);
					
					if(sha1.equals(((UsuarioStrava) usuario).getContrasenna())) {
						System.out.println("* RemoteFacade Login(): correcto");
						return user;
					}else {
						return null;
					}
				}
		}else {
			System.out.println("No se encuentra registrada la cuenta:"+usuario.getEmail());
			return null;
		}
	}
	
	/**
	 * @param NuevoUsuario objeto tipo user (acepta Strava y no Strava)
	 * @throws RemoteException 
	 */
	public static boolean RegistrarUsuario(User NuevoUsuario, String password) throws RemoteException {
		User user = UserDAO.getInstance().find(NuevoUsuario.getEmail()); 
		if (user == null) {
			if (NuevoUsuario.getProveedor()==Proveedor.LOCAL) {
				UserDAO.getInstance().save(NuevoUsuario);
				}
			else if (NuevoUsuario.getProveedor() == Proveedor.FACEBOOK){
				if (FacebookServiceGateway.getInstance().iniciarSesion(NuevoUsuario.getEmail(), password)) {
				//se conecta con facebook
					//UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
					UserDAO.getInstance().save(NuevoUsuario);
				}
				else {
					//TODO registrar usuaios de google
					System.out.println("No existe el usuario de Facebook introducido");
					return false;
				}
			}else if(NuevoUsuario.getProveedor()==Proveedor.GOOGLE) {
				if(GoogleServiceGateway.getInstance().GoogleLogin(NuevoUsuario.getEmail(), password)) {
					//UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
					UserDAO.getInstance().save(NuevoUsuario);
				}
				else {
					//TODO registrar usuaios de google
					System.out.println("No existe el usuario de google introducido");
					return false;
				}
			}
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean RegistrarReto(User usuario,Reto reto) {
		java.util.Date out = new java.util.Date();
		if(reto.getFechaFin().compareTo(out)>0) {
			User user = UserDAO.getInstance().find(usuario.getEmail());
			if (user != null) {
				RetoDAO.getInstance().save(reto);
				user.anadirReto(reto);
				UserDAO.getInstance().save(user);
				//RetosActivos.add(reto);
				//System.out.println(RetosActivos);
				return true;
			}else {
				return false;
			}
			
		}else {
			System.out.println("la fecha de fin es inferior a la de inicio");
			return false;
		}
	}
	
	public static ArrayList<Reto> getRetosActivos(){
		ArrayList<Reto> listaCompleta = new ArrayList<>();
		ArrayList<Reto> RetosActivos = (ArrayList<Reto>) RetoDAO.getInstance().getAll();
		java.util.Date out = new java.util.Date();
		if(RetosActivos.size()>=0) {
			for (int i = 0; i <= RetosActivos.size()-1; i++) {
				if(RetosActivos.get(i).getFechaFin().compareTo(out)>0) {
					listaCompleta.add(RetosActivos.get(i));
				}	
			}
			RetosActivos=listaCompleta;
			System.out.println(listaCompleta);
			return listaCompleta; 
		}else {
			return null;
		}
	
	}

	public static boolean agregarEntrenamiento(User usuario, SesionEntrenamiento sesion) {
		User user = UserDAO.getInstance().find(usuario.getEmail());
		user.anadirSesion(sesion);
		UserDAO.getInstance().save(user);
		//UsuariosRegistrados.get(usuario.getEmail()).anadirSesion(sesion);
		return true;
	}

	public static Map<Reto, Float> getRetosAceptados(User usuario) {
		Map<Reto, Float> listaCompleta = new HashMap<>();
		User user = UserDAO.getInstance().find(usuario.getEmail());
		listaCompleta = user.getRetos();
		if(listaCompleta.size()>0) {
			return listaCompleta;
		}else {
			return null;
		}
	}
	
	/*
	public static void getDatos() {
		for (var entry : UsuariosRegistrados.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}*/

	public static List<SesionEntrenamiento> getSesionesEntrenamiento(User user) {
		List<SesionEntrenamiento> listaCompleta = new ArrayList<>();
		User usuario = UserDAO.getInstance().find(user.getEmail());
		listaCompleta = usuario.getSesiones();
		if(listaCompleta.size()>0) {
			return listaCompleta;
		}else {
			return null;
		}
	}

	
}
