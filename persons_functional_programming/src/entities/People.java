package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class People {

    private List<Person> people = new ArrayList<>();

    public People() {
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(String name) {
        people.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name) {
        return people.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Person> getPeopleByAge(int age) {
        return people.stream()
                .filter(person -> person.getAge() == age)
                .collect(Collectors.toList());
    }

    public double getAverageAge() {
        return people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public Integer getTotalPeople() {
        return people.size();
    }

    public void printPeople(Consumer<Person> printer) {
        people.forEach(printer);
    }
}
