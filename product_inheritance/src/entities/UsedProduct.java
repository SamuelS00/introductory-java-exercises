package entities;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class UsedProduct extends Product {

    private String manufactureDate;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {
    }

    public UsedProduct(String name, Double price, String manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public String getManufactureDate() {
        LocalDate data = LocalDate.parse(this.manufactureDate, fmt);
        return data.format(fmt);
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return getName()
                + " (used)"
                + " $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + getManufactureDate()
                + ")";
    }
}