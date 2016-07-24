package de.nullpointer.bungeeplugin;

import java.util.ArrayList;

import net.md_5.bungee.api.config.ServerInfo;

public class ServerManager {
	
	static ArrayList<ServerInfo> servers = new ArrayList<>();
	
	public static void stopCheck(ServerInfo server) {
		if (servers.contains(server) & server.getPlayers().size() < 1) {
			stopServer(server);
		}
	}
	
	public static void startCheck(ServerInfo server) {
		if (!servers.contains(server)) {
			startServer(server);
		}
	}

	private static void startServer(ServerInfo server) {
		System.out.println("[ServerManager] Server " + server.getName() + " is required - start");
		servers.add(server);
		// Network stuff
		System.out.println("[ServerManager] Server " + server.getName() + " started");
	}

	private static void stopServer(ServerInfo server) {
		System.out.println("[ServerManager] Server " + server.getName() + " is not used - shutdown");
		servers.remove(server);
		// Network stuff
		System.out.println("[ServerManager] Server " + server.getName() + " stopped");
	}

}
