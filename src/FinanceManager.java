import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private double balance;
    private final List<Purchase> purchases;

    public FinanceManager(double balance) {
        this.balance = balance;
        this.purchases = new ArrayList<>();
    }

    public void addPurchase(String name, double price) {
        purchases.add(new Purchase(name, price));
    }

    public void addIncome(double amount) {
        balance += amount;
    }

    public double getTotalExpenses() {
        return purchases.stream().mapToDouble(Purchase::price).sum();
    }

    public List<Purchase> getPurchases() {
        return new ArrayList<>(purchases);
    }

    public double getBalance() {
        return balance;
    }
}
