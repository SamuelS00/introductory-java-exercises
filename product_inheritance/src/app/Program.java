package app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products? ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            char productType;
            String name;
            Double price;
            String manufactureDate;
            Double customsFee;

            Product product;

            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            productType = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Price: ");
            price = sc.nextDouble();
            sc.nextLine();

            if (productType == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                manufactureDate = sc.next();

                product = new UsedProduct(name, price, manufactureDate);
            } else if (productType == 'i') {
                System.out.print("Customs fee: ");
                customsFee = sc.nextDouble();

                product = new ImportedProduct(name, price, customsFee);
            } else {
                product = new Product(name, price);
            }

            products.add(product);
            System.out.println();
        }

        System.out.println("PRICE TAGS: ");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}