import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game(3);
    }

    @Test
    public void testGameInitialization() {
        assertEquals(3, game.getSize());
        // All cells should be empty after initialization
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', game.getCell(i, j));
            }
        }
    }

    @Test
    public void testGameInheritsFromBoard() {
        assertTrue(game instanceof Board);
    }

    @Test
    public void testValidMove() {
        assertTrue(game.setCell(0, 0, 'X'));
        assertEquals('X', game.getCell(0, 0));
    }

    @Test
    public void testInvalidMove() {
        game.setCell(1, 1, 'X');
        assertFalse(game.setCell(1, 1, 'O'));
    }

    @Test
    public void testGameCanDetectRowWin() {
        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'X');
        game.setCell(0, 2, 'X');
        assertTrue(game.checkWin(0, 1, 'X'));
    }

    @Test
    public void testGameCanDetectColumnWin() {
        game.setCell(0, 1, 'O');
        game.setCell(1, 1, 'O');
        game.setCell(2, 1, 'O');
        assertTrue(game.checkWin(1, 1, 'O'));
    }

    @Test
    public void testGameCanDetectDiagonalWin() {
        game.setCell(0, 0, 'X');
        game.setCell(1, 1, 'X');
        game.setCell(2, 2, 'X');
        assertTrue(game.checkWin(1, 1, 'X'));
    }

    @Test
    public void testGameCanDetectDraw() {
        // Fill board with alternating symbols to avoid win
        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'O');
        game.setCell(0, 2, 'X');
        game.setCell(1, 0, 'X');
        game.setCell(1, 1, 'O');
        game.setCell(1, 2, 'O');
        game.setCell(2, 0, 'O');
        game.setCell(2, 1, 'X');
        assertFalse(game.isFull());
        
        game.setCell(2, 2, 'X');
        assertTrue(game.isFull());
    }

    @Test
    public void testMultipleMovesSequence() {
        // Player X makes a move
        assertTrue(game.setCell(0, 0, 'X'));
        assertEquals('X', game.getCell(0, 0));
        
        // Player O makes a move
        assertTrue(game.setCell(1, 1, 'O'));
        assertEquals('O', game.getCell(1, 1));
        
        // Player X makes another move
        assertTrue(game.setCell(0, 1, 'X'));
        assertEquals('X', game.getCell(0, 1));
    }

    @Test
    public void testGameWith5x5Board() {
        Game largeGame = new Game(5);
        assertEquals(5, largeGame.getSize());
        
        // Should be able to place moves on larger board
        assertTrue(largeGame.setCell(0, 0, 'X'));
        assertTrue(largeGame.setCell(4, 4, 'O'));
        assertEquals('X', largeGame.getCell(0, 0));
        assertEquals('O', largeGame.getCell(4, 4));
    }

    @Test
    public void testNoWinWithPartialRow() {
        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'X');
        game.setCell(1, 2, 'X');
        assertFalse(game.checkWin(1, 2, 'X'));
    }
}
