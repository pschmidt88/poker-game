public class Straight extends HandValue {
    private final Card.CardValue value;

    public Straight(Card.CardValue value) {
        super(HandValueType.STRAIGHT);
        this.value = value;
    }

    @Override
    public int handSpecificValue() {
        return this.value.numericValue;
    }
}
