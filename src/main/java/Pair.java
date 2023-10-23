import java.util.List;

public class Pair extends HandValue {
    private final Card.CardValue pairValue;
    private final List<Card.CardValue> kicker;

    public Pair(Card.CardValue value, List<Card.CardValue> kicker) {
        super(HandValueType.PAIR);
        assert kicker.size() == 3;

        this.pairValue = value;
        this.kicker = kicker;
    }

    @Override
    public int handSpecificValue() {
        var value = pairValue.numericValue * factors[0];

        for (int i = 0; i < kicker.size(); i++) {
            value += kicker.get(i).numericValue * factors[i+1];
        }

        return value;
    }
}
