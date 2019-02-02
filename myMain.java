package BankingProgram2;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

public class myMain {

	public static void main(String[] args) throws IOException {
		File fi = new File("bankfile.txt");
		Scanner sc1 = new Scanner(fi);
		TheBank Bank1 = new TheBank(sc1);
		int choice;
		java.util.Date date = new java.util.Date();
		new Timestamp(date.getTime());
		System.out.println("Welcome!\n" + date);
		
		choice = Bank1.menu();
		Scanner keyboard = new Scanner(System.in);

		while (choice > 0) {
			switch (choice) {
			case 1:
				Bank1.addUser();
				System.out.println("What now? ");
				choice = keyboard.nextInt();
				break;
			case 2:
				Bank1.showInfo();
				System.out.println("What now? ");
				choice = keyboard.nextInt();
				break;
			case 3:
				Bank1.changeBalance();
				System.out.println("What now? ");
				choice = keyboard.nextInt();
				break;
			case 4:
				Bank1.endDay();
				java.util.Date date2 = new java.util.Date();
				new Timestamp(date2.getTime());
				System.out.println("file updated on " + date2);
				choice = -1;
				break;
			default:
				System.out.println("Error, input new choice");
				choice = keyboard.nextInt();
				break;
			}
		}	
	}	
}
