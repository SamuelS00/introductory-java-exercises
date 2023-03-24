package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String name;
		String email;
		Date birthDate;
		String status;

		String productName;
		double productPrice;
		int quantity;

		Client client;
		Product product;
		OrderItem item;
		Order order;

		System.out.println("Enter client data: ");

		System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		status = sc.next();

		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		sc.nextLine();

		client = new Client(name, email, birthDate);
		order = new Order(new Date(), OrderStatus.valueOf(status), client);

		for (int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data: %n", i + 1);

			System.out.print("Product name: ");
			productName = sc.nextLine();
			System.out.print("Product price: ");
			productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity: ");
			quantity = sc.nextInt();
			sc.nextLine();

			product = new Product(productName, productPrice);
			item = new OrderItem(product, quantity, productPrice);
			order.addItem(item);

			System.out.println();
		}

		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);

		sc.close();
	}

}
