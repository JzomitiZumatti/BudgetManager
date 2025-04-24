import java.util.List;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.print(Message.MSG_0);
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

    public void printBalance(double amount) {
        System.out.printf("Balance: $%.2f%n%n", amount);
    }

    public void printPurchaseList(List<Purchase> purchases, double totalExpenses) {
        if (purchases.isEmpty()) {
            System.out.println(Message.MSG_6);
        } else {
            for (Purchase purchase : purchases) {
                System.out.printf("%s $%.2f%n", purchase.name(), purchase.price());
            }
            System.out.printf("Total sum: $%.2f%n", totalExpenses);
        }
        System.out.println();
    }
}
