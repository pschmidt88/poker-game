import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StraightFlush extends HandValue implements Comparable<HandValue> {
    private final List<Card.CardValue> values;

    public StraightFlush(List<Card.CardValue> cardValues) {
        super(HandValueType.STRAIGHT_FLUSH);
        var copy = new ArrayList<>(cardValues);
        Collections.sort(copy);
        Collections.reverse(copy);
        this.values = copy;
    }

    @Override
    public int handSpecificValue() {
        int value = 0;
        for (int i=0; i<4; i++) {
            value += values.get(i).numericValue * factors[i];
        }

        return value;
    }
}
