package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import DatosUsuario.UsuarioNoStrava;
import DatosUsuario.UsuarioStrava;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class BaseDatos {
	
	private static Map<String, User> UsuariosRegistrados = new HashMap<>();

	public static User comprobarCuenta(String email, String password) {
		if(UsuariosRegistrados.containsKey(email)) {
			if(UsuarioNoStrava.class.isInstance(UsuariosRegistrados.get(email))) {
					//TODO comprobar contra algo 
					return UsuariosRegistrados.get(email);
				}else {
					if( UsuariosRegistrados.get(email).checkPassword(password)) {
						return UsuariosRegistrados.get(email);
					}
				}
			return UsuariosRegistrados.get(email);
		}else {
			return null;
		}
	}
	
	/**
	 * @param NuevoUsuario objeto tipo user (acepta Strava y no Strava)
	 */
	public static void RegistrarUsuario(User NuevoUsuario) {
		if(!UsuariosRegistrados.containsKey(NuevoUsuario.getEmail())) {
			UsuariosRegistrados.put(NuevoUsuario.getEmail(), NuevoUsuario);
		}
	}
	
}
