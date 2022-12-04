package google.server.sockets; 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * This class process the request of each client as a separated Thread.
 */
public class GoogleService extends Thread {
	private DataInputStream mailIn;
	private DataOutputStream mailOut;
	private DataInputStream passIn;
	private DataOutputStream passOut;
	private Socket tcpSocket;
	
	private static HashMap<String, String> usuariosGoogle = new HashMap<>(); 
	
	protected GoogleService() throws RemoteException {
		usuariosGoogle.putIfAbsent("PruebaG", "PruebaG");
	}
	

	public GoogleService(Socket socket) {
		try {
			this.tcpSocket = socket;
			usuariosGoogle.put("PruebaG", "123");
			this.Log();
		} catch (Exception e) {
			System.out.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	public void Log() {
		//Echo server
		try {
			this.mailIn = new DataInputStream(this.tcpSocket.getInputStream());
			this.mailOut = new DataOutputStream(this.tcpSocket.getOutputStream());
			//Read request from the client
			String data = this.mailIn.readUTF();			
			System.out.println("Correo recibido '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
			//Send response to the client
			if(usuariosGoogle.containsKey(data)) {
				this.mailOut.writeUTF("correo confirmado");
				String dataCP = data;
				System.out.println("   Enviando confirmacion de correo " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
				data ="";
				try {
					this.passIn = new DataInputStream(this.tcpSocket.getInputStream());
					this.passOut = new DataOutputStream(this.tcpSocket.getOutputStream());
					data = this.passIn.readUTF();	
					if(data!= "") {		
						System.out.println("Contrasenna recibida '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
						//Send response to the client
						if(usuariosGoogle.get(dataCP).equals(data)) {
							this.mailOut.writeUTF("password confirmada");			
							System.out.println("   Enviando confirmacion password " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
						}else {
							this.mailOut.writeUTF("password erronea");
						}
					}
				} catch (Exception e) {
					System.out.println("Error en lectura usuario google : "+e);
				}
			}else {
				this.mailOut.writeUTF("correo no confirmado");		
			}
		
		} catch (Exception e) {
			System.out.println("   # EchoService error" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (Exception e) {
				System.out.println("   # EchoService error:" + e.getMessage());
			}
		}
	}
}