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
import strava.server.data.dto.RetoDTO;
import strava.server.data.dto.SesionEntrenamientoDTO;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 

	public User obtenerUsuario (long token) throws RemoteException;
	
	public ArrayList<Reto> verRetosActivos () throws RemoteException;
	
	public boolean crearReto (long token, RetoDTO reto) throws RemoteException;
	
	public boolean crearSesionEntrenamiento (long token ,SesionEntrenamientoDTO sesion) throws RemoteException;
	
	public ArrayList<Reto> verRetosAceptados (long token) throws RemoteException;

	boolean registro(String nombre, String email, String fechaNac, float peso, int altura, int pulsoxMinuto,
			int pulsoReposo, String password) throws RemoteException;

	long inicioGoogle(String email) throws RemoteException;

	long inicioFacebook(String email) throws RemoteException;
	
	public void aceptarReto(long token, RetoDTO reto)  throws RemoteException;
	
}