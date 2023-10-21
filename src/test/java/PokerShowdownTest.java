import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokerShowdownTest {

    @Test
    public void foo() {
        Assertions.assertDoesNotThrow(() -> {
            new PokerShowdown(null, null).winner();
        });
    }
}
