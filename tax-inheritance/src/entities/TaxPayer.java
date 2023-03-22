package entities;

public abstract class TaxPayer {
    
    private String name;
    private Double annualIncome;

    protected TaxPayer() {
    }

    protected TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return this.annualIncome;
    }

    public abstract Double calculateTax();
}