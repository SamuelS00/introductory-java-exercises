package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private static StringBuilder str = new StringBuilder();
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private Date birthdate;
    private Integer age;

    public Person(String name, Date birthdate, Integer age) {
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        str.append("name: ");
        str.append(name);
        str.append(" birthdate: ");
        str.append(formatter.format(birthdate));
        str.append(" age: ");
        str.append(age);
        return str.toString();
    }
}
