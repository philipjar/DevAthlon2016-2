package de.nullpointer.bungeeplugin;

import de.nullpointer.bungeeplugin.commands.StartCommand;
import de.nullpointer.bungeeplugin.commands.StopCommand;
import de.nullpointer.bungeeplugin.events.ConnectEvent;
import de.nullpointer.bungeeplugin.events.DisconnectEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	
	@Override
	public void onEnable() {
		// Register Events
		new DisconnectEvent(this);
		new ConnectEvent(this);
		
		// Register Commands
		getProxy().getPluginManager().registerCommand(this, new StartCommand());
		getProxy().getPluginManager().registerCommand(this, new StopCommand());
		
		getLogger().info("§a" + getDescription().getName() + " on Version " + getDescription().getVersion() + " loaded!");
	}

}
