public class ShowCategoryPurchasesAction extends AbstractMenuAction {
    public ShowCategoryPurchasesAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        boolean isOn = true;
        if(financeManager.getPurchases().isEmpty()) {
            isOn = false;
            System.out.println();
            consoleIO.printLine(Message.MSG_6);
        }
        while (isOn) {
            System.out.println();
            consoleIO.printPurchaseMenuList();
            String input = consoleIO.readLine();
            System.out.println();
            int choice = 0;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                consoleIO.printLine(Message.MSG_7);
            }
            switch (choice) {
                case 1:
                    consoleIO.printPurchaseList(Category.FOOD);
                    break;
                case 2:
                    consoleIO.printPurchaseList(Category.CLOTHES);
                    break;
                case 3:
                    consoleIO.printPurchaseList(Category.ENTERTAINMENT);
                    break;
                case 4:
                    consoleIO.printPurchaseList(Category.OTHER);
                    break;
                case 5:
                    consoleIO.printAllPurchases();
                    break;
                case 6:
                    isOn = false;
                    break;
            }
        }
    }
}
