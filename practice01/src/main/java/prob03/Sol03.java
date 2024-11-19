package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		/* 코드 작성 */
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("수를 입력 하세요 : ");
			int num = sc.nextInt();
			
			System.out.print("결과값: ");
			
			if (num % 2 == 0) {
				int i = 0;
				int answer = 0;
				while (i++ <= num) {
					if (i % 2 == 0) answer += i;
				}
				System.out.print(answer);
			} else {
				int i = 0;
				int answer = 0;
				while (i++ <= num) {
					if (i % 2 == 1) answer += i;
				}
				System.out.print(answer);
			}
			
			System.out.println();
		}
	}
}
