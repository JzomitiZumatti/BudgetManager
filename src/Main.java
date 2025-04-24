public class Main {
    public static void main(String[] args) {
        double initialBalance = 0.00;
        MenuController menuController = new MenuController(new FinanceManager(initialBalance), new ConsoleIO());
        menuController.start();
    }
}
