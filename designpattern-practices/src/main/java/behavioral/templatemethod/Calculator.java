package behavioral.templatemethod;

import java.util.Scanner;

public class Calculator {
	
	// add와 substract 메서드는 서로 겹치는 부분이 많다.
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1, val2) > ");
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();
		int result = val1 + val2;
		
		System.out.println(result);
	}
	
	public void substract() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1, val2) > ");
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();
		int result = val1 - val2;
		
		System.out.println(result);
	}	
}
