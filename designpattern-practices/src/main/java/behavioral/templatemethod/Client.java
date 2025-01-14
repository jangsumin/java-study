package behavioral.templatemethod;

public class Client {

	public static void main(String[] args) {
		// Calculator 클래스가 커지는 단점이 있다.
//		new Calculator().add();
//		new Calculator().substract();
		
		AbstractCalculate ac = new MultiplyCacluate();
		ac.templateMethod();
		
		ac = new DivideCalculate();
		ac.templateMethod();
	}

}
