package de.nullpointer.servercontroller.comms;

import java.io.IOException;
import java.net.ServerSocket;

import de.nullpointer.servercontroller.PropertiesReader;

/**
 * Listens for Commands coming from the BungeeCord Server for 
 * starting or stopping a Spigot server instance.
 * Not to be confused with Spigots CommandListener.
 */

public class ServerStatCommandListener {
	
	ServerSocket ssocket;
	
	public ServerStatCommandListener() {
		try {
			ssocket = new ServerSocket(PropertiesReader.getInt("port"));
			new SocketThread(ssocket.accept()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
