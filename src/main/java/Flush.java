import java.util.List;

public class Flush extends HandValue {
    private final List<Card.CardValue> values;

    protected Flush(List<Card.CardValue> values) {
        super(HandValueType.FLUSH);
        this.values = values;
    }

    @Override
    public int handSpecificValue() {
        int value = 0;
        for (int i = 0; i < values.size(); i++) {
            value += this.values.get(i).numericValue * factors[i];
        }
        return value;
    }
}
