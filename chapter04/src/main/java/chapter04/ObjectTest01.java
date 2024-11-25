package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass(); // reflection
		System.out.println(klass); // 객체를 일반적으로 print하고자 할 때, toString()이라는 메서드가 자동으로 붙는다.
		
		System.out.println(point.hashCode()); // address 기반의 해싱값, 실제 address나 reference는 아니다.
		
		System.out.println(point.toString()); // getClass().toString() + "@" + hashCode()
		System.out.println(point);
		
		// System.out.println(Integer.toHexString(705927765));
	}

}
