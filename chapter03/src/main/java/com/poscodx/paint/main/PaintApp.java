package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		// point1.show();
		draw(point1);
		
		Point point2 = new Point(100, 200);
		// point2.show(true);
		draw(point2);
		point2.show(false);
		// point2.disappear();
		
		// ColorPoint point3 = new ColorPoint();
//		point3.setX(50);
//		point3.setY(100);
//		point3.setColor("red");
		ColorPoint point3 = new ColorPoint(50, 100, "red");
		draw(point3);
		
		// drawTriangle(new Triangle());
		// drawRectangle(new Rectangle());
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		draw(new GraphicText("안녕"));
		
		// instanceof 연산자
		Circle c = new Circle();
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		// System.out.println(c instanceof Rectangle);
		
		// 오류: 연산자 우측항이 클래스인 경우
		// 좌측항의 레퍼런스 타입의 hierarchy 상하위만 사용할 수 있다.
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rectangle);
		
		// 연산자 우측항이 인터페이스인 경우
		// hierarchy 상관없이 연산자를 사용할 수 있다.
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
		// Throwable은 클래스이다.
		// System.out.println(c instanceof Throwable);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}

}
