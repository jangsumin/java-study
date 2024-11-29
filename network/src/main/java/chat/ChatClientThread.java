package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	
	public ChatClientThread(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);				
			}
		} catch (IOException e) {
			ChatClient.log("에러 발생: " + e);
		}
	}
	
}
