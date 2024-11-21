package prob02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		StringTokenizer st;
		for (int i = 0; i < COUNT_GOODS; i++) {
			st = new StringTokenizer(scanner.nextLine());
			
			String name = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			int remainCnt = Integer.parseInt(st.nextToken());
			
			goods[i] = new Goods(name, price, remainCnt);
		}

		// 상품 출력
		for (int i = 0; i < COUNT_GOODS; i++) {
			goods[i].printInfo();
		}
		
		scanner.close();
	}
}