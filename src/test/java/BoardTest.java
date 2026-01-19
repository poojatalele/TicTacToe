import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board(3);
    }

    @Test
    public void testBoardInitialization() {
        assertEquals(3, board.getSize());
        // Check all cells are empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCell(i, j));
            }
        }
    }

    @Test
    public void testSetCell() {
        assertTrue(board.setCell(0, 0, 'X'));
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testSetCellInvalidRow() {
        assertFalse(board.setCell(-1, 0, 'X'));
        assertFalse(board.setCell(3, 0, 'X'));
    }

    @Test
    public void testSetCellInvalidCol() {
        assertFalse(board.setCell(0, -1, 'X'));
        assertFalse(board.setCell(0, 3, 'X'));
    }

    @Test
    public void testSetCellAlreadyOccupied() {
        board.setCell(0, 0, 'X');
        assertFalse(board.setCell(0, 0, 'O'));
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testCheckWinRow() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        board.setCell(0, 2, 'X');
        assertTrue(board.checkWin(0, 2, 'X'));
    }

    @Test
    public void testCheckWinColumn() {
        board.setCell(0, 0, 'O');
        board.setCell(1, 0, 'O');
        board.setCell(2, 0, 'O');
        assertTrue(board.checkWin(2, 0, 'O'));
    }

    @Test
    public void testCheckWinMainDiagonal() {
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.checkWin(1, 1, 'X'));
    }

    @Test
    public void testCheckWinAntiDiagonal() {
        board.setCell(0, 2, 'O');
        board.setCell(1, 1, 'O');
        board.setCell(2, 0, 'O');
        assertTrue(board.checkWin(1, 1, 'O'));
    }

    @Test
    public void testCheckWinFalse() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        assertFalse(board.checkWin(0, 1, 'X'));
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull());
        
        // Fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.setCell(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testGetCell() {
        board.setCell(1, 1, 'X');
        assertEquals('X', board.getCell(1, 1));
        assertEquals(' ', board.getCell(0, 0));
    }

    @Test
    public void testBoardSize() {
        Board smallBoard = new Board(2);
        assertEquals(2, smallBoard.getSize());
        
        Board largeBoard = new Board(5);
        assertEquals(5, largeBoard.getSize());
    }

    @Test
    public void testPartialRowNoWin() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        assertFalse(board.checkWin(0, 1, 'X'));
    }
}
