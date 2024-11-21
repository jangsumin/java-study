package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods2 = new Goods2();

		goods2.name = "nikon";
		goods2.price = 400000;
		goods2.countStock = 20;
		// goods2.countSold = 10;
		// 다른 클래스라 접근 안됨 
		goods2.m();

		System.out.println("상품이름:" + goods2.name + ", 가격:" + goods2.price + ", 판매량:" + goods2.getCountSold() + ", 재고량:"
				+ goods2.countStock);

	}

}
