package de.nullpointer.bungeeplugin.events;

import de.nullpointer.bungeeplugin.Main;
import de.nullpointer.bungeeplugin.ServerManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectEvent implements Listener {
	
	public ConnectEvent(Main plugin) {
		ProxyServer.getInstance().getPluginManager().registerListener(plugin, this);
	}
	
	@EventHandler
	public void onChange(ServerConnectEvent e) {
		ServerManager.update(e.getTarget());
	}

}
