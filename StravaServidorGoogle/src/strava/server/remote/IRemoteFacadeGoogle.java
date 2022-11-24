package strava.server.remote;

import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoDTO;
import strava.server.data.dto.UserDTO;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacadeGoogle extends Remote {	

	public long login(String email) throws RemoteException;
	

	
}