package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods(String name, int price, int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCountStock() {
		return countStock;
	}
	
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public int getCountSold() {
		return countSold;
	}
	
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void printinfo() {
		System.out.println("상품이름:" + this.getName() + ", 가격:" + this.getPrice() + ", 판매량:" + this.getCountSold()
				+ ", 재고량:" + this.getCountStock());
	}
	
	public int calcDiscountPrice(float discountRate) {
		int result = price - (int) (price * discountRate);
		return result;
	}
}
