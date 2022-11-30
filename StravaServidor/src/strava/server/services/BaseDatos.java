package strava.server.services;


import java.util.ArrayList; 
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.gateway.FacebookServiceGateway;

public class BaseDatos {
	
	private static Map<String, User> UsuariosRegistrados = new HashMap<>();
	private static ArrayList<Reto> RetosActivos = new ArrayList<>();
	private static ArrayList<SesionEntrenamiento> SesionesEntrenamiento = new ArrayList<>();

	/**
	 * 
	 * @param usuario 
	 * @return devuelve un usuario o un null que bloquea el inicio de sesion
	 */
	public static User comprobarCuenta(User usuario) {
		if(UsuariosRegistrados.containsKey(usuario.getEmail())) {
			if(!UsuariosRegistrados.get(usuario.getEmail()).getProveedor().equals("LOCAL")) {
					System.out.println("Es un usuario NoStrava:"+ usuario.getEmail()+ "||" + usuario.getProveedor());
					return UsuariosRegistrados.get(usuario.getEmail());
			}else {
					String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(((UsuarioStrava) UsuariosRegistrados.get(usuario.getEmail())).getContrasenna());
					System.out.println("Es un usuario Strava:"+((UsuarioStrava) usuario).getContrasenna()+"||"+sha1);
					
					if(sha1.equals(((UsuarioStrava) usuario).getContrasenna())) {
						System.out.println("* RemoteFacade Login(): correcto");
						return UsuariosRegistrados.get(usuario.getEmail());
					}else {
						return null;
					}
				}
		}else {
			System.out.println("No se encuentra la cuenta:"+usuario.getEmail());
			return null;
		}
	}
	
	/**
	 * @param NuevoUsuario objeto tipo user (acepta Strava y no Strava)
	 */
	public static boolean RegistrarUsuario(User NuevoUsuario, String password) {
		if(!UsuariosRegistrados.containsKey(NuevoUsuario.getEmail())) {
			if (NuevoUsuario.getProveedor()==Proveedor.LOCAL) {
				//TODO donde guardar los datos, de momento todos van a estar aquí
				UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
			}else if (NuevoUsuario.getProveedor() == Proveedor.FACEBOOK){
				if (FacebookServiceGateway.getInstance().facebookLogin(NuevoUsuario.getEmail(), password)) {
				//se conecta con facebook
					UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
				}
				else {
					System.out.println("No existe el usuario de Facebook introducido");
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
			if(UsuariosRegistrados.get(usuario.getEmail())!=null) {
				UsuariosRegistrados.get(usuario.getEmail()).anadirReto(reto);
				RetosActivos.add(reto);
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
		UsuariosRegistrados.get(usuario.getEmail()).anadirSesion(sesion);
		return true;
	}

	public static Map<Reto, Float> getRetosAceptados(User usuario) {
		Map<Reto, Float> listaCompleta = new HashMap<>();
		listaCompleta=UsuariosRegistrados.get(usuario.getEmail()).getRetos();
		if(listaCompleta.size()>0) {
			return listaCompleta;
		}else {
			return null;
		}
	}
	
	public static void getDatos() {
		for (var entry : UsuariosRegistrados.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}

	public static List<SesionEntrenamiento> getSesionesEntrenamiento(User user) {
		ArrayList<SesionEntrenamiento> listaCompleta = new ArrayList<>();
		listaCompleta = UsuariosRegistrados.get(user.getEmail()).getSesiones();
		if(listaCompleta.size()>0) {
			return listaCompleta;
		}else {
			return null;
		}
	}

	
}
