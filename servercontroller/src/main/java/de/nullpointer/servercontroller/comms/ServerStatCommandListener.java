package de.nullpointer.servercontroller.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import de.nullpointer.servercontroller.ServerWrapper;
import de.nullpointer.servercontroller.util.PropertiesReader;

/**
 * Listens for Commands coming from the BungeeCord Server for 
 * starting or stopping a Spigot server instance.
 * Not to be confused with Spigots CommandListener.
 */

public class ServerStatCommandListener extends Thread {
	
	ServerSocket ssocket;
	Socket socket;
	PrintWriter writer;
	BufferedReader reader;
	
	ServerWrapper server;
	
	public ServerStatCommandListener(ServerWrapper server) {
		this.server = server;
		try {
			ssocket = new ServerSocket(PropertiesReader.getInt("port"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				System.out.println("Waiting for BungeeServer to connect...");
				socket = ssocket.accept();
				System.out.println("BungeeServer connected: " + socket.getInetAddress().toString());
				writer = new PrintWriter(socket.getOutputStream());
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				switch (reader.readLine().toLowerCase()) {
				case "start":
					System.out.println("Received start command from BungeeServer");
					writer.write(server.startServer());
					break;
				case "stop":
					System.out.println("Received stop command from BungeeServer");
					writer.write(server.stopServer());
					break;
				default:
					System.out.println("Received UNKNOWN command from BungeeServer");
					writer.write(2);
				}
				writer.close();
				reader.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
