import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PokerShowdownTest {

    @Test
    public void AliceWinsWithAPairOfTwosAgainstBobWithHighCardKing() {
        var alice = new Player("Alice", List.of(
                new Card(Card.CardSuit.CLUBS, Card.CardValue.TWO),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TWO),
                new Card(Card.CardSuit.CLUBS, Card.CardValue.KING),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.SEVEN),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.FOUR)
        ));

        var bob = new Player("Bob", List.of(
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.KING),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.JACK),
                new Card(Card.CardSuit.DIAMONDS, Card.CardValue.TEN),
                new Card(Card.CardSuit.SPADES, Card.CardValue.NINE),
                new Card(Card.CardSuit.SPADES, Card.CardValue.TWO)
        ));

        Assertions.assertEquals(
                new PokerShowdown(alice, bob).winner(),
                alice
        );
    }
}
