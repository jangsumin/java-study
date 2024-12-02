package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// 익명 클래스를 쓸 수도 있고 람다 함수를 쓸 수도 있다.
		// 자바에서는 함수를 파라미터로 넘길 수 없다.
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("clicked");
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		// 키보드 엔터 입력 이벤트에 반응하기 
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
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		// 1. 서버 연결 작업
		// 2. IO Stream Set
		// 3. JOIN Protocol
		// 4. ChatClientThread 생성

	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현: " + message);
		
		textField.setText(""); // 텍스트 보내고 비우기
		textField.requestFocus();
		
		// ChatClientThread에서 서버로부터 받은 메세지가 있다고 가정하고 작성하는 코드
		// 나중에 변경해야 하는 코드
		updateTextArea("아무개: " + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		// quit 프로토콜 구현
		
		// exit Java application
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			updateTextArea("....");
		}
	}
}
