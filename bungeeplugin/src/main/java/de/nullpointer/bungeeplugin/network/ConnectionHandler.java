package de.nullpointer.bungeeplugin.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionHandler {

	String host;
	int port;

	Socket socket;
	PrintWriter outStream;

	public ConnectionHandler(InetSocketAddress address) {
		this.host = address.getHostName();
		this.port = 25564;

		connect();
	}

	private void connect() {
		try {
			socket = new Socket(host, port);
			outStream = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println("[ConnectionHandler] Unable to build socket or stream: " + e.getMessage());
		}
	}

	@SuppressWarnings("resource")
	public boolean sendMessage(String message) {
		try {
			outStream.println(message);
			Scanner input = new Scanner(socket.getInputStream());
			if (input.hasNextLine()) {
				if (input.nextLine().equalsIgnoreCase("0")) {
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("[ConnectionHandler] Unable to send message: " + e.getMessage());
		}
		return false;
	}

}
