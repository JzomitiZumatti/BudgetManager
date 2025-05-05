import java.util.List;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner = new Scanner(System.in);
    private final FinanceManager financeManager; // Add reference to FinanceManager

    public ConsoleIO(FinanceManager financeManager) {
        this.financeManager = financeManager;
    }

    public void printMainMenu() {
        System.out.print(Message.MSG_0);
    }

    public void printPurchaseMenu() {
        System.out.print(Message.MSG_9);
    }

    public void printPurchaseMenuList() {
        System.out.print(Message.MSG_10);
    }

    public String prompt(Message message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void printLine(Message message) {
        System.out.println(message);
        System.out.println();
    }

    public void printLineWithoutNextLine(Message message) {
        System.out.println(message);
    }

    public void printBalance(double amount) {
        System.out.printf("Balance: $%.2f%n%n", amount);
    }

    public void printPurchaseList(Category category) {
        List<Purchase> purchases = financeManager.getPurchases(category); // Use instance
        double totalExpenses = financeManager.getTotalExpenses(category); // Use instance
        System.out.println(category.toString() + ":");
        if (purchases.isEmpty()) {
            System.out.println(Message.MSG_6);
        } else {
            for (Purchase purchase : purchases) {
                System.out.printf("%s $%.2f%n", purchase.name(), purchase.price());
            }
            System.out.printf("Total sum: $%.2f%n", totalExpenses);
        }
    }

    public void printAllPurchases() {
        List<Purchase> allPurchases = financeManager.getPurchases();
        if (allPurchases.isEmpty()) {
            System.out.println(Message.MSG_6);
        } else {
            System.out.println("All:");
            for (Purchase purchase : allPurchases) {
                System.out.printf("%s $%.2f%n", purchase.name(), purchase.price());
            }
            System.out.printf("Total sum: $%.2f%n", financeManager.getTotalExpenses());
        }
    }

}