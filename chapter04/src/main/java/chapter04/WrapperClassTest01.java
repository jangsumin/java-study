package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하면 heap 상에 객체가 존재하게 된다.
		// 리터럴(literal)을 사용하면 JVM만의 Constant Pool에서 관리하게 된다.
		// 래퍼 클래스 생성자 방식은 모두 deprecated됨.
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// auto boxing이 일어나고 있는 지점 ->10이라는 기본 자료형을 객체로 감싸고 있다.
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 != j2);
		System.out.println(j1.equals(j2));
		
		// auto unboxing
		int m = j1 + 10;
		// int m = j1.intValue() + 10;
	}

}
