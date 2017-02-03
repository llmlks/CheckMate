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

    @Test
    public void startCallsInitSquares() {
        game.start();
        assertTrue(game.getBoard().getSquares().size() == 64);
    }

    @Test
    public void startCallsInitPieces() {
        game.start();
        assertTrue(game.getBoard().getPieces().size() == 32);
    }
    
    @Test
    public void startCallsSetOccupiedSquares() {
        game.start();
        assertEquals(game.getValidator().getOccupiedSquares().size(), 32);
    }
    
    @Test
    public void startAddsPiecesToPlayers() {
        game.start();
        assertEquals(game.getPlayers()[0].getPieces().size(), 16);
    }
    
    @Test
    public void startAddsRightPiecesToRightPlayers() {
        game.start();
        Player player = game.getPlayers()[0];
        String colour = player.getColour();
        assertTrue(player.getPieces().get(0).getColour().equals(colour));
    }

    @Test
    public void startAddsRightPiecesToRightPlayers2() {
        game.start();
        Player player = game.getPlayers()[1];
        String colour = player.getColour();
        assertTrue(player.getPieces().get(0).getColour().equals(colour));
    }    
}
