package entities;

public class Product implements Comparable<Product> {

    private String name;
    private Double price;
    private Integer quantity;

    public double totalPrice() {
        return price * quantity;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + ", " + String.format("%.2f", totalPrice());
    }

    @Override
    public int compareTo(Product other) {
        return price.compareTo(other.getPrice());
    }
}