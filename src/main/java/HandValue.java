public abstract class HandValue implements Comparable<HandValue> {
    private final HandValueType type;

    protected final Integer[] factors = { 371293, 28561, 2197, 169, 13 };

    protected HandValue(HandValueType type) {
        this.type = type;
    }

    public static HandValue fromHand(Hand hand) {
        if (hand.isStraightFlush()) {
            // TODO:
            return new StraightFlush(hand.cards.stream().map(Card::value).toList());
        }
        if (hand.isFourOfAKind()) {
            // TODO:
            return new FourOfAKind(null, null);
        }
        if (hand.isFullHouse()) {
            // TODO
            return new FullHouse(null, null);
        }
        if (hand.isFlush()) {
            //TODO:
            return new Flush(hand.cards.stream().map(Card::value).toList());
        }
        if (hand.isStraight()) {
            // TODO:
            return new Straight(null);
        }

        // TODO:
        if (hand.isThreeOfAKind()) {
            return new ThreeOfAKind(null, null);
        }

        // TODO:
        if (hand.isTwoPairs()) {
            return new TwoPairs(null, null, null);
        }

        // TODO:
        if (hand.isPair()) {
            return new Pair(null, null);
        }

        // TODO:
        return new HighCard(hand.cards.stream().map(Card::value).toList());
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
