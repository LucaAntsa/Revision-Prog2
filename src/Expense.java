// Expense.java
import java.time.LocalDate;

public class Expense {
    private String description;
    private double amount;
    private ExpenseCategory category;
    private LocalDate date;

    public Expense(String description, double amount, ExpenseCategory category, LocalDate date) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }
}
