package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods("nikon", 400000, 20, 10);
		
//		goods.name = "nikon";
//		goods.price = 400000;
//		goods.countStock = 20;
//		goods.countSold = 10;

//		System.out.println("상품이름:" + goods.getName() + ", 가격:" + goods.getPrice() + ", 판매량:" + goods.getCountSold()
//				+ ", 재고량:" + goods.getCountStock());
		
		goods.printinfo();
		
		goods.setPrice(400000);
		System.out.println(goods.calcDiscountPrice(0.1f) + "원");
	}

}
