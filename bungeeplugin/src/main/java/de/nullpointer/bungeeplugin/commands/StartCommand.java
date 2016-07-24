package de.nullpointer.bungeeplugin.commands;

import de.nullpointer.bungeeplugin.ServerManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class StartCommand extends Command{
	
	public StartCommand() {
		super("start");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender commandSender, String[] args) {
		try {
			ServerManager.startServer(ProxyServer.getInstance().getServerInfo(args[0]));
		} catch (Exception e) {commandSender.sendMessage("Server not found!");}
	}

}
