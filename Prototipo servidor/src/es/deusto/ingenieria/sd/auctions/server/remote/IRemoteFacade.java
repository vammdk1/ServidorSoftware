package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import DatosUsuario.User;
import DatosUsuario.UsuarioNoStrava;
import DatosUsuario.UsuarioStrava;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public void Registro (UsuarioStrava usuario) throws RemoteException;
	
	public void InicioGoogle (UsuarioNoStrava usuario) throws RemoteException;
	
	public void InicioFacebook (UsuarioNoStrava usuario) throws RemoteException;
	
	public void VerRetosActivos (long token) throws RemoteException;
	
	public void CrearReto (long token) throws RemoteException;
	
	public void CrearSesionEntrenamiento (long token) throws RemoteException;
	
	public void VerRetosAceptados (long token) throws RemoteException;
	
	
	
}