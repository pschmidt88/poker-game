public abstract class HandValue implements Comparable<HandValue> {
    private final HandValueType type;

    protected final Integer[] factors = { 371293, 28561, 2197, 169, 13 };

    protected HandValue(HandValueType type) {
        this.type = type;
    }


    @Override
    public int compareTo(HandValue o) {
        if (this.type == o.type) {
            return this.handSpecificValue() - o.handSpecificValue();
        }

        return this.type.value - o.type.value;
    }

    public abstract int handSpecificValue();
}
