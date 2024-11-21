package prob02;

public class Goods {
	private String name;
	private int price;
	private int remainCnt;
	
	public Goods(String name, int price, int remainCnt) {
		this.name = name;
		this.price = price;
		this.remainCnt = remainCnt;
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

	public int getRemainCnt() {
		return remainCnt;
	}

	public void setRemainCnt(int remainCnt) {
		this.remainCnt = remainCnt;
	}

	public void printInfo() {
		System.out.println(this.getName() + "(가격:" + this.getPrice() + "원)이 " + this.getRemainCnt() + "개 입고 되었습니다.");
	}
}