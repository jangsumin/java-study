package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(this.accountNo + " 계좌가 개설 되었습니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void save(int money) {
		setBalance(this.getBalance() + money);
		System.out.println(this.accountNo + " 계좌에 " + money + "만원이 입금 되었습니다.");
	}
	
	public void deposit(int money) {
		if (this.getBalance() < money) {
			System.out.println("계좌에 잔액이 부족하여 출금이 불가능합니다.");
			return;
		}
		
		setBalance(this.getBalance() - money);
		System.out.println(this.accountNo + " 계좌에 " + money + "만원이 출금 되었습니다.");
	}
	
}
