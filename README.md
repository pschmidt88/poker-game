# Poker game

## Prerequisites

- Java 17

```java

import java.util.List;

public class HandValue {

    public enum Type {
        HIGH_CARD(0),
        PAIR(1),
        TWO_PAIRS(2),
        THREE_OF_A_KIND(3),
        STRAIGHT(4),
        FLUSH(5),
        FULL_HOUSE(6),
        FOUR_OF_A_KIND(7),
        STRAIGHT_FLUSH(8),
        ROYAL_FLUSH(9);

        private final int value;

        Type(int value) {
            this.value = value;
        }
    }

    private final Card.CardValue highestCardValue;
    private final Type type;

    private final List<Card.CardValue> kickers;

    public HandValue(Card.CardValue highestCardValue, Type type, List<Card.CardValue> kickers) {
        this.highestCardValue = highestCardValue;
        this.type = type;
        this.kickers = kickers;
    }

    // type = factor 1_000_000
    // highest card = 100_000
    // kicker = 10_000 1_000, 100, 10


    // A) Flush: J, 10, 6, 5, 4
    // B) Flush: J, 10, 7, 3, 2

    // --> Winner: B

    // 5 (flush) * 100000 + 11 (J) *1000 + 6*100 + 5*10 + 4*1
    // = 511654

    // 5 (flush) * 100000 + 11 (J)*1000 + 7*100 + 3*10 + 2*1
    // = 511732



}
```