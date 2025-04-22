import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> purchases = new ArrayList<>();
        float sum = 0;
        while (scanner.hasNext()) {
            String purchase = scanner.nextLine();
            purchases.add(purchase);
            sum += Float.parseFloat(purchase.substring(purchase.lastIndexOf("$") + 1));
        }

        for (String purchase : purchases) {
            System.out.print(purchase + "\n");
        }

        System.out.printf("%nTotal: $%.2f", sum);
    }
}
