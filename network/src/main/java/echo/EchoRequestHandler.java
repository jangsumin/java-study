package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	
 	public EchoRequestHandler(Socket socket) {
 		this.socket = socket;
 	}
 	
 	@Override
 	public void run() {
 		try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while (true) {
				String data = br.readLine();
				if (data == null) {
					log("closed by client");
					break;
				}
				
				log("received: " + data);
				pw.println(data);
			}
		} catch (SocketException e) {
			log("socket exception: " + e);
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();											
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 	}
 	
 	public static void log(String message) {
 		System.out.println("[Echo Server] " + message);
 	}
}
