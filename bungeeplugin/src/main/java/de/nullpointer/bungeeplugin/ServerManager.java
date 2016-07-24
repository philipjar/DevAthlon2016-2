package de.nullpointer.bungeeplugin;

import java.util.ArrayList;

import de.nullpointer.bungeeplugin.network.ConnectionHandler;
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

	public static void startServer(ServerInfo server) {
		System.out.println("[ServerManager] Server " + server.getName() + " is required - start");
		servers.add(server);
		if (new ConnectionHandler(server.getAddress()).sendMessage("start\n")) {
			System.out.println("[ServerManager] Server " + server.getName() + " started");
		} else {
			System.err.println("[ServerManager] Server " + server.getName() + " can not get started");
		}
	}

	public static void stopServer(ServerInfo server) {
		System.out.println("[ServerManager] Server " + server.getName() + " is not used - shutdown");
		servers.remove(server);
		if (new ConnectionHandler(server.getAddress()).sendMessage("stop\n")) {
			System.out.println("[ServerManager] Server " + server.getName() + " stopped");
		}
		System.out.println("[ServerManager] Server " + server.getName() + " can not get stopped");
	}

}
