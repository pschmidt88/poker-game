public class FourOfAKind extends HandValue {
    private final Card.CardValue kicker;
    private final Card.CardValue value;

    public FourOfAKind(Card.CardValue value, Card.CardValue kicker) {
        super(HandValueType.FOUR_OF_A_KIND);
        this.value = value;
        this.kicker = kicker;
    }

    @Override
    public int handSpecificValue() {
        return value.numericValue * factors[0] + kicker.numericValue * factors[1];
    }
}
