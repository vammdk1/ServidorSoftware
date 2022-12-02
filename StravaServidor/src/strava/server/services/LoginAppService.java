package strava.server.services;

import strava.server.data.domain.Proveedor; 
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.gateway.FacebookServiceGateway;
import strava.server.sockets.EchoStrava;

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
	
	public User loginGoogleFacebook(String email,String password) {
		//TODO cambiar la direccion de los datos
	
		User user = new User("",email, "", 0, 0, 0, 0, null);
		System.out.println("Entrado a comprobador googleFace");
		User UserRegistrado = BaseDatos.comprobarCuenta(user);
		//se recibe el usuario relacionado al email
		if(UserRegistrado!=null) {
			if(UserRegistrado.getProveedor().equals(Proveedor.GOOGLE )) {
				String[] args = {"127.0.0.2","8001",email,password};
				 if(EchoStrava.main(args)) {
					 return BaseDatos.comprobarCuenta(user);
				 }else {
					 return null;
				 }
				 
				
			}else if(UserRegistrado.getProveedor().equals(Proveedor.FACEBOOK )){
				if (FacebookServiceGateway.getInstance().facebookLogin(email, password)) {
				return BaseDatos.comprobarCuenta(user);
				} else {
					return null;
				}
			}else {
				System.out.println("EL usuario "+UserRegistrado.getEmail() +" no pertenece a google ni a facebook");
				return null;
			}
		}else {
			return null;
		}
		

	}
}