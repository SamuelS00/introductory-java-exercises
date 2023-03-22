package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<TaxPayer> taxPayers = new ArrayList<>();

        double totalTax = 0.00;

        for (int i = 0; i < n; i++) {
            TaxPayer taxPayer = null;

            System.out.printf("Tax payer #%d data: %n", (i + 1));
            System.out.print("Individual or company (i/c)? ");
            char taxPayerType = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double annualIncome = sc.nextDouble();
            sc.nextLine();

            if (taxPayerType == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                sc.nextLine();

                taxPayer = new Individual(name, annualIncome, healthExpenditures);
            }
            
            if (taxPayerType == 'c') {
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                sc.nextLine();

                taxPayer = new Company(name, annualIncome, numberEmployees);
            }

            if (taxPayer != null) {
                taxPayers.add(taxPayer);
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");

        for (TaxPayer taxPayer : taxPayers) {
            System.out.println(
                taxPayer.getName() 
                + ": $ " 
                + String.format("%.2f", taxPayer.calculateTax())
            );
            totalTax += taxPayer.calculateTax();
        }

        System.out.printf("TOTAL TAXES: $ %.2f%n", totalTax);
        
        sc.close();
    }
}
