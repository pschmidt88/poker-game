public class TwoPairs extends HandValue {

    private final Card.CardValue firstPairValue;
    private final Card.CardValue secondPairValue;
    private final Card.CardValue kicker;

    protected TwoPairs(Card.CardValue firstPairValue, Card.CardValue secondPairValue, Card.CardValue kicker) {
        super(HandValueType.TWO_PAIRS);
        this.firstPairValue = firstPairValue;
        this.secondPairValue = secondPairValue;
        this.kicker = kicker;
    }

    @Override
    public int handSpecificValue() {
        return firstPairValue.numericValue * factors[0]
                + secondPairValue.numericValue * factors[1]
                + kicker.numericValue * factors[2];
    }
}
