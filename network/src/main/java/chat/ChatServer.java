package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 60000;
	public static final String HOST_ADDRESS = "0.0.0.0";
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> writerPool = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(HOST_ADDRESS, PORT));
			log("start... [port:" + PORT + "]");
			
			writerPool = new ArrayList<>();
			
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, writerPool).start();
			}
		} catch (IOException e) {
			log("error :" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Chat Server] " + message);
	}
}
