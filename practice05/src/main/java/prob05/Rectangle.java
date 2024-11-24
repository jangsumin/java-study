package prob05;

public class Rectangle extends Shape implements Resizable {
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	public void resize(double rate) {
		this.width *= rate;
		this.height *= rate;
	}
}
