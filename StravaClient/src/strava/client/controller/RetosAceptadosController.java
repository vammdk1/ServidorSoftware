package strava.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import strava.client.gui.VentanaUsuario;
import strava.client.remote.ServiceLocator;
import strava.server.data.domain.Reto;
import strava.server.data.dto.RetoDTO;

public class RetosAceptadosController {
	
	private ServiceLocator serviceLocator;
	
	public RetosAceptadosController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public List<RetoDTO> getRetos() {
		try {
			return this.serviceLocator.getService().verRetosAceptados(VentanaUsuario.getToken());
		} catch (RemoteException e) {
			System.out.println("Error obteniendo retos");
			return null;
		}
		
	}
}
