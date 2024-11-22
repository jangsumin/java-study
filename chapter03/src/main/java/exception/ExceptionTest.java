package exception;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 9;
		int b = 10 - a;
		
		System.out.println("some code1...");
		
		try {
			System.out.println("some code2...");
			System.out.println("some code3...");
			int result = (1 + 2 + 3) / b;
			System.out.println("some code4...");
			System.out.println("some code5...");
		} catch (ArithmeticException e) {
			/* 예외 처리 */
			// 1. 로깅
			System.out.println("error: " + e);
			
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상 종료
			return;
		} finally {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("종료하시겠습니까?(Y|N)");
//			
//			char input = scanner.nextLine().charAt(0);
//			if (input == 'Y') return;
			
			System.out.println("자원 정리: ex) close file, socket, db connection");
		}
		
		// System.out.println(result);
		System.out.println("some code6...");
		System.out.println("some code7...");
	}

}
