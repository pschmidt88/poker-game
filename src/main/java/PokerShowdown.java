
public class PokerShowdown {

    private final Player player1;
    private final Player player2;

    public PokerShowdown(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player winner() {
        if (player1.handValue().compareTo(player2.handValue()) > 0) {
            return player1;
        } else if (player1.handValue().compareTo(player2.handValue()) < 0) {
            return player2;
        }

        // draw
        return null;
    }
}
