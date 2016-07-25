package de.nullpointer.servercontroller;

import java.net.URISyntaxException;

import de.nullpointer.servercontroller.comms.ServerStatCommandListener;
import de.nullpointer.servercontroller.util.PropertiesReader;

public class Main {
	
	static ServerWrapper server;
	static ServerStatCommandListener listener;

	public static void main(String[] args) {
		try {
			PropertiesReader.readProperties();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		server = new ServerWrapper();
		listener = new ServerStatCommandListener(server);
		listener.start();
	}

}
