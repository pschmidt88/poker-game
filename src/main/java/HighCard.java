import java.util.List;

public class HighCard extends HandValue {
    private final List<Card.CardValue> values;

    public HighCard(List<Card.CardValue> values) {
        super(HandValueType.HIGH_CARD);
        assert values.size() == 5;
        this.values = values;
    }

    @Override
    public int handSpecificValue() {
        int value = 0;
        for (int i = 0; i < values.size(); i++) {
            value += values.get(i).numericValue * factors[i];
        }

        return value;
    }
}
