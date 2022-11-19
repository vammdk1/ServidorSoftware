package strava.server.services;

import java.util.ArrayList;

import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.data.dto.UserDTO;

public class GeneralAppServices {
	
	public static boolean registrarusuario(UserDTO usuarioDTO,String password) {
		UsuarioStrava usuario = new UsuarioStrava(usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getFechancto(), usuarioDTO.getPeso(), usuarioDTO.getAltura(), usuarioDTO.getFrecuenciacardmax(),usuarioDTO.getFrecuenciacardreposo(),Proveedor.LOCAL, password);
		if(BaseDatos.RegistrarUsuario(usuario)) {
			return true;
		}else {
			return false;
		}
	}

	public ArrayList<Reto> DevolverRetosActivos(){
		ArrayList<Reto> Lretos = BaseDatos.getRetosActivos();
		 if(Lretos.size()>=0) {
			 return Lretos;
		}else {
			return null;
		}
	}
	
	public static boolean setReto(User usuario,Reto reto) { //puede que tenga que justarla como el de abajo
		// TODO Auto-generated method stub
		if(BaseDatos.RegistrarReto(usuario, reto)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean setSesion(User usuario,SesionEntrenamiento sesion) {
		if(BaseDatos.agregarEntrenamiento(usuario, sesion)) {
			return true;
		}else {
			return false;
		}
	}

	public ArrayList<Reto> DevolverRetosAceptados(User usuario) {
		if(BaseDatos.getRetosAceptados(usuario)!=null) {
			return BaseDatos.getRetosAceptados(usuario);
		}
		return null;
	}
	
	public static boolean aceptarReto(User usuario, Reto reto) {
		try {
			usuario.anadirReto(reto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}


}
