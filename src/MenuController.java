import java.util.HashMap;
import java.util.Map;

public class MenuController {
    private final Map<Integer, MenuAction> actions;
    ConsoleIO consoleIO;

    public MenuController(FinanceManager financeManager, ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
        this.actions = new HashMap<>();

        actions.put(1, new AddIncomeAction(financeManager, consoleIO));
        actions.put(2, new AddPurchaseAction(financeManager, consoleIO));
        actions.put(3, new ShowCategoryPurchasesAction(financeManager, consoleIO));
        actions.put(4, new ShowBalanceAction(financeManager, consoleIO));
        actions.put(5, new SaveToFileAction(financeManager, consoleIO));
        actions.put(6, new ReadFromFileAction(financeManager, consoleIO));
        actions.put(7, new SortAction(financeManager, consoleIO));
        actions.put(0, new ExitAction(consoleIO));
    }

    public void start() {
        boolean isOn = true;

        while (isOn) {
            consoleIO.printMainMenu();
            String input = consoleIO.readLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                consoleIO.printLine(Message.MSG_7);
                continue;
            }
            MenuAction action = actions.get(choice);
            if (action != null) {
                action.execute();
                if (choice == 0) {
                    isOn = false;
                }
            } else {
                consoleIO.printLine(Message.MSG_7);
            }

        }
    }
}
