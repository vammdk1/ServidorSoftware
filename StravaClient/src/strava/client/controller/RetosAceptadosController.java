package strava.client.controller;

import java.rmi.RemoteException;
import java.util.Map;

import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;
import strava.server.data.dto.RetoDTO;

public class RetosAceptadosController {
	
	private ServiceLocator serviceLocator;
	
	private static RetosAceptadosController instance = new RetosAceptadosController();
	
	private RetosAceptadosController() {
		this.serviceLocator = ServiceLocator.getInstance();
	}
	
	public Map<RetoDTO, Float> getRetos(long token) {
		try {
			return this.serviceLocator.getService().verRetosAceptados(token);
		} catch (RemoteException e) {
			System.out.println("Error obteniendo retos: " + e);
			return null;
		}
		
	}

	public static RetosAceptadosController getInstance() {
		return instance;
	}
	
	
}
