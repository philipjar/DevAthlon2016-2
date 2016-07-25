package de.nullpointer.servercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import de.nullpointer.servercontroller.util.PropertiesReader;

public class ServerWrapper {
	
	Process serverProcess;
	PrintWriter processCommander;
	
	int stopTimeout = 10000;
	
	public ServerWrapper() {
		
	}
	
	public int startServer() {
		try {
			serverProcess = Runtime.getRuntime().exec("java -jar " + PropertiesReader.getString("serverjar"));
			processCommander = new PrintWriter(serverProcess.getOutputStream());
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	public int stopServer() {
		processCommander.write("stop\n");
		try {
			serverProcess.waitFor(stopTimeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return !serverProcess.isAlive() ? 0 : 1;
	}

}
