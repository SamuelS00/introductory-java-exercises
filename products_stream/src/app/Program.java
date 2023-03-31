package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter full file path: ");
        String pathIn = sc.next();
        sc.close();

        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
            String line = br.readLine();
            String name;
            Double price;
            Product product;

            while (line != null) {
                String[] fields = line.split(",");
                name = fields[0];
                price = Double.parseDouble(fields[1]);

                product = new Product(name, price);
                products.add(product);

                line = br.readLine();
            }

            double sumTotalProducts = products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum();

            double average = sumTotalProducts / products.size();

            Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> belowAverageProducts = products.stream()
                    .filter(p -> p.getPrice() < average)
                    .map(p -> p.getName())
                    .sorted(comparator.reversed())
                    .collect(Collectors.toList());

            System.out.println("Average: " + String.format("%.2f", average));

            belowAverageProducts.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
