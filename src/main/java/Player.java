import com.google.common.collect.Lists;

import java.util.List;

public final class Player {
    private final String name;

    private final Hand hand;

    public Player(String name, List<Card> cards) {
        this.name = name;
        var cardsCopy = Lists.newArrayList(cards);
        this.hand = new Hand(cardsCopy);
    }

    public HandValue handValue() {
        return this.hand.getHandValue();
    }

    public String name() {
        return name;
    }
}
