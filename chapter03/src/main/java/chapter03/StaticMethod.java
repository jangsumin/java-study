package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		StaticMethod.m = 10;
		
		// 같은 클래스의 static 변수 접근에서 클래스 이름 생략 가능
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
		
		// 같은 클래스의 static 변수 접근에서 클래스 이름 생략 가능
		s1();
	}
	
	static void s1() {
		// n = 1;
		// 모든 인스턴스에 필드가 생기므로 그 중 어떤 n 값을 호출하는지 모른다.
		// error: static method에서는 instance 변수 접근 불가
	}
	
	static void s2() {
		
	}
	
	static void s3() {
		StaticMethod.m = 10;
	}
	
	static void s4() {
		s3();
	}

}
