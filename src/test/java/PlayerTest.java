import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Player X", 'X');
        player2 = new Player("Player O", 'O');
    }

    @Test
    public void testPlayerCreation() {
        assertEquals("Player X", player1.getName());
        assertEquals('X', player1.getSymbol());
    }

    @Test
    public void testPlayerName() {
        assertEquals("Player X", player1.getName());
        assertEquals("Player O", player2.getName());
    }

    @Test
    public void testPlayerSymbol() {
        assertEquals('X', player1.getSymbol());
        assertEquals('O', player2.getSymbol());
    }

    @Test
    public void testDifferentPlayers() {
        assertNotEquals(player1.getSymbol(), player2.getSymbol());
        assertNotEquals(player1.getName(), player2.getName());
    }

    @Test
    public void testPlayerWithCustomName() {
        Player customPlayer = new Player("Alice", 'A');
        assertEquals("Alice", customPlayer.getName());
        assertEquals('A', customPlayer.getSymbol());
    }
}
