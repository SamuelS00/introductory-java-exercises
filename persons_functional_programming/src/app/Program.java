package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.People;
import entities.Person;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter file path: ");
        String path = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            People people  = new People();
            Person person;
            String name;
            Date birthdate;
            int age;

            while (line != null) {
                String[] fields = line.split(",");
                name = fields[0];
                birthdate = sdf.parse(fields[1]);
                age = Integer.parseInt(fields[2]);
                person = new Person(name, birthdate, age);

                people.addPerson(person);
                line = br.readLine();
            }

            System.out.println();
            System.out.println("Total people: " + people.getTotalPeople());
            System.out.println("Average age: " + people.getAverageAge());
            System.out.println("People aged 28 years: " + people.getPeopleByAge(28));
            System.out.println("Search by name: " + people.getPerson("João Pedro"));
            System.out.println();
        
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
