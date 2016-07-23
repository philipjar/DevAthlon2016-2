package de.nullpointer.bungeeplugin;

import de.nullpointer.bungeeplugin.events.LoginEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	@Override
	public void onEnable() {
		loadEvents();
		getLogger().info(getDescription().getName() + " on Version " + getDescription().getVersion() + " loaded!");
	}

	private void loadEvents() {
		getProxy().getPluginManager().registerListener(this, new LoginEvent());
	}

}
