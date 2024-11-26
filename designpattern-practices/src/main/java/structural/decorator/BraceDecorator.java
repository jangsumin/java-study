package structural.decorator;

public class BraceDecorator extends Decorator {
	public BraceDecorator(Component component) {
		super(component);
		System.out.println("3.");
		System.out.println("Brace 객체 생성자 호출");
		System.out.println(component);
		// System.out.println(component.operation());
		System.out.println();
	}
	
	@Override
	public String operation() {
		System.out.println("4.");
		System.out.println("brace 호출");
		System.out.println(component.getClass());
		System.out.println();
		String text = component.operation();
		return "{" + text + "}";
	}

}
