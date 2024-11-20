package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] intArray = new int[5];

		/* 코드 작성 */
		System.out.println("5개의 숫자를 입력하세요.");
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		System.out.println("평균은 " + getAvg(intArray) + "입니다.");
		
		sc.close();
	}
	
	public static double getAvg(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) sum += arr[i];
		return sum / arr.length;
	}
}
