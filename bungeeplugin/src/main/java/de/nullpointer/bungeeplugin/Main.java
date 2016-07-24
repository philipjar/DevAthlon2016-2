package de.nullpointer.bungeeplugin;

import de.nullpointer.bungeeplugin.events.ConnectEvent;
import de.nullpointer.bungeeplugin.events.DisconnectEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	
	@Override
	public void onEnable() {
		new DisconnectEvent(this);
		new ConnectEvent(this);
		getLogger().info("§a" + getDescription().getName() + " on Version " + getDescription().getVersion() + " loaded!");
	}

}
