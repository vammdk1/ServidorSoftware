package strava.client.controller;


import java.rmi.RemoteException; 
import java.util.Date;

import strava.client.remote.ServiceLocator;
import strava.server.data.dto.DeportesDTO;
import strava.server.data.dto.RetoDTO;

public class RetoController {
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public boolean crearReto(long token, String nombre, DeportesDTO deporte, Date fechaInicio, Date fechaFin, float distanciaObjetivo, float tiempoObjetivo) 
	{
		RetoDTO reto = new RetoDTO();
		reto.setDeporte(deporte);
		reto.setDistanciaObjetivo(distanciaObjetivo);
		reto.setFechaFin(fechaFin);
		reto.setFechaIni(fechaInicio);
		reto.setNombre(nombre);
		reto.setTiempoObjetivo(tiempoObjetivo);
		
		try {
			return this.serviceLocator.getService().crearReto(token,reto);
		} catch (RemoteException e) {
			System.out.println("# Error creando una sesión de entrenamiento: " + e);
			return false;
		}
	}
}
