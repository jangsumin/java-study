package structural.decorator;

public class ConcreteComponent extends Component {
	private String text;
	
	public ConcreteComponent(String text) {
		this.text = text;
		System.out.println("1.");
		System.out.println("Concrete 객체 생성자 호출");
		System.out.println(this.text);
		System.out.println();
	}

	@Override
	public String operation() {
		return text;
	}

}
