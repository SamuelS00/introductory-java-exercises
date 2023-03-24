package app;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			System.out.println();

			Account account = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			sc.nextLine();
			account.withdraw(withdraw);
			System.out.printf("New Balance: %.2f%n", account.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();
	}
}