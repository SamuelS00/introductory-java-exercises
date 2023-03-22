package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import service.CalculationService;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("what is the input file path? ");
        String pathIn = sc.next();

        System.out.print("what is the output file path? ");
        String pathOut = sc.next();

        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn));
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
            String line = br.readLine();
            String name;
            double price;
            int quantity;
            Product product;

            while (line != null) {
                String[] fields = line.split(",");
                name = fields[0];
                price = Double.parseDouble(fields[1]);
                quantity = Integer.parseInt(fields[2]);
                product = new Product(name, price, quantity);
                products.add(product);

                bw.write(product.toString());
                bw.newLine();

                line = br.readLine();
            }

            Product max = CalculationService.max(products);
            System.out.println("most expensive product: " + max.toString());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

}