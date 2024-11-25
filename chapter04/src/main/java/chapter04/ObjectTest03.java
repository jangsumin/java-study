package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello"); // Constant pool을 아예 타지 않는다.
		String s2 = new String("hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":" + s2.hashCode());  // 해시 코드를 기반으로 오버라이딩 되어 있으므로 값은 같다.
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
		
		System.out.println("========================");
		
		String s3 = "hello"; // 리터럴은 힙 영역에 값을 생성해놓고, 만약 추후에 같은 리터럴 방식의 선언이 있으면 똑같은 레퍼런스를 갖게 한다.
		String s4 = "hello";
		
		System.out.println(s3 == s4); // String 객체 생성 방식과 리터럴 방식이 다른 점을 주목해서 봐야 한다. 
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
	}

}
