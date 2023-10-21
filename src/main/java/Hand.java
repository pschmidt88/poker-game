import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isFlush() {
        var suit = cards.get(0).suit();
        for (var card : cards) {
            if (card.suit() != suit) return false;
        }
        return true;
    }


    public boolean isFourOfAKind() {
        return occurrencesOfValues(4);
    }

    private boolean occurrencesOfValues(int occurrence) {
        HashMap<Card.CardValue, Integer> countValues = new HashMap<>();
        for (var card : cards) {
            countValues.merge(card.value(), 1, Integer::sum);
        }

        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == occurrence) {
                return true;
            }
        }

        return false;
    }

    public boolean isThreeOfAKind() {
       return occurrencesOfValues(3);
    }

    public boolean isPair() {
        return occurrencesOfValues(2);
    }

    public boolean isFullHouse() {
        return isThreeOfAKind() && isPair();
    }

    public boolean isTwoPairs() {
        HashMap<Card.CardValue, Integer> countValues = new HashMap<>();
        for (var card : cards) {
            countValues.merge(card.value(), 1, Integer::sum);
        }

        Card.CardValue firstPairValue = null;
        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == 2) {
                firstPairValue = entry.getKey();
            }
        }

        if (firstPairValue == null) {
            return false;
        }

        countValues.remove(firstPairValue);

        for (var entry : countValues.entrySet()) {
            if (entry.getValue() == 2) {
                return true;
            }
        }

        return false;
    }

    public boolean isStraight() {
        ArrayList<Card> mutableCopy = new ArrayList<>(cards);
        mutableCopy.sort(null);

        if (mutableCopy.get(0).value() == Card.CardValue.ACE && mutableCopy.get(1).value() == Card.CardValue.FIVE) {
            return checkForStraight(mutableCopy.subList(1,5));
        }

        return checkForStraight(mutableCopy);
    }

    private static boolean checkForStraight(List<Card> cards) {
        for (int i = 0; i< cards.size()-1; i++) {
            if (cards.get(i+1).value().numericValue != cards.get(i).value().numericValue - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }
}
