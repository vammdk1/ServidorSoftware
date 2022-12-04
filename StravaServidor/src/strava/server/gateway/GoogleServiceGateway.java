package strava.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;

import facebook.remote.IFacebookLogin;
import remote.IGoogleServices;

public class GoogleServiceGateway implements IGoogleServices {
	static String serverIP;
	static int serverPort;
	
	private static GoogleServiceGateway instance;
	private GoogleServiceGateway() {
		serverIP="127.0.0.2";
		serverPort=8001;
	}
		
	public static GoogleServiceGateway getInstance() {
		if(instance == null) {
			instance = new GoogleServiceGateway();
		}
		
		return instance;
	}
	
	public boolean GoogleLogin(String email, String password) {
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream EmailR = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream EmailS = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a Srting) to the server
				EmailS.writeUTF(email);
				System.out.println("Enviando correo'" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + "'");
				
				//Read response (a String) from the server
				String data = EmailR.readUTF();			
				System.out.println("Recepcion de correo confirmada " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
				if(data.equals("correo confirmado")) {
					data = "";
					try {
						 DataInputStream PassR = new DataInputStream(tcpSocket.getInputStream());
						 DataOutputStream PassS = new DataOutputStream(tcpSocket.getOutputStream());
						PassS.writeUTF(password);
						System.out.println("Enviando contrasenna'" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + password + "'");
						
						//Read response (a String) from the server
						data = PassR.readUTF();			
						System.out.println("recepcion de contrasenna confirmada: " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
						if(data.equals("password confirmada"))	{
							return true;
						}else {
							return false;
						}
					} catch (Exception e) {
						System.out.println("# error de contrasenna: Error: " + e.getMessage());
					}
				}else {
					return false;
				}
				
			} catch (Exception e) {
				System.out.println("# error correo : Error: " + e.getMessage());
			}
			return false;
		}

	@Override
	public void GoogleRegister(String arg0, String arg1) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
