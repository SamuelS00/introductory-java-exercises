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

import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter full file path: ");
        String pathIn = sc.next();

        System.out.print("Enter salary: ");
        Double salaryComp = sc.nextDouble();

        sc.close();

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader bw = new BufferedReader(new FileReader(pathIn))) {
            String line = bw.readLine();

            String name;
            String email;
            Double salary;

            Employee employee;

            while (line != null) {
                String[] fields = line.split(",");

                name = fields[0];
                email = fields[1];
                salary = Double.parseDouble(fields[2]);
                employee = new Employee(name, email, salary);

                employees.add(employee);

                line = bw.readLine();
            }

            Comparator<String> comp = (e1, e2) -> e1
                    .toUpperCase()
                    .compareTo(e2.toUpperCase());

            List<String> emails = employees.stream()
                    .filter(e -> e.getSalary() >= salaryComp)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than 2000.00");
            emails.forEach(System.out::println);

            Double sumSalary = employees.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .mapToDouble(e -> e.getSalary())
                    .reduce(0.0, (x, y) -> x + y);

            System.out
                    .println("Sum of salary of people whose name starts with 'M': "
                            + String.format("%.2f", sumSalary));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
