package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import DatosUsuario.User;
import DatosUsuario.UsuarioNoStrava;
import DatosUsuario.UsuarioStrava;

public class BaseDatos {
	
	private static Map<String, User> UsuariosRegistrados = new HashMap<>();

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
	public static boolean RegistrarUsuario(DatosUsuario.User NuevoUsuario) {
		if(!UsuariosRegistrados.containsKey(NuevoUsuario.getEmail())) {
			UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
			return true;
			//TODO String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);	donde se almacenen los usuarios
		}else {
			return false;
		}
		
	}
	
}
