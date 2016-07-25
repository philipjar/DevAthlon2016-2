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
			System.out.println("Server started successfully");
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server failed to start");
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
		
		if (!serverProcess.isAlive()) {
			System.out.println("Server stopped successfully");
			return 0;
		} else {
			System.out.println("Server failed to stop");
			return 1;
		}
	}

}
