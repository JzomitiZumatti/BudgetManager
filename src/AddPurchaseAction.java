public class AddPurchaseAction extends AbstractMenuAction {
    public AddPurchaseAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        System.out.println();
        String name = consoleIO.prompt(Message.MSG_3);
        double price = Double.parseDouble(consoleIO.prompt(Message.MSG_4));
        financeManager.addPurchase(name, price);
        consoleIO.printLine(Message.MSG_5);
    }
}
