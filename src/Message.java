public enum Message {
    MSG_0("""
            Choose your action:
            1) Add income
            2) Add purchase
            3) Show list of purchases
            4) Balance
            0) Exit
            """),
    MSG_01("Price cannot be negative"),
    MSG_1("Enter income:"),
    MSG_2("Income was added!"),
    MSG_3("Enter purchase name:"),
    MSG_4("Enter its price:"),
    MSG_5("Purchase was added!"),
    MSG_6("The purchase list is empty"),
    MSG_7("Wrong option! Try again:"),
    MSG_8("Bye!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
