package strava.client.controller;


import java.rmi.RemoteException; 
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.domain.Deportes;
import strava.server.data.domain.Reto;
import strava.server.data.domain.User;
import strava.server.data.dto.RetoDTO;

public class RetoController {
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public boolean crearReto(long token, String nombre, Deportes deporte, Date fechaInicio, Date fechaFin, float distanciaObjetivo, float tiempoObjetivo) 
	{
		RetoDTO reto = new RetoDTO();
		//(nombre, fechaInicio, fechaFin, distanciaObjetivo, tiempoObjetivo, deporte);
		reto.setNombre(nombre);
		reto.setFechaFin(fechaFin);
		reto.setFechaIni(fechaFin);
		reto.setDistanciaObjetivo(distanciaObjetivo);
		reto.setTiempoObjetivo(tiempoObjetivo);
		reto.setDeporte(deporte);
		
		try {
			return this.serviceLocator.getService().crearReto(token,reto);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
