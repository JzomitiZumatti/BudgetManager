public class AddPurchaseAction extends AbstractMenuAction {
    public AddPurchaseAction(FinanceManager financeManager, ConsoleIO consoleIO) {
        super(financeManager, consoleIO);
    }

    @Override
    public void execute() {
        boolean isOn = true;
        while (isOn) {
            System.out.println();
            consoleIO.printPurchaseMenu();
            String input = consoleIO.readLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                consoleIO.printLine(Message.MSG_7);
                continue;
            }

            if (choice == 5) {
                System.out.println();
                isOn = false;
                continue;
            }

            switch (choice) {
                case 1, 2, 3, 4 -> {
                    Category category = switch (choice) {
                        case 1 -> Category.FOOD;
                        case 2 -> Category.CLOTHES;
                        case 3 -> Category.ENTERTAINMENT;
                        case 4 -> Category.OTHER;
                        default -> throw new IllegalStateException("Unexpected value: " + choice);
                    };
                    System.out.println();
                    String name = consoleIO.prompt(Message.MSG_3);
                    double price = Double.parseDouble(consoleIO.prompt(Message.MSG_4));
                    financeManager.addPurchase(name, price, category);
                    consoleIO.printLineWithoutNextLine(Message.MSG_5);
                }
                default -> consoleIO.printLine(Message.MSG_7);
            }
        }
    }

}
