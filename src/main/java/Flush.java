import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flush extends HandValue {
    private final ArrayList<Card.CardValue> values;

    protected Flush(List<Card.CardValue> values) {
        super(HandValueType.FLUSH);
        var copy = new ArrayList<>(values);
        Collections.sort(copy);
        Collections.reverse(copy);
        this.values = copy;
    }

    @Override
    public int handSpecificValue() {
        int value = 0;
        for (int i = 0; i<=4; i++) {
            value += this.values.get(i).numericValue * factors[i];
        }
        return value;
    }
}
