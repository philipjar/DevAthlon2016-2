package de.nullpointer.bungeeplugin.events;

import de.nullpointer.bungeeplugin.Main;
import de.nullpointer.bungeeplugin.ServerManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class DisconnectEvent implements Listener {

	public DisconnectEvent(Main plugin) {
		ProxyServer.getInstance().getPluginManager().registerListener(plugin, this);
	}

	@EventHandler
	public void onDisconnect(ServerDisconnectEvent e) {
		ServerManager.stopCheck(e.getTarget());
	}
}
