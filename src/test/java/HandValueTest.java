import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class HandValueTest {

    @Test
    public void FourOfAKindComparisonWorks() {
        Assertions.assertThatComparable(
                new FourOfAKind(Card.CardValue.FOUR, Card.CardValue.ACE)).isGreaterThan(
                new FourOfAKind(Card.CardValue.FOUR, Card.CardValue.KING)
        );

        Assertions.assertThatComparable(
                new FourOfAKind(Card.CardValue.FOUR, Card.CardValue.ACE)).isLessThan(
                new FourOfAKind(Card.CardValue.FIVE, Card.CardValue.THREE)
        );

        // That makes no sense, but it just checks if the code is working correctly
        Assertions.assertThatComparable(
                new FourOfAKind(Card.CardValue.FIVE, Card.CardValue.THREE)).isEqualByComparingTo(
                new FourOfAKind(Card.CardValue.FIVE, Card.CardValue.THREE)
        );
    }

    @Test
    public void FullHouseComparisonWorks() {
        Assertions.assertThatComparable(
                new FullHouse(Card.CardValue.ACE, Card.CardValue.FOUR)).isGreaterThan(
                new FullHouse(Card.CardValue.KING, Card.CardValue.QUEEN)
        );

        Assertions.assertThatComparable(
                new FullHouse(Card.CardValue.FOUR, Card.CardValue.QUEEN)).isLessThan(
                new FullHouse(Card.CardValue.SEVEN, Card.CardValue.SIX)
        );

        Assertions.assertThatComparable(
                new FullHouse(Card.CardValue.FOUR, Card.CardValue.QUEEN)).isEqualByComparingTo(
                new FullHouse(Card.CardValue.FOUR, Card.CardValue.QUEEN)
        );
    }

    @Test
    public void FlushComparisonWorks() {
        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.FOUR,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isGreaterThan(
                        new Flush(List.of(
                                Card.CardValue.JACK,
                                Card.CardValue.NINE,
                                Card.CardValue.SEVEN,
                                Card.CardValue.SIX,
                                Card.CardValue.FIVE))
                );

        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.FOUR,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isGreaterThan(
                new Flush(List.of(
                        Card.CardValue.QUEEN,
                        Card.CardValue.NINE,
                        Card.CardValue.SEVEN,
                        Card.CardValue.SIX,
                        Card.CardValue.FIVE))
        );

        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.FOUR,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isGreaterThan(
                new Flush(List.of(
                        Card.CardValue.QUEEN,
                        Card.CardValue.TEN,
                        Card.CardValue.SEVEN,
                        Card.CardValue.SIX,
                        Card.CardValue.FIVE)));

        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.FOUR,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isGreaterThan(
                new Flush(List.of(
                        Card.CardValue.QUEEN,
                        Card.CardValue.TEN,
                        Card.CardValue.NINE,
                        Card.CardValue.SIX,
                        Card.CardValue.FIVE)));
        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.SIX,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isGreaterThan(
                new Flush(List.of(
                        Card.CardValue.QUEEN,
                        Card.CardValue.TEN,
                        Card.CardValue.NINE,
                        Card.CardValue.EIGHT,
                        Card.CardValue.FIVE)));

        Assertions.assertThatComparable(
                new Flush(List.of(Card.CardValue.QUEEN,
                        Card.CardValue.SIX,
                        Card.CardValue.EIGHT,
                        Card.CardValue.NINE,
                        Card.CardValue.TEN))).isEqualByComparingTo(
                new Flush(List.of(
                        Card.CardValue.QUEEN,
                        Card.CardValue.TEN,
                        Card.CardValue.NINE,
                        Card.CardValue.EIGHT,
                        Card.CardValue.SIX)));
    }

    @Test
    public void StraightComparisonWorks() {
       Assertions.assertThatComparable(
               new Straight(Card.CardValue.EIGHT)
       ).isGreaterThan(new Straight(Card.CardValue.FIVE));

        Assertions.assertThatComparable(
                new Straight(Card.CardValue.EIGHT)
        ).isLessThan(new Straight(Card.CardValue.JACK));

        Assertions.assertThatComparable(
                new Straight(Card.CardValue.EIGHT)
        ).isEqualByComparingTo(new Straight(Card.CardValue.EIGHT));
    }

    @Test
    public void ThreeOfAKindComparisonWorks() {
        Assertions.assertThatComparable(
                new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN))
        ).isGreaterThan(new ThreeOfAKind(Card.CardValue.FIVE, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN)));

        Assertions.assertThatComparable(
                new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN))
        ).isGreaterThan(new ThreeOfAKind(Card.CardValue.FIVE, List.of(Card.CardValue.ACE, Card.CardValue.KING)));

        Assertions.assertThatComparable(
                new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN))
        ).isLessThan(new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.ACE, Card.CardValue.KING)));

        Assertions.assertThatComparable(
                new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN))
        ).isEqualByComparingTo(new ThreeOfAKind(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.SEVEN)));
    }

    @Test
    public void TwoPairsComparisonWorks() {
        Assertions.assertThatComparable(
                new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SEVEN, Card.CardValue.SIX)
        ).isGreaterThan(new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE));

        Assertions.assertThatComparable(
                new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SEVEN, Card.CardValue.SIX)
        ).isGreaterThan(new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SEVEN, Card.CardValue.FIVE));

        Assertions.assertThatComparable(
                new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SEVEN, Card.CardValue.SIX)
        ).isEqualByComparingTo(new TwoPairs(Card.CardValue.EIGHT, Card.CardValue.SEVEN, Card.CardValue.SIX));
    }

    @Test
    public void PairComparisonWorks() {
        Assertions.assertThatComparable(
                new Pair(Card.CardValue.TEN, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE)));

        Assertions.assertThatComparable(
                new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SIX, Card.CardValue.FIVE, Card.CardValue.FOUR)));

        Assertions.assertThatComparable(
                new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.FIVE, Card.CardValue.FOUR)));

        Assertions.assertThatComparable(
                new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FOUR)));

        Assertions.assertThatComparable(
                new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isEqualByComparingTo(new Pair(Card.CardValue.EIGHT, List.of(Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE)));
    }

    @Test
    public void HighCardComparisonWorks() {
        // KQ765 > QJ765
        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new HighCard(List.of(Card.CardValue.QUEEN, Card.CardValue.JACK,Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE)));

        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new HighCard(List.of(Card.CardValue.KING, Card.CardValue.JACK,Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE)));

        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.SEVEN, Card.CardValue.SIX, Card.CardValue.FIVE)));


        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.FIVE, Card.CardValue.FOUR)));

        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isGreaterThan(new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FOUR)));

        Assertions.assertThatComparable(
                new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE))
        ).isEqualByComparingTo(new HighCard(List.of(Card.CardValue.KING, Card.CardValue.QUEEN, Card.CardValue.EIGHT, Card.CardValue.SIX, Card.CardValue.FIVE)));
    }

}