package de.nullpointer.bungeeplugin.events;

import de.nullpointer.bungeeplugin.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class DisconnectEvent implements Listener {

	public DisconnectEvent(Main plugin) {
		ProxyServer.getInstance().getPluginManager().registerListener(plugin, this);
	}

	@EventHandler
	public void onLogin(ServerDisconnectEvent e) {
		System.out.println(
				"Player: " + e.getPlayer().getDisplayName() + " has been disconnected from " + e.getTarget().getName());

	}
}
