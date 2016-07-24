package de.nullpointer.bungeeplugin.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionHandler {

	String host;
	int port;

	Socket socket;
	PrintWriter outStream;

	public ConnectionHandler(InetSocketAddress address) {
		this.host = address.getHostName();
		this.port = address.getPort();

		buildSocket();
		buildStream();
	}

	private void buildSocket() {
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			System.err.println("[ConnectionHandler] Unable to build socket: " + e.getMessage());
		}
	}

	private void buildStream() {
		try {
			outStream = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println("[ConnectionHandler] Unable to build stream: " + e.getMessage());
		}
	}
	
	public void sendMessage(String message) {
		outStream.println(message);
	}

}
