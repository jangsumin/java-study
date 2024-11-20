package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		/* 코드 작성 */
		System.out.print("금액:");
		int payment = sc.nextInt();
		for (int i = 0; i < MONEYS.length; i++) {
			System.out.print(MONEYS[i] + "원 : ");
			int amount = payment / MONEYS[i];
			payment %= MONEYS[i];
			System.out.println(amount + "개");
		}
		
		sc.close();
 	}
}