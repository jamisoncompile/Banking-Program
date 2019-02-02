package BankingProgram2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TheBank {

	public static ArrayList<BankAccounts> arr = new ArrayList<BankAccounts>();
	public static Scanner keyboard = new Scanner(System.in);
	public static BankAccounts account = new SavingsOrChecking();
	public NumberFormat f = NumberFormat.getCurrencyInstance();
	
	TheBank(Scanner sc) {
		while (sc.hasNext()) {
			BankAccounts account = new SavingsOrChecking();
			account.name = sc.next();
			account.userID = sc.next();
			account.pinNumber = sc.nextInt();
			account.accountNumber = sc.nextInt();
			account.balance = sc.nextDouble();
			account = new SavingsOrChecking(account.name, account.userID, account.pinNumber, account.accountNumber, account.balance);
			arr.add(account);
		}
	}
	
	public void endDay() throws IOException {
		PrintWriter prw = new PrintWriter("bankfile.txt");
		for (BankAccounts account : arr) 
			prw.println(account.toStringPrintWriter());
		prw.close();
	}
	
	public void addUser() {
		String name;
		String userID;
		int pinNumber;
		String accountNumberAnswer;
		int accountNumber;
		double balance;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter name of new account: ");
			name = keyboard.next();
		System.out.println("Enter the userID of the new account: ");
			userID = keyboard.next();
		System.out.println("Enter the pin number of the new account: ");
			pinNumber = keyboard.nextInt();
		System.out.println("Enter the type of account (savings or checking): ");
			accountNumberAnswer = keyboard.next();
			if(accountNumberAnswer.equalsIgnoreCase("savings")) {
				accountNumber = (int) (12000 + (Math.random()*999));
			}
			else {
				accountNumber = (int) (57000 + (Math.random()*999));
			}
		System.out.println("Enter the balance of new account: ");
			balance = keyboard.nextDouble();
		BankAccounts account = new SavingsOrChecking();
		account = new SavingsOrChecking(name, userID, pinNumber, accountNumber, balance);
		arr.add(account);
	}
	
	public void showInfo() {
		String userID;
		System.out.println("Enter user ID: ");
			userID = keyboard.next();
		for (BankAccounts account : arr)
			if (userID.equalsIgnoreCase(account.userID)) {
				if((String.valueOf(account.accountNumber)).charAt(0) == '5') {
					System.out.println("Their checking account balance is " + f.format(account.balance));
				}
				else {
					System.out.println("Their saving account balance is " + f.format(account.balance));
				}		
			}
	}
	
	public void changeBalance() {
		String userID;
		String withdrawOrDeposit;
		double depositAmount;
		double withdrawAmount;
		System.out.println("Enter user ID: ");
			userID = keyboard.next();
		for (BankAccounts account : arr)
			if (userID.equalsIgnoreCase(account.userID)) {
				System.out.println("Do you wish to 'withdraw' or 'deposit'?: ");
					withdrawOrDeposit = keyboard.next();
					if(withdrawOrDeposit.equalsIgnoreCase("deposit")) {
						System.out.println("How much to be deposited?");
							depositAmount = keyboard.nextDouble();
						account.balance = account.balance + depositAmount;
						System.out.println("New amount is " + f.format(account.balance));
					}
					else {
						System.out.println("How much to be withdrawn?");
							withdrawAmount = keyboard.nextDouble();
						account.balance = account.balance - withdrawAmount;
						System.out.println("New amount is " + f.format(account.balance));
					}
			}
	}
	
	public int menu() {
		int retval = 0;
		System.out.println("What would you like to do? "); 
		System.out.println("1) Add user"); 
		System.out.println("2) Check user balance(s)"); 
		System.out.println("3) Change user balance"); 
		System.out.println("4) Close for the day"); 
			retval = keyboard.nextInt();
		return retval;
	}
}
