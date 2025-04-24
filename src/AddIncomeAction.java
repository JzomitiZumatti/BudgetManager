public class AddIncomeAction extends AbstractMenuAction {
    public AddIncomeAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        System.out.println();
        double income = Double.parseDouble(consoleIO.prompt(Message.MSG_1));
        financeManager.addIncome(income);
        consoleIO.printLine(Message.MSG_2);
    }
}
