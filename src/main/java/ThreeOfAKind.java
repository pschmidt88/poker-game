import java.util.List;

public class ThreeOfAKind extends HandValue {
    private final Card.CardValue value;
    private final List<Card.CardValue> kicker;

    protected ThreeOfAKind(Card.CardValue value, List<Card.CardValue> kicker) {
        super(HandValueType.THREE_OF_A_KIND);
        assert kicker.size() == 2;

        this.value = value;
        this.kicker = kicker;
    }

    @Override
    public int handSpecificValue() {
        var value = this.value.numericValue * factors[0];

        for (int i = 0; i < kicker.size(); i++) {
            value += kicker.get(i).numericValue * factors[i+1];
        }

        return value;
    }
}
