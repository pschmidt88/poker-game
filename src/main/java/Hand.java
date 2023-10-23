import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import java.util.*;

public class Hand implements Comparable<Hand> {
    final List<Card> cards;
    private boolean isFlush;
    private boolean isStraight;
    private final HashMap<Card.CardValue, Integer> countValues = Maps.newHashMap();
    private Card.CardValue quadValue;
    private Card.CardValue tripleValue;
    private final List<Card.CardValue> pairValues = Lists.newArrayList();

    public Hand(List<Card> cards) {
        cards.sort(Ordering.natural().reverse());
        this.cards = cards;
    }

    public HandValue getHandValue() {
        checkForFlush();
        checkForStraight();
        countDuplicates();
        findPairs();

        if (isStraightFlush()) {
            return new StraightFlush(cards.get(0).value());
        }

        if (isFourOfAKind()) {
            var kicker = cards.stream()
                    .map(Card::value)
                    .filter(value -> value != quadValue)
                    .toList();

            return new FourOfAKind(this.quadValue, kicker.get(0));
        }

        if (isFullHouse()) {
            return new FullHouse(tripleValue, pairValues.get(0));
        }

        if (isFlush()) {
            return new Flush(cards.stream().map(Card::value).toList());
        }

        if (isStraight()) {
            return new Straight(cards.get(0).value());
        }

        if (isThreeOfAKind()) {
            var kicker = cards.stream()
                    .map(Card::value)
                    .filter(value -> value != tripleValue)
                    .toList();

            return new ThreeOfAKind(tripleValue, kicker);
        }

        if (hasTwoPairs()) {
            pairValues.sort(Ordering.natural().reverse());
            Card.CardValue highPair = pairValues.get(0);
            Card.CardValue lowPair = pairValues.get(1);

            var kicker = cards.stream().map(Card::value).filter(
                    cardValue -> cardValue != highPair || cardValue != lowPair
            ).toList();

            return new TwoPairs(highPair, lowPair, kicker.get(0));
        }

        if (hasOnePair()) {
            Card.CardValue pairValue = this.pairValues.get(0);
            var kicker = cards.stream()
                    .map(Card::value)
                    .filter(cardValue -> cardValue != pairValue)
                    .toList();
            return new Pair(pairValue, kicker);
        }

        return new HighCard(cards.stream().map(Card::value).toList());
    }

    private void countDuplicates() {
        for (var card : cards) {
            countValues.merge(card.value(), 1, Integer::sum);
        }
    }

    private void checkForFlush() {
        var suit = cards.get(0).suit();
        for (var card : cards) {
            if (card.suit() != suit) return;
        }

        this.isFlush = true;
    }

    private boolean isFlush() {
        return this.isFlush;
    }

    private boolean isFourOfAKind() {
        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == 4) {
                this.quadValue = entry.getKey();
                return true;
            }
        }

        return false;
    }

    private boolean isThreeOfAKind() {
        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == 3) {
                this.tripleValue = entry.getKey();
                return true;
            }
        }

        return false;
    }

    private boolean hasTwoPairs() {
        return this.pairValues.size() == 2;
    }

    private boolean hasOnePair() {
        return this.pairValues.size() == 1;
    }

    private void findPairs() {
        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == 2) {
                this.pairValues.add(entry.getKey());
            }
        }
    }

    private boolean isFullHouse() {
        return isThreeOfAKind() && hasOnePair();
    }

    private void checkForStraight() {
        // check for baby straight 5432A
        if (cards.get(0).value() == Card.CardValue.ACE && cards.get(1).value() == Card.CardValue.FIVE) {
            this.isStraight = isStraight(cards.subList(1, 5));
            return;
        }

        this.isStraight = isStraight(cards);
    }

    private static boolean isStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i+1).value().numericValue != cards.get(i).value().numericValue - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraightFlush() {
        return isFlush && isStraight;
    }

    @Override
    public int compareTo(Hand o) {
        return this.getHandValue().compareTo(o.getHandValue());
    }

    private boolean isStraight() {
        return isStraight;
    }
}
