package es.deusto.ingenieria.sd.auctions.server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DatosUsuario.User;
import Funcionalidad.Reto;
import Funcionalidad.SesionEntrenamiento;

public class GeneralAppServices {

	public ArrayList<Reto> DevolverRetosActivos(){
		 if(BaseDatos.getRetosActivos().size()>0) {
			 return BaseDatos.getRetosActivos();
		}else {
			return null;
		}
	}
	
	public static boolean setReto(Reto reto) { //puede que tenga que justarla como el de abajo
		// TODO Auto-generated method stub
		BaseDatos.RegistrarReto(reto);
		return false;
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

	

	
}
