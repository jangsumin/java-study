package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello" + "World" + "Java" + 21;
		
		StringBuilder sb = new StringBuilder("Hello ").append("World ").append("Java").append(21);
		System.out.println(sb);
		
		String sf = new StringBuffer("Hello ").append("World ").append("Java").append(21).toString();
		System.out.println(sf);
		
		String s2 = "";
		// 원래 아래 반복문은 금방 수행되어야 하지만 + 연산의 비효율성 때문에 삽시간에 연산이 이뤄지지 않는다.
//		for (int i = 0; i < 1000000; i++) {
//			s2 = s2 + "h";
//		}
		
		String s4 = "abcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "     ab cd      ";
		System.out.println(s5.trim());
		
		String s6 = "abc,def,ghi";
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("---" + s5.replaceAll(" ", "") + "---");
		
		String[] tokens = s6.split(",");
		for (String s : tokens) {
			System.out.println(s);
		}
	}

}
