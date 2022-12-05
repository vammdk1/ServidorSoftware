package strava.server.services;

import java.rmi.RemoteException;

import strava.server.data.domain.Proveedor; 
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.factory.GatewayFactory;
import strava.server.gateway.FacebookServiceGateway;
import strava.server.gateway.GoogleServiceGateway;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 		
		System.out.println(email+"||"+password);
		UsuarioStrava user = new UsuarioStrava("",email,"", 0, 0, 0, 0, Proveedor.LOCAL, password);
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);	
		user.setContrasenna(sha1);
		
		User user2 = BaseDatos.comprobarCuenta(user);
		if (user2.getProveedor().equals(Proveedor.LOCAL)) {
			return BaseDatos.comprobarCuenta(user);
		} else {
			return null;
		}
	}
	
	public User loginGoogleFacebook(String email,String password,String proveedor) throws RemoteException {
		//TODO cambiar la direccion de los datos
	
		User user = new User("",email, "", 0, 0, 0, 0, null);
			
		if(proveedor.equals("GOOGLE")) {
				 if (GatewayFactory.getInstance().loginExterno(email, password, "GOOGLE")) {
					 return BaseDatos.comprobarCuenta(user);
				 }else {
					 return null;
				 }
				 
				
			}else if(proveedor.equals("FACEBOOK")){
				if (GatewayFactory.getInstance().loginExterno(email, password, "FACEBOOK")) {
				return BaseDatos.comprobarCuenta(user);
				} else {
					return null;
				}
			}else {
				System.out.println("EL usuario "+ email +" no pertenece a google ni a facebook");
				return null;
			}
		

	}
}