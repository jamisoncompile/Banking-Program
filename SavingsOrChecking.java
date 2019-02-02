package BankingProgram2;

import java.text.NumberFormat;

public class SavingsOrChecking extends BankAccounts{
	public NumberFormat f = NumberFormat.getCurrencyInstance();
	
	SavingsOrChecking() {
		super();
	}
	
	SavingsOrChecking(String name, String userID, int pinNumber, int accountNumber, double balance) {
		super(name, userID, pinNumber, accountNumber, balance);
	}
	
	public boolean isSavings(Object p) {
		if (p instanceof SavingsOrChecking){
			return (String.valueOf(accountNumber)).substring(0, 1) == "12";
		}
		else
			return false;
	}
	
	public boolean isChecking(Object p) {
		if (p instanceof SavingsOrChecking){
			return (String.valueOf(accountNumber)).substring(0, 1) == "57";
		}
		else
			return false;
	}
	
	public String toString() {
		String retval;
		retval = name + " " + userID + " " + pinNumber + " " + accountNumber + " " + f.format(balance);
		return retval;
	}
	
	public String toStringPrintWriter() {
		String retval;
		retval = name + " " + userID + " " + pinNumber + " " + accountNumber + " " + balance;
		return retval;
	}
}
