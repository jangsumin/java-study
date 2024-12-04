package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> sharedWriterPool;

	public ChatServerThread(Socket socket, List<Writer> sharedWriterPool) {
 		this.socket = socket;
 		this.sharedWriterPool = sharedWriterPool;
	}

	@Override
	public void run() {
		try {
			// 2. 스트림 얻기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 3. 요청 처리
			while (true) {
				String request = br.readLine();
				
				if (request == null) {
					ChatServer.log("클라이언트로부터 종료");
					removeWriter(pw);
					break;
				}
				
				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1], pw);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (SocketException e) {
			ChatServer.log("소켓 예외 발생: " + e);
		} catch (IOException e) {
			ChatServer.log("에러 발생: " + e);
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
	
	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;
		
		PrintWriter pw = (PrintWriter) writer;
		
		String data = nickname + "님이 입장하였습니다.";
		broadcast(data, pw);
		
		addWriter(pw);
		
		pw.println("join:ok");
		pw.flush();
	}
	
	private void addWriter(Writer writer) {
		synchronized(sharedWriterPool) {
			sharedWriterPool.add(writer);
		}
	}
	
	private void doMessage(String message, PrintWriter self) {
		String data = this.nickname + "님: " + message;
		broadcast(data, self);
	}
	
	private void broadcast(String message, PrintWriter self) {
		synchronized(sharedWriterPool) {
			for (Writer writer : sharedWriterPool) {
				PrintWriter pw = (PrintWriter) writer;
				if (pw.equals(self)) continue;
				pw.println(message);
				pw.flush();
			}	
		}
	}
	
	private void doQuit(Writer writer) {
		PrintWriter pw = (PrintWriter) writer;
		
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data, pw);

		removeWriter(pw);
	}
	
	private void removeWriter(Writer writer) {
		synchronized(sharedWriterPool) {			
			sharedWriterPool.remove(writer);
		}
	}
}
