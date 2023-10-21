import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HandTest {

    @Test
    public void ItCanCheckForAFlush() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SEVEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK))).isFlush());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SEVEN),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isFlush());
    }

    @Test
    public void ItCanCheckForStraightFlush() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).isStraightFlush());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).isStraightFlush());
    }

    @Test
    public void ItCanCheckForStraight() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).isStraight());

        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO))).isStraight());

        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO))).isStraight());

        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.QUEEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TEN))).isStraight());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.NINE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.QUEEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TEN))).isStraight());
    }

    @Test
    public void ItCanCheckForFourOfAKind() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isFourOfAKind());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isFourOfAKind());
    }

    @Test
    public void ItCanCheckForThreeOfAKind() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isThreeOfAKind());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isThreeOfAKind());
    }

    @Test
    public void ItCanCheckForPairs() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isPair());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FIVE),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isPair());
    }

    @Test
    public void ItCanCheckForFullHouse() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.THREE))).isFullHouse());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isFullHouse());
    }

    @Test
    public void ItCanCheckForTwoPairs() {
        Assertions.assertTrue(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.KING))).isTwoPairs());

        Assertions.assertFalse(new Hand(List.of(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.FIVE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).isTwoPairs());
    }
}
