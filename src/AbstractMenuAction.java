public abstract class AbstractMenuAction implements MenuAction {
    protected final FinanceManager financeManager;
    protected final ConsoleIO consoleIO;

    protected AbstractMenuAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        this.financeManager = financeManager;
        this.consoleIO = consoleIO;
    }
}
