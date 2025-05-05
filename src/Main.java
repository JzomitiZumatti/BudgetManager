public class Main {
    public static void main(String[] args) {
        double initialBalance = 0.00;
        FinanceManager financeManager = new FinanceManager(initialBalance);
        ConsoleIO consoleIO = new ConsoleIO(financeManager);
        MenuController menuController = new MenuController(financeManager, consoleIO);
        menuController.start();
    }
}
