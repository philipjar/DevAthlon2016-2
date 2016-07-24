package de.nullpointer.bungeeplugin;

import java.util.ArrayList;

import net.md_5.bungee.api.config.ServerInfo;

public class ServerManager {

	static ArrayList<ServerInfo> allServers = new ArrayList<>();

	public static void update(ServerInfo server) {

		if (!allServers.contains(server)) {
			System.out.println("Server " + server.getName() + " is requested - start");
			addServer(server);
		}

		for (ServerInfo sInfo : allServers) {
			if (sInfo.getPlayers().size() < 1) {
				System.out.println("Server " + server.getName() + " is empty - shutdown");
				removeServer(sInfo);
			}
		}
	}

	private static void addServer(ServerInfo server) {
		
		allServers.add(server);
		// Send start massage to server

	}

	private static void removeServer(ServerInfo server) {
		
		allServers.remove(server);
		// Send stop message to server

	}

}
