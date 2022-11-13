package strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;

public class SesionEntrenamientoController {
	private ServiceLocator serviceLocator;
	
	public SesionEntrenamientoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean crearSesionEntrenamiento(User usuario, String titulo, String deporte, float distancia, Date fechaHoraInicio, float duracion) 
	{
		SesionEntrenamiento sesion = new SesionEntrenamiento(titulo, deporte, distancia, fechaHoraInicio, duracion);
		
		try {
			return this.serviceLocator.getService().crearSesionEntrenamiento(usuario, sesion);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
