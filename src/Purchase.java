public record Purchase(String name, double price) {
    public Purchase {
        if (price < 0) throw new IllegalArgumentException(String.valueOf(Message.MSG_01));
    }
}
