package BankingProgram2;

import java.text.NumberFormat;

public abstract class BankAccounts {
	public String name;
	public String userID;
	public int pinNumber;
	public int accountNumber;
	public double balance;
	
	BankAccounts() {
		
	}
	
	BankAccounts(String name, String userID, int pinNumber, int accountNumber, double balance) {
		this.name = name;
		this.userID = userID;
		this.pinNumber = pinNumber;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public abstract String toStringPrintWriter();
	
	public abstract String toString();
}
