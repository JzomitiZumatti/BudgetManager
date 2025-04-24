public class ExitAction extends AbstractMenuAction {
    public ExitAction(ConsoleIO consoleIO) {
        super(null, consoleIO);
    }

    @Override
    public void execute() {
        System.out.println();
        consoleIO.printLine(Message.MSG_8);
    }
}
