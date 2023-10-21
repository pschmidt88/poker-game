public record Card(
        CardSuit suit,
        CardValue value
) implements Comparable<Card> {

    public enum CardSuit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum CardValue {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14),
        ;

        public final int numericValue;

        CardValue(int numericValue) {
            this.numericValue = numericValue;
        }
    }

    @Override
    public int compareTo(Card o) {
        return this.value.compareTo(o.value) * -1;
    }
}
