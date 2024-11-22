package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		setX(x);
//		setY(y);
		super(x, y); // 부모에 있는 기본 생성자를 그대로 사용, 그런데 늘 상단에 써야 한다.
		this.color = color; // 굳이 같은 클래스에 생성되어 있는 setColor 메서드는 쓰지 않아도 된다.
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// super.show();
		// 부분 기능 재구현: 부모의 기능을 이용하기 때문에
		System.out.println("Point[x=" + getX() + ", y=" + getY() + ", color=" + color + "]를 그렸습니다.");
	}

	@Override
	public void draw() {
		show();
	}
}
