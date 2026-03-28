import java.io.Serializable;

public class Expense implements Serializable {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return category + " : Rs. " + amount;
    }
}