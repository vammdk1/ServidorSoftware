package strava.client.controller;


import java.rmi.RemoteException; 
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.domain.Deportes;
import strava.server.data.domain.Reto;
import strava.server.data.domain.User;

public class RetoController {
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	/**
	 * 
	 * @param token
	 * @param nombre
	 * @param deporte
	 * @param fechaInicio
	 * @param fechaFin
	 * @param distanciaObjetivo
	 * @param tiempoObjetivo
	 * @return
	 */
	public boolean crearReto(long token, String nombre, Deportes deporte, Date fechaInicio, Date fechaFin, float distanciaObjetivo, float tiempoObjetivo) 
	{
		Reto reto = new Reto(nombre, fechaInicio, fechaFin, distanciaObjetivo, tiempoObjetivo, deporte);
		
		try {
			return this.serviceLocator.getService().crearReto(token,reto);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
