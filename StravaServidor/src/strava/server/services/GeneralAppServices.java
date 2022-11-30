package strava.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		Proveedor[] a = Proveedor.values();
		if (usuarioDTO.getProveedor().equals("LOCAL")) {
			UsuarioStrava usuario = new UsuarioStrava(usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getFechancto(), usuarioDTO.getPeso(), usuarioDTO.getAltura(), usuarioDTO.getPulsoxMinuto(),usuarioDTO.getPulsoReposo(),a[usuarioDTO.getProveedor().getIndex()], password);
			return BaseDatos.RegistrarUsuario(usuario, password);
		}else {
			System.out.println("registrando usuario googleFacebook");
			User usuario = new User(usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getFechancto(), usuarioDTO.getPeso(), usuarioDTO.getAltura(), usuarioDTO.getPulsoxMinuto(),usuarioDTO.getPulsoReposo(),a[usuarioDTO.getProveedor().getIndex()]);
			//TODO revisar si hay que almacenar los usuarios externos en sus respectivos servidores (como lo hace albaro)
			return BaseDatos.RegistrarUsuario(usuario, password);
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

	public Map<Reto, Float> DevolverRetosAceptados(User usuario) {
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

	public List<SesionEntrenamiento> DevolverSesionesEntrenamiento(User user) {
		if (BaseDatos.getSesionesEntrenamiento(user) != null) {
			return BaseDatos.getSesionesEntrenamiento(user);
		}
		return null;
	}


}
