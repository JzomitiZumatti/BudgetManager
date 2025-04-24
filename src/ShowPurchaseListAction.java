public class ShowPurchaseListAction extends AbstractMenuAction {
    public ShowPurchaseListAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        System.out.println();
        consoleIO.printPurchaseList(financeManager.getPurchases(), financeManager.getTotalExpenses());
    }
}
