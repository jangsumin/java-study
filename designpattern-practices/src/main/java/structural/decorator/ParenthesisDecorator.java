package structural.decorator;

public class ParenthesisDecorator extends Decorator {
	public ParenthesisDecorator(Component component) {
		super(component);
		System.out.println("2.");
		System.out.println("Parenthesis 객체 생성자 호출");
		System.out.println(component);
		// System.out.println(component.operation());
		System.out.println();
	}
	
	@Override
	public String operation() {
		System.out.println("5.");
		System.out.println("parenthesis 호출");
		System.out.println(component.getClass());
		System.out.println();
		String text = component.operation();
		return "(" + text + ")";
	}

}
