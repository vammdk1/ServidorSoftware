package strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioNoStrava;
import strava.server.data.domain.UsuarioStrava;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public boolean registro (User usuario) throws RemoteException;
	
	public User obtenerUsuario (long token) throws RemoteException;
	
	public long inicioGoogle (UsuarioNoStrava usuario) throws RemoteException;
	
	public long inicioFacebook (UsuarioNoStrava usuario) throws RemoteException;
	
	public ArrayList<Reto> verRetosActivos () throws RemoteException;
	
	public boolean crearReto (User usuario, Reto reto) throws RemoteException;
	
	public boolean crearSesionEntrenamiento (User usuario ,SesionEntrenamiento sesion) throws RemoteException;
	
	public ArrayList<Reto> verRetosAceptados (User usuario) throws RemoteException;
	
	public void aceptarReto(User usuario, Reto reto)  throws RemoteException;
	
}