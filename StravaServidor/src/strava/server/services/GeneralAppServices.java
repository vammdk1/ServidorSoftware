package strava.server.services;

import java.util.ArrayList;

import strava.server.data.domain.Deportes;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.data.dto.DeportesDTO;
import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoDTO;
import strava.server.data.dto.UserDTO;

public class GeneralAppServices {
	
	public static boolean registrarusuario(UserDTO usuarioDTO,String password) {
		UsuarioStrava usuario = new UsuarioStrava(usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getFechancto(), usuarioDTO.getPeso(), usuarioDTO.getAltura(), usuarioDTO.getPulsoxMinuto(),usuarioDTO.getPulsoReposo(),Proveedor.LOCAL, password);
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
	
	public static boolean setReto(User usuario,RetoDTO reto) { //puede que tenga que justarla como el de abajo
		// TODO Auto-generated method stub
		Deportes[] d = Deportes.values();
		Reto r = new Reto(reto.getNombre(), reto.getFechaIni(), reto.getFechaFin(), reto.getDistanciaObjetivo(), reto.getTiempoObjetivo(), d[reto.getDeporte().getIndex()]);
		if(BaseDatos.RegistrarReto(usuario, r)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean setSesion(User usuario,SesionEntrenamientoDTO sesion) {
		Deportes[] d = Deportes.values();
		SesionEntrenamiento s = new SesionEntrenamiento(sesion.getTitulo(), d[sesion.getDeporte().getIndex()], sesion.getDistancia(), sesion.getFechaHoraInicio(), sesion.getDuracion());
		if(BaseDatos.agregarEntrenamiento(usuario, s)) {
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
	
	public static boolean aceptarReto(User usuario, RetoDTO reto) {
		try {
			Deportes[] d = Deportes.values();
			Reto r = new Reto(reto.getNombre(), reto.getFechaIni(), reto.getFechaFin(), reto.getDistanciaObjetivo(), reto.getTiempoObjetivo(), d[reto.getDeporte().getIndex()]);
			usuario.anadirReto(r);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}


}
