package strava.client.controller;

import java.rmi.RemoteException;

import strava.client.remote.ServiceLocator;
import strava.server.data.dto.ProveedorDTO;
import strava.server.data.dto.UserAssembler;
import strava.server.data.dto.UserDTO;

public class RegisterController {
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;
	//This attibute stores the token when login success
	private long token = -1; //-1 = login has not been done or fails

	private static RegisterController instance;
	
	private RegisterController() {
		this.serviceLocator = ServiceLocator.getInstance();
	}
		
	public void register(String nombre, String email, String fechaNac, float peso, int altura, int pulsoxMinuto, int pulsoReposo, String password, ProveedorDTO prov) {
		
		UserDTO user = new UserDTO();
		user.setNombre(nombre);
		user.setEmail(email);
		user.setFechancto(fechaNac);
		user.setPeso(peso);
		user.setAltura(altura);
		user.setPulsoxMinuto(pulsoxMinuto);
		user.setPulsoReposo(pulsoReposo);
		user.setProveedor(prov);
		try {
			//System.out.println(email+"||"+user.getContrasenna());
			this.serviceLocator.getService().registro(user, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("# Error en el registro: " + e);
		}
	}

	public static RegisterController getInstance() {
		synchronized(RegisterController.class) {
			if (instance == null) {
				instance = new RegisterController();
			}
		}
		return instance;
	}	
}
