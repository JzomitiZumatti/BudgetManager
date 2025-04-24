public class ShowBalanceAction extends AbstractMenuAction {
    public ShowBalanceAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        System.out.println();
        double balanceAfterPurchases = Math.max(0.00, financeManager.getBalance() - financeManager.getTotalExpenses());
        consoleIO.printBalance(balanceAfterPurchases);
    }
}
