package google.server.sockets;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class EscuchaGoogle {
	
	private static int numClients = 0;
	
	public static void main(String args[]) throws UnknownHostException {
		if (args.length < 2) {
			System.err.println(" # Usage: TCPSocketEchoServer [PORT] [IP]");
			System.exit(1);
		}
		
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[0]);
		InetAddress ServerIP = InetAddress.getByName(args[1]);
		
		/**
		 * NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		 * Try statement that declares one or more resources. A resource is an object that must be closed after the program is 
		 * finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, 
		 * can be used as a resource.
		 */
		
		//Declaration of the ServerSocket (only a port number is needed)
		try (ServerSocket tcpEchoServerSocket = new ServerSocket(serverPort,50,ServerIP);) {
			System.out.println(" - EchoServer: Waiting for connections '" + args[1] + ":" + tcpEchoServerSocket.getLocalPort() + "' ...");
			
			//The main thread is always waiting for connections
			while (true) {
				//When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
				//communicate with the client.
				new GoogleService(tcpEchoServerSocket.accept());
				System.out.println(" - GoogleServer: New client connection accepted. Client Number: " + numClients++);
			}
		} catch (Exception e) {
			System.out.println("# EchoServer: IO error:" + e.getMessage());
		}
	}
}