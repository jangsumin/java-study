package exception;

public class MyException extends Exception {
	public MyException() {
		super("MyException Thrown"); // 부모인 Exception의 기본 생성자 호출
	}
	
	public MyException(String message) { // 생성자 오버로
		super(message);
	}
}
