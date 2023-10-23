public class StraightFlush extends HandValue {
    private final Card.CardValue straightValue;

    public StraightFlush(Card.CardValue straightValue) {
        super(HandValueType.STRAIGHT_FLUSH);
        this.straightValue = straightValue;
    }

    @Override
    public int handSpecificValue() {
        return straightValue.numericValue * factors[0];
    }
}
