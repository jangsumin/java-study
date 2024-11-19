package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		
		/* 코드 작성 */
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.print(j + " ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(10 + j + " ");
			}
			System.out.println();
		}
	}
}