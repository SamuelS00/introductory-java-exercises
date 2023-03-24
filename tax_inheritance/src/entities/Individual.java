package entities;

public class Individual extends TaxPayer {

    private Double healthExpenses;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double calculateTax() {
        if (getAnnualIncome() <= 20000) {
            return (getAnnualIncome() * 15 / 100) - (getHealthExpenses() * 50 / 100);
        } else {
            return (getAnnualIncome() * 25 / 100) - (getHealthExpenses() * 50 / 100);
        }
    }
}
