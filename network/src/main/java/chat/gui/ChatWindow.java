package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import chat.ChatServer;

public class ChatWindow {
	private static final String SERVER_IP = "127.0.0.1";
	
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String nickname;
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		// buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.BLACK);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		frame.setVisible(true);
		frame.pack();
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			this.nickname = promptForNickname(frame);
			
			updateTextArea(this.nickname + "님 안녕하세요 :)");
			
			pw.println("join:" + this.nickname);
			pw.flush();
			
			new ChatClientThread().start();
		} catch (IOException e) {
			log("error: " + e);
		}
	}

	private String promptForNickname(Frame parent) {
		Dialog dialog = new Dialog(parent, "닉네임 입력", true);
		dialog.setSize(300, 150);
		dialog.setLayout(new FlowLayout());

		Label label = new Label("대화방에서 사용할 닉네임 :");
		TextField textField = new TextField(20);
		Button submitButton = new Button("Submit");

		submitButton.addActionListener(e -> dialog.dispose());

		dialog.add(label);
		dialog.add(textField);
		dialog.add(submitButton);

		dialog.setVisible(true);

		return textField.getText().trim();
	}

	private void sendMessage() {
		String message = textField.getText();
		
		if ("quit".equals(message)) {
			finish();
		}
		
		pw.println("message:" + message);
		textField.setText("");
		textField.requestFocus();

		// ChatClientThread에서 서버로부터 받은 메세지가 있다고 가정하고 작성하는 코드
		// 나중에 변경해야 하는 코드
		updateTextArea(nickname +  "님: " + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		// quit 프로토콜 구현
		pw.println("quit");
		pw.flush();
		
		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// exit Java application
		System.exit(0);
	}

	public class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				String line = null;
				while ((line = br.readLine()) != null) {
					updateTextArea(line);
				}
			} catch (IOException e) {
				log("error: " + e);
			}
		}
	}

	private static void log(String message) {
		System.out.println("[Chat Client] " + message);
	}
}
