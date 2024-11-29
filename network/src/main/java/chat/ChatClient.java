package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			// 1. 소켓 생성
			sc = new Scanner(System.in);
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 3. 닉네임 등록
			System.out.print("채팅방에서 사용할 닉네임: ");
			String nickname = sc.nextLine();
			pw.println("join:" + nickname); // join 프로토콜 수행
			pw.flush();
			
			new ChatClientThread(br).start();

			while (true) {
				String line = sc.nextLine(); // 자신이 입력하는 메시지
				
				if ("quit".equals(line)) {
					pw.println("quit"); // quit 프로토콜 수행
					break;
				}
				
				pw.println("message:" + line);
			}
		} catch (SocketException e) {
			log("소켓 예외 발생: " + e);
		}  catch (IOException e) {
			log("에러 발생: " + e);
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("클라이언트 " + message);
	}

}
