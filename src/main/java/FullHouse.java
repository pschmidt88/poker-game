
public class FullHouse extends HandValue {
    private final Card.CardValue triplet;
    private final Card.CardValue pair;

    public FullHouse(Card.CardValue triplet, Card.CardValue pair) {
        super(HandValueType.FULL_HOUSE);
        this.triplet = triplet;
        this.pair = pair;
    }

    @Override
    public int handSpecificValue() {
        return triplet.numericValue * factors[0] + pair.numericValue * factors[1];
    }
}
