import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class playerTest {
    private Player player;




    @Test
    public void testGetName() {
        player = new Player("Alice", 'X');

        assertEquals("Alice", player.getName());
    }
    @Test
    public void testGetSymbol() {
        player = new Player("Alice", 'X');

        assertEquals('X', player.getSymbol());
    }
}
