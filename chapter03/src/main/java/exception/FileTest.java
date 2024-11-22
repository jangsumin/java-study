package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char) data);
		} catch (FileNotFoundException e) { // checked-exception, 예외 처리를 강제한다.
			// e.printStackTrace(); // 콘솔이 없는 경우에는 사용하지 않는 것이 좋다.
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			// 지역 변수의 문제가 있다.
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				System.out.println("error: " + e);
			} 
		}
	}

}
