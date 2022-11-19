package strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.dto.DeportesDTO;
import strava.server.data.dto.SesionEntrenamientoDTO;

public class SesionEntrenamientoController {
	private ServiceLocator serviceLocator;
	public DeportesDTO tDeportes ;
	
	public SesionEntrenamientoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean crearSesionEntrenamiento(long token, String titulo, DeportesDTO deporte, float distancia, Date fechaHoraInicio, float duracion) 
	{
		SesionEntrenamientoDTO sesion = new SesionEntrenamientoDTO();
		sesion.setDeporte(deporte);
		sesion.setDistancia(distancia);
		sesion.setDuracion(duracion);
		sesion.setFechaHoraInicio(fechaHoraInicio);
		sesion.setTitulo(titulo);
		
		try {
			return this.serviceLocator.getService().crearSesionEntrenamiento(token, sesion);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
