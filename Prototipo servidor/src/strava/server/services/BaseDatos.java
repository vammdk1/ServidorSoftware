package strava.server.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioNoStrava;
import strava.server.data.domain.UsuarioStrava;

public class BaseDatos {
	
	private static Map<String, User> UsuariosRegistrados = new HashMap<>();
	private static ArrayList<Reto> RetosActivos = new ArrayList<>();

	/**
	 * 
	 * @param usuario 
	 * @return devuelve un usuario o un null que bloquea el inicio de sesion
	 */
	public static User comprobarCuenta(User usuario) {
		if(UsuariosRegistrados.containsKey(usuario.getEmail())) {
			if(UsuarioNoStrava.class.isInstance(UsuariosRegistrados.get(usuario.getEmail()))) {
					//TODO comprobar contra algo 
					return UsuariosRegistrados.get(usuario.getEmail());
				}else {
					String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(((UsuarioStrava) usuario).getContrasenna());
					if(((UsuarioStrava) UsuariosRegistrados.get(usuario.getEmail())).getContrasenna().equals(sha1)) {
						return UsuariosRegistrados.get(usuario.getEmail());
					}else {
						return null;
					}
				}
		}else {
			return null;
		}
	}
	
	/**
	 * @param NuevoUsuario objeto tipo user (acepta Strava y no Strava)
	 */
	public static boolean RegistrarUsuario(strava.server.data.domain.User NuevoUsuario) {
		if(!UsuariosRegistrados.containsKey(NuevoUsuario.getEmail())) {
			UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
			return true;
			//TODO String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);	donde se almacenen los usuarios
		}else {
			return false;
		}
		
	}
	
	public static boolean RegistrarReto(Reto reto) {
		Date in = new Date(0);
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = (Date) Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		if(reto.getFechaFin().compareTo(out)>0) {
			RetosActivos.add(reto);
			return true;
		}else {
			return false;
		}
	}
	
	public static ArrayList<Reto> getRetosActivos(){
		ArrayList<Reto> listaCompleta = new ArrayList<>();
		if(RetosActivos.size()>=0) {
			for (int i = 0; i < RetosActivos.size(); i++) {
				Date in = new Date(0);
				LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
				Date out = (Date) Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
				if(RetosActivos.get(i).getFechaFin().compareTo(out)>0) {
					listaCompleta.add(RetosActivos.get(i));
				}	
			}
			RetosActivos=listaCompleta;
			return listaCompleta; 
		}else {
			return null;
		}
	
	}

	public static boolean agregarEntrenamiento(User usuario, SesionEntrenamiento sesion) {
		UsuariosRegistrados.get(usuario.getEmail()).anadirSesion(sesion);
		return true;
	}

	public static ArrayList<Reto> getRetosAceptados(User usuario) {
		ArrayList<Reto> listaCompleta = new ArrayList<>();
		listaCompleta=UsuariosRegistrados.get(usuario.getEmail()).getRetos();
		if(listaCompleta.size()>0) {
			return listaCompleta;
		}else {
			return null;
		}
	
	}
	
}
