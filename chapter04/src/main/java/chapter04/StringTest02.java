package chapter04;

public class StringTest02 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		
		try {
			System.out.println(equalsHello(null));			
		} catch (Exception e) {
			System.out.println("이번에는 그냥 넘어가");
		}
	}
	
	private static boolean equalsHello(String s) {
		// 아래처럼 하면 s에 null 값이 들어갔을 때 nullPointerException 발
		// return s.equals("hello");
		return "hello".equals(s);
		
	}

}
