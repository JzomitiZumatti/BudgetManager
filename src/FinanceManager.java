import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class FinanceManager {
    private double balance;
    private final EnumMap<Category, List<Purchase>> purchases;

    public FinanceManager(double balance) {
        this.balance = balance;
        this.purchases = new EnumMap<>(Category.class);
    }

    public void addPurchase(String name, double price, Category category) {
        purchases.computeIfAbsent(category, k -> new ArrayList<>()).add(new Purchase(name, price));
    }

    public void addIncome(double amount) {
        balance += amount;
    }

    public double getTotalExpenses() {
        return purchases.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Purchase::price)
                .sum();
    }

    public double getTotalExpenses(Category category) {
        List<Purchase> purchaseList = purchases.getOrDefault(category, new ArrayList<>());
        return purchaseList.stream().mapToDouble(Purchase::price).sum();
    }

    public List<Purchase> getPurchases() {
        List<Purchase> allPurchases = new ArrayList<>();
        for (List<Purchase> purchaseList : purchases.values()) {
            allPurchases.addAll(purchaseList);
        }
        return allPurchases;
    }

    public List<Purchase> getPurchases(Category category) {
        return new ArrayList<>(purchases.getOrDefault(category, new ArrayList<>()));
    }

    public double getBalance() {
        return balance;
    }
}
