package strava.server;

import java.rmi.Naming;

import org.apache.log4j.BasicConfigurator;

import strava.server.data.dao.UserDAO;
import strava.server.data.domain.Proveedor;
import strava.server.data.domain.User;
import strava.server.data.domain.UsuarioStrava;
import strava.server.factory.GatewayFactory;
import strava.server.remote.IRemoteFacade;
import strava.server.remote.RemoteFacade;

public class MainProgram {

	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		//BasicConfigurator.configure();
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Strava Server v1 '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		GatewayFactory.getInstance().createExternalAccount("FACEBOOK", "Prueba1", "Prueba1");
		
		System.out.print("Usuario: " + UserDAO.getInstance().find("ataulfotiburcio@gmail.com") + "\n");
		System.out.print("Todos los usuarios: " + UserDAO.getInstance().getAll() + "\n");
		System.out.print(UserDAO.getInstance().find("ataulfotiburcio@gmail.com") + "\n");
	}

}
