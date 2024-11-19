package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		
		/* 코드 작성 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num % 3 == 0) {
			System.out.println("3의 배수 입니다.");
		} else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
		sc.close();
	}
}