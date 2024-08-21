import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserProfile {
    private String userName;
    private double monthlyBudget;
    private List<Expense> expenses;

    public UserProfile(String userName, double monthlyBudget) {
        this.userName = userName;
        this.monthlyBudget = monthlyBudget;
        this.expenses = new ArrayList<>();
    }


    // Méthode pour ajouter une dépense avec une date spécifiée
    public void addExpense(String description, double amount, ExpenseCategory category, LocalDate date) {
        Expense expense = new Expense(description, amount, category, date);
        this.expenses.add(expense);
        if (getRemainingBudget() < 0) {
            System.out.println("Warning: Budget exceeded!");
        }
    }

    // Méthode pour obtenir les dépenses par catégorie
    public List<Expense> getExpensesByCategory(ExpenseCategory category) {
        return this.expenses.stream()
                .filter(expense -> expense.getCategory() == category)
                .collect(Collectors.toList());
    }

    // Méthode pour obtenir le total des dépenses du mois en cours
    public double getTotalSpentThisMonth() {
        LocalDate now = LocalDate.now();
        return this.expenses.stream()
                .filter(expense -> expense.getDate().getMonth() == now.getMonth() &&
                        expense.getDate().getYear() == now.getYear())
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Méthode pour obtenir le budget restant pour le mois en cours
    public double getRemainingBudget() {
        return this.monthlyBudget - getTotalSpentThisMonth();
    }

    // Méthode pour obtenir les 3 catégories avec les dépenses les plus élevées
    public List<ExpenseCategory> getTopCategories() {
        return this.expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)))
                .entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    // Méthode pour calculer la dépense moyenne par catégorie
    public double calculateAverageSpendingPerCategory(ExpenseCategory category) {
        return getExpensesByCategory(category).stream()
                .mapToDouble(Expense::getAmount)
                .average()
                .orElse(0);
    }

    // Getters
    public String getUserName() {
        return userName;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
