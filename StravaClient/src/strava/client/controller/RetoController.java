package strava.client.controller;


import java.rmi.RemoteException; 
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.domain.Reto;
import strava.server.data.domain.User;

public class RetoController {
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean crearReto(User usuario, String nombre, String deporte, Date fechaInicio, Date fechaFin, float distanciaObjetivo, float tiempoObjetivo) 
	{
		Reto reto = new Reto(nombre, fechaInicio, fechaFin, distanciaObjetivo, tiempoObjetivo, deporte);
		
		try {
			return this.serviceLocator.getService().crearReto(usuario,reto);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
