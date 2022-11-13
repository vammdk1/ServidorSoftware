package strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import strava.data.domain.Reto;
import strava.data.domain.SesionEntrenamiento;
import strava.data.domain.User;
import strava.data.domain.UsuarioNoStrava;
import strava.data.domain.UsuarioStrava;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public boolean Registro (User usuario) throws RemoteException;
	
	public long InicioGoogle (UsuarioNoStrava usuario) throws RemoteException;
	
	public long InicioFacebook (UsuarioNoStrava usuario) throws RemoteException;
	
	public ArrayList<Reto> VerRetosActivos () throws RemoteException;
	
	public boolean CrearReto (Reto reto) throws RemoteException;
	
	public boolean CrearSesionEntrenamiento (User usuario ,SesionEntrenamiento sesion) throws RemoteException;
	
	public ArrayList<Reto> VerRetosAceptados (User usuario) throws RemoteException;
	
	
	
}