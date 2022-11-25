package strava.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;
import strava.server.data.dto.RetoDTO;

public class RetosActivosController {
	
private ServiceLocator serviceLocator;

private static RetosActivosController instance;
	
	private RetosActivosController() {
		this.serviceLocator = ServiceLocator.getInstance();
	}
	
	public List<RetoDTO> getRetos() {
		try {
			return this.serviceLocator.getService().verRetosActivos();
		} catch (RemoteException e) {
			System.out.println("Error obteniendo retos");
			return null;
		}
		
	}

	public static RetosActivosController getInstance() {
		synchronized(RetosActivosController.class) {
			if (instance == null) {
				instance = new RetosActivosController();
			}
		}
		return instance;
	}
}
