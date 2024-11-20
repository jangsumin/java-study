package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 결정하였습니다. 맞추어 보세요:");
		
		// 정답 램덤하게 만들기
		Random random = new Random();
		int correctNumber = random.nextInt(100) + 1;
		
		int i = 1;
		int prevMinNum = 1;
		int prevMaxNum = 100;

		while(true) {
			/* 게임 작성 */
			System.out.println(prevMinNum + "-" + prevMaxNum);
			System.out.print(i++ + ">>");
			int num = scanner.nextInt();
			
			if (num == correctNumber) {
				System.out.println("맞췄습니다.");
				//새 게임 여부 확인하기
				System.out.print("다시 하겠습니까(y/n)>>");
				String answer = scanner.next();
				if("y".equals(answer) == false) {
					break;
				}
			} else if (num > correctNumber) {
				System.out.println("더 낮게");
				prevMaxNum = num;
			} else if (num < correctNumber) {
				System.out.println("더 높게");
				prevMinNum = num;
			}
		}
		
		scanner.close();
	}
}