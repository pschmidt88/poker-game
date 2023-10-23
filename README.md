# Poker game

## Prerequisites

- Java 17

## Run 

There is a test class `PokerShowdownTest` with existing tests. 
You can freely add more tests or edit the existing ones and replace the hands that should be 
played against each other.

```java
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
```

After adding/modifying test code, run the test either with gradle or maven.

```shell
./gradlew test
```

or

```shell
./mvnw verify
```

(On windows, replace `gradlew` with `gradlew.bat` or `mvnw` with `mvnw.cmd` respectively)


