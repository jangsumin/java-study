package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 소켓 생성
			scanner = new Scanner(System.in);
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if ("exit".equals(line)) {
					break;
				}
				
				pw.println(line); // print와 println 메서드의 역할이 완전히 다름 주의!
				String data = br.readLine();
				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<<" + data);
			}
		} catch (SocketException e) {
			log("socket exception: " + e);
		}  catch (IOException e) {
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
		System.out.println("[Echo client] " + message);
	}

}
