package strava.server.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class EchoStrava {
//TODO EL OTRO SERVIDOR SE HACE CON RMI
	public static void main(String args[]) {
		
		if (args.length < 4) {
			System.err.println(" # Usage: TCPSocketStrava [SERVER IP] [PORT] [EMAIL] [CONTRASENNA]");
			System.exit(1);
		}
		
		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);
		//argrs[2] = Message
		String mail = args[2];
		String password = args[3];

		/**
		 * NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		 * Try statement that declares one or more resources. A resource is an object that must be closed after the program is 
		 * finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, 
		 * can be used as a resource.
		 */

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream EmailR = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream EmailS = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//Send request (a Srting) to the server
			EmailS.writeUTF(mail);
			System.out.println("Enviando correo'" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + mail + "'");
			
			//Read response (a String) from the server
			String data = EmailR.readUTF();			
			System.out.println("Recepcion de correo confirmada" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			try {
				 DataInputStream PassR = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream PassS = new DataOutputStream(tcpSocket.getOutputStream());
				PassS.writeUTF(mail);
				System.out.println("Enviando correo'" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + mail + "'");
				
				//Read response (a String) from the server
				data = PassR.readUTF();			
				System.out.println("- EchoClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
							
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			System.out.println("# EchoClient: Error: " + e.getMessage());
		}
	}
}