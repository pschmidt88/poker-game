import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighCard extends HandValue {
    private final List<Card.CardValue> values;

    public HighCard(List<Card.CardValue> values) {
        super(HandValueType.HIGH_CARD);
        assert values.size() == 5;
        this.values = new ArrayList<>(values);
        Collections.sort(this.values);
        Collections.reverse(this.values);
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
