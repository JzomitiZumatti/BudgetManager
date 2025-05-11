public enum Message {
    MSG_0("""
            Choose your action:
            1) Add income
            2) Add purchase
            3) Show list of purchases
            4) Balance
            5) Save
            6) Read
            0) Exit
            """),
    MSG_01("Price cannot be negative"),
    MSG_1("Enter income:"),
    MSG_2("Income was added!"),
    MSG_3("Enter purchase name:"),
    MSG_4("Enter its price:"),
    MSG_5("Purchase was added!"),
    MSG_6("The purchase list is empty!"),
    MSG_7("Wrong option! Try again:"),
    MSG_8("Bye!"),
    MSG_9("""
            Choose the type of purchase
            1) Food
            2) Clothes
            3) Entertainment
            4) Other
            5) Back
            """),
    MSG_10("""
            Choose the type of purchases
            1) Food
            2) Clothes
            3) Entertainment
            4) Other
            5) All
            6) Back
            """),
    MSG_11("Purchases were saved!"),
    MSG_12("An error occurred while saving the file."),
    MSG_13("An error occurred while reading the file."),
    MSG_14("Purchases were loaded!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
