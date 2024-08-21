import java.time.LocalDate;

public class UserProfileTest {
    public static void main(String[] args) {
        // Créer un profil utilisateur
        UserProfile userProfile = new UserProfile("John Doe", 1000.00);
        System.out.println("Current date: " + LocalDate.now());

        // Tester les getters
        System.out.println("Nom de l'utilisateur : " + userProfile.getUserName());
        System.out.println("Budget mensuel : " + userProfile.getMonthlyBudget());

        // Ajout de dépenses
        userProfile.addExpense("Groceries", 200.00, ExpenseCategory.FOOD_AND_DINING, LocalDate.of(2024, 8, 1));
        userProfile.addExpense("Taxi", 50.00, ExpenseCategory.TRANSPORT, LocalDate.of(2024, 8, 5));
        userProfile.addExpense("Movie", 30.00, ExpenseCategory.ENTERTAINMENT, LocalDate.of(2024, 8, 10));
        userProfile.addExpense("Electricity Bill", 100.00, ExpenseCategory.UTILITIES, LocalDate.of(2024, 8, 15));
        userProfile.addExpense("Restaurant", 150.00, ExpenseCategory.FOOD_AND_DINING, LocalDate.of(2024, 8, 20));
        userProfile.addExpense("Concert Ticket", 75.00, ExpenseCategory.ENTERTAINMENT, LocalDate.of(2024, 8, 25));

        // 1. Afficher toutes les dépenses
        System.out.println("Toutes les dépenses :");
        for (Expense expense : userProfile.getExpenses()) {
            System.out.println(expense.getDescription() + " - " + expense.getAmount() + " - " + expense.getCategory() + " - " + expense.getDate());
        }
        System.out.println();

        // 2. Afficher les dépenses par catégorie
        System.out.println("Dépenses pour la catégorie Nourriture et restauration :");
        for (Expense expense : userProfile.getExpensesByCategory(ExpenseCategory.FOOD_AND_DINING)) {
            System.out.println(expense.getDescription() + " - " + expense.getAmount() + " - " + expense.getDate());
        }
        System.out.println();

        // 3. Afficher le total dépensé ce mois-ci
        System.out.println("Total dépensé ce mois-ci : " + userProfile.getTotalSpentThisMonth());
        System.out.println();

        // 4. Afficher le budget restant
        System.out.println("Budget restant : " + userProfile.getRemainingBudget());
        System.out.println();

        // 5. Afficher les 3 catégories avec les dépenses les plus élevées
        System.out.println("Top 3 catégories par dépenses :");
        for (ExpenseCategory category : userProfile.getTopCategories()) {
            System.out.println(category);
        }
        System.out.println();

        // 6. Calculer la dépense moyenne pour une catégorie donnée
        System.out.println("Dépense moyenne pour la catégorie Transport : " + userProfile.calculateAverageSpendingPerCategory(ExpenseCategory.TRANSPORT));
    }
}
