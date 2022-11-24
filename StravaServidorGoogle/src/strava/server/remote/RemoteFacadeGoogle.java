package strava.server.remote;

import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import strava.server.data.dto.RetoAssembler;
import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoAssembler;
import strava.server.data.dto.SesionEntrenamientoDTO;
import strava.server.data.dto.UserDTO;
import strava.server.services.LoginAppServiceGoogle;



public class RemoteFacadeGoogle extends UnicastRemoteObject implements IRemoteFacadeGoogle {	
	private static final long serialVersionUID = 1L;


	//Data structure for manage Server State
	
	//TODO: Remove this instances when Singleton Pattern is implemented

	public RemoteFacadeGoogle() throws RemoteException {
		super();		
	}
	LoginAppServiceGoogle logG;
	
	@Override
	public synchronized long login(String email) throws RemoteException {
		System.out.println(" * RemoteFacadeGoogle login(): " + email );
				
		//Perform login() using LoginAppService
		//If login() success user is stored in the Server State
		if (logG.login(email)) {
			//If user is not logged in 
				Long token = Calendar.getInstance().getTimeInMillis();			
				return(token);
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
}