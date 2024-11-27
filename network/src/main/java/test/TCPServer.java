package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// Socket에 InetSocketAddress[InetAddress(IPAddress) + port]을 바인딩 한다.
			// IPAddress: 0.0.0.0 (특정 호스트 IP를 바인딩하지 않는다.)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5001));
			
			// 3. accept
			// main 메서드를 실행하면 여기서 blocking 돼서 연결 성공이라는 텍스트가 콘솔에 나타나지 않는다.
			Socket socket = serverSocket.accept(); // blocking
			
			System.out.println("연결 성공");
			
			// 4. IO Stream 받기 
			InputStream is = socket.getInputStream();
			
			// 5. 데이터 읽기 
			// telnet이 '안녕'이라는 텍스트를 보내면 이를 byte로 변환해서 보내 올 것이고 서버소켓은 byte를 다시 변환하면 된다.
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) { // -1이면 소켓을 닫은 상태이다.
				// closed by client
				System.out.println("[server] closed by client");
				return;
			}
			
			String data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[server] receive: " + data);
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
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

}
