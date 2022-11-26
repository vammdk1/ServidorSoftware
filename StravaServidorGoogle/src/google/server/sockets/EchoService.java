package google.server.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * This class process the request of each client as a separated Thread.
 */
public class EchoService extends Thread {
	private DataInputStream mailIn;
	private DataOutputStream mailOut;
	private DataInputStream passIn;
	private DataOutputStream passOut;
	private Socket tcpSocket;

	public EchoService(Socket socket) {
		try {
			this.tcpSocket = socket;
		  
			this.start();
		} catch (Exception e) {
			System.out.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		//Echo server
		try {
			this.mailIn = new DataInputStream(this.tcpSocket.getInputStream());
			this.mailOut = new DataOutputStream(this.tcpSocket.getOutputStream());
			//Read request from the client
			String data = this.mailIn.readUTF();			
			System.out.println("Correo recibido '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
			//Send response to the client
			this.mailOut.writeUTF("correo confirmado");			
			System.out.println("   Enviando confirmacion " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
			data ="";
			try {
				this.passIn = new DataInputStream(this.tcpSocket.getInputStream());
				this.passOut = new DataOutputStream(this.tcpSocket.getOutputStream());
				data = this.passIn.readUTF();	
				if(data!= "") {		
					System.out.println("Contrasenna recibida '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
					//Send response to the client
					this.mailOut.writeUTF("password confirmada");			
					System.out.println("   Enviando confirmacion " + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
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