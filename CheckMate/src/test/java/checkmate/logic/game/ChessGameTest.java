package checkmate.logic.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ChessGameTest {

    ChessGame game;

    public ChessGameTest() {
    }

    @Before
    public void setUp() {
        game = new ChessGame();
    }

    @Test
    public void constructorCreatesBoard() {
        assertFalse(game.getBoard() == null);
    }

    @Test
    public void constructorDoesntGeneratePlayers() {
        assertTrue(game.getPlayers() == null);
    }

    @Test
    public void setBoardWorks() {
        ChessBoard board = new ChessBoard();
        game.setBoard(board);
        assertEquals(game.getBoard(), board);
    }

    @Test
    public void startGeneratesPlayers() {
        game.start();
        assertTrue(game.getPlayers().length == 2);
    }
}