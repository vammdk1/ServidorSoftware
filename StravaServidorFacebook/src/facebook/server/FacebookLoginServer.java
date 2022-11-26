package facebook.server;

import java.rmi.Naming;

import facebook.remote.FacebookLoginService;
import facebook.remote.IFacebookLogin;

public class FacebookLoginServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];	
		
		try {
			IFacebookLogin remoteObject = FacebookLoginService.getInstance();
			Naming.rebind(name, remoteObject);
			System.out.println(" * Facebook Login Server '" + name + "' started!!");
		} catch (Exception e) {
			System.out.println(" # Facebook Login Server: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
