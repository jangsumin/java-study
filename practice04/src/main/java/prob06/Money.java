package prob06;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}
	
	public Money add(Money money) {
		return new Money(this.amount + money.amount);
	}
	
	public Money minus(Money money) {
		return new Money(this.amount - money.amount);
	}
	
	public Money multiply(Money money) {
		return new Money(this.amount * money.amount);
	}
	
	public Money divide(Money money) {
		return new Money(this.amount / money.amount);
	}
	
	public boolean equals(Money money) {
		return this.amount == money.amount;
	}
}
