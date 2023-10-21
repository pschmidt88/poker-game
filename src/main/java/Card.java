public record Card(
        CardSuit suit,
        CardValue value
) {

    public enum CardSuit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum CardValue {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
        ;
    }
}
