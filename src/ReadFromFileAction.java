import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileAction extends AbstractMenuAction {
    private static final String FILE_NAME = "purchases.txt";

    public ReadFromFileAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            double balance = Double.parseDouble(line);
            financeManager.addIncome(balance);
            while ((line = reader.readLine()) != null) {
                String[] purchase = line.split("\\|");
                if (purchase.length != 3) continue;
                String name = purchase[1];
                double price = Double.parseDouble(purchase[2].replace(",", "."));
                Category category = Category.valueOf(purchase[0]);
                financeManager.addPurchase(name, price, category);
            }
            reader.close();
        } catch (IOException e) {
            consoleIO.printLine(Message.MSG_13);
        }
        System.out.println();
        consoleIO.printLine(Message.MSG_14);
    }
}
