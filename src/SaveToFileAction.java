import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveToFileAction extends AbstractMenuAction {
    private static final String FILE_NAME = "purchases.txt";

    public SaveToFileAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        List<Purchase> purchases;
        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            writer.println(financeManager.getBalance());
            for (Category category : Category.values()) {
                purchases = financeManager.getPurchases(category);
                for (Purchase purchase : purchases) {
                    writer.printf("%s|%s|%.2f%n",
                            category.name(),
                            purchase.name(),
                            purchase.price());
                }
            }
        } catch (IOException e) {
            consoleIO.printLine(Message.MSG_12);
        }
        System.out.println();
        consoleIO.printLine(Message.MSG_11);
    }
}
