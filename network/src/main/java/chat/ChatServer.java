package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 50001;
	public static final String HOST_ADDRESS = "0.0.0.0";
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> writerPool = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(HOST_ADDRESS, PORT));
			log("시작 [포트 번호:" + PORT + "]");
			
			writerPool = new ArrayList<>(); // 모든 스레드가 공유할 Writer Pool로, 각 스레드의 pw 객체를 여기에 저장한다.
			
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, writerPool).start();
			}
		} catch (IOException e) {
			log("에러 :" + e);
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
		System.out.println("서버 " + message);
	}
}
