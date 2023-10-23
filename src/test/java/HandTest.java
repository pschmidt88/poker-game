import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HandTest {

    @Test
    public void ItRecognizesAFlush() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SEVEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK))).getHandValue()).isInstanceOf(Flush.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SEVEN),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(HighCard.class);
    }

    @Test
    public void ItRecognizesStraightFlushAndItCanDifferFromANormalStraight() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).getHandValue()).isInstanceOf(StraightFlush.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).getHandValue()).isInstanceOf(Straight.class);
    }

    @Test
    public void ItRecognizesStraights() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX))).getHandValue()).isInstanceOf(Straight.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.SIX),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO))).getHandValue()).isInstanceOf(Straight.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.SPADES, Card.CardValue.THREE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.FIVE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO))).getHandValue()).isInstanceOf(Straight.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.KING),
                new Card(Card.CardSuit.SPADES, Card.CardValue.QUEEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TEN))).getHandValue()).isInstanceOf(Straight.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.ACE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.NINE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.QUEEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.JACK),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TEN))).getHandValue()).isInstanceOf(HighCard.class);
    }

    @Test
    public void ItRecognizesAFourOfAKind() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(FourOfAKind.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(ThreeOfAKind.class);
    }

    @Test
    public void ItRecognizesAThreeOfAKind() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(ThreeOfAKind.class);

       assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(Pair.class);
    }

    @Test
    public void ItRecognizesAPairs() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isInstanceOf(Pair.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.FIVE),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isNotInstanceOf(Pair.class);
    }

    @Test
    public void ItRecognizesAFullHouse() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.THREE))).getHandValue()).isInstanceOf(FullHouse.class);

        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isNotInstanceOf(FullHouse.class);
    }

    @Test
    public void ItRecognizesTwoPairs() {
        assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.THREE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.THREE),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.KING))).getHandValue()).isInstanceOf(TwoPairs.class);

       assertThat(new Hand(Lists.newArrayList(
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.FIVE),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.FOUR),
                new Card(Card.CardSuit.HEARTS, Card.CardValue.JACK))).getHandValue()).isNotInstanceOf(TwoPairs.class);
    }
}
