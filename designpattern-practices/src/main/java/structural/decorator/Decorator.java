package structural.decorator;

public abstract class Decorator extends Component {
	protected Component component;
	
	public Decorator(Component component) {
		this.component = component;
//		System.out.println("부모 생성자 호출");
//		System.out.println(this.component.getClass());
	}
}
