package de.nullpointer.servercontroller;

import de.nullpointer.servercontroller.comms.ServerStatCommandListener;

public class Main {
	
	static ServerWrapper server;
	static ServerStatCommandListener listener;

	public static void main(String[] args) {
		server = new ServerWrapper();
		listener = new ServerStatCommandListener(server);
		listener.start();
	}

}
