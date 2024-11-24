package prob04;

import java.util.Arrays;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		/* 구현하기 */
		this.top = -1;
		this.buffer = new String[capacity];
	}

	public void push(String s) {
		/* 구현하기 */
		if (top == this.buffer.length - 1) {
			resize();
			this.buffer[++top] = s;
		} else {
			this.buffer[++top] = s;			
		}
	}

	public String pop() throws MyStackException {
		/* 구현하기 */
		try {
			String s = this.buffer[top];
			this.buffer[top--] = null;
			return s;			
		} catch (Exception e) {
			throw new MyStackException("stack is empty");
		}
	}

	public boolean isEmpty() {
		/* 구현하기 */
		return top == -1;
	}

	private void resize() {
		/* 구현하기 */
		this.buffer = Arrays.copyOf(this.buffer, this.buffer.length + 1);
	}	
}