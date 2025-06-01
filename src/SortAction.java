import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortAction extends AbstractMenuAction {
    public SortAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        boolean isOn = true;
        while (isOn) {
            System.out.println();
            System.out.print(Message.MSG_15);
            String input = consoleIO.readLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println();
                consoleIO.printLine(Message.MSG_7);
                continue;
            }

            if (choice == 4) {
                System.out.println();
                isOn = false;
                continue;
            }

            switch (choice) {
                case 1 -> {
                    List<Purchase> sorted = sortAll();
                    System.out.println();
                    if (sorted.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                    } else {
                        System.out.println("All:");
                        sorted.forEach(p ->
                                System.out.printf("%s $%.2f%n", p.name(), p.price()));
                        System.out.printf("Total: $%.2f%n", financeManager.getTotalExpenses());
                    }
                }
                case 2 -> {
                    System.out.println();
                    System.out.println("Types:");
                    sortByType().forEach(entry ->
                            System.out.printf("%s - $%.2f%n", entry.getKey(), entry.getValue()));
                    System.out.printf("Total sum: $%.2f%n", financeManager.getTotalExpenses());
                }
                case 3 -> {
                    System.out.println();
                    System.out.print(Message.MSG_16);
                    String purchaseTypeS = consoleIO.readLine();
                    int purchaseTypeI;
                    try {
                        purchaseTypeI = Integer.parseInt(purchaseTypeS);
                    } catch (NumberFormatException e) {
                        System.out.println();
                        consoleIO.printLine(Message.MSG_7);
                        continue;
                    }
                    if (purchaseTypeI >= 1 && purchaseTypeI <= 4) {
                        Category category = switch (purchaseTypeI) {
                            case 1 -> Category.FOOD;
                            case 2 -> Category.CLOTHES;
                            case 3 -> Category.ENTERTAINMENT;
                            case 4 -> Category.OTHER;
                            default -> throw new IllegalStateException("Unexpected value: " + purchaseTypeI);
                        };
                        List<Purchase> sorted = sortCertainType(category);
                        System.out.println();
                        if (sorted.isEmpty()) {
                            consoleIO.printLineWithoutNextLine(Message.MSG_6);
                        } else {
                            System.out.println(category + ":");
                            sorted.forEach(p ->
                                    System.out.printf("%s $%.2f%n", p.name(), p.price()));
                            System.out.printf("Total sum: $%.2f%n", financeManager.getTotalExpenses(category));
                        }
                    } else {
                        System.out.println();
                        consoleIO.printLineWithoutNextLine(Message.MSG_7);
                    }
                }
                default -> {
                    System.out.println();
                    consoleIO.printLine(Message.MSG_7);
                }
            }
        }
    }

    private List<Purchase> sortAll() {
        return financeManager.getPurchases().stream()
                .sorted(Comparator.comparingDouble(Purchase::price).reversed())
                .toList();
    }

    private List<Map.Entry<Category, Double>> sortByType() {
        return Arrays.stream(Category.values())
                .collect(Collectors.toMap(
                        Function.identity(),
                        financeManager::getTotalExpenses
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Category, Double>comparingByValue(Comparator.reverseOrder()))
                .toList();
    }

    private List<Purchase> sortCertainType(Category category) {
        return financeManager.getPurchases(category).stream()
                .sorted(Comparator.comparingDouble(Purchase::price).reversed())
                .toList();
    }
}
