package checkmate.logic.game;

import checkmate.logic.pieces.Pawn;
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
    public void setBoardWorks() {
        ChessBoard board = new ChessBoard();
        game.setBoard(board);
        assertEquals(game.getBoard(), board);
    }

    @Test
    public void startGeneratesPlayers() {
        game.initGame();
        assertTrue(game.getPlayers().length == 2);
    }

    @Test
    public void startCallsInitSquares() {
        assertTrue(game.getBoard().getSquares().size() == 64);
    }

    @Test
    public void startCallsInitPieces() {
        assertTrue(game.getBoard().getPieces().size() == 32);
    }
    
    @Test
    public void startCallsSetOccupiedSquares() {
        assertEquals(game.getValidator().getOccupiedSquares().size(), 32);
    }
    
    @Test
    public void startAddsPiecesToPlayers() {
        assertEquals(game.getPlayers()[0].getPieces().size(), 16);
    }
    
    @Test
    public void startAddsRightPiecesToRightPlayers() {
        Player player = game.getPlayers()[0];
        String colour = player.getColour();
        assertTrue(player.getPieces().get(0).getColour().equals(colour));
    }

    @Test
    public void startAddsRightPiecesToRightPlayers2() {
        Player player = game.getPlayers()[1];
        String colour = player.getColour();
        assertTrue(player.getPieces().get(0).getColour().equals(colour));
    }    
    
    @Test
    public void testFindSquare() {
        assertEquals(null, game.findSquareByCoordinates(13, 2));
    }
    
    @Test
    public void testFindSquare2() {
        assertEquals(new Square(1, 2), game.findSquareByCoordinates(1, 2));
    }
    
    @Test
    public void testGetEnded() {
        assertFalse(game.getEnded());
    }
    
    @Test
    public void testGetTurn() {
        assertEquals(game.getTurn(), "w");
    }
    
    @Test
    public void testTurn() {
        game.turn(new Pawn(new Square(1, 2), "w"), new Square(1, 3));
        assertEquals(game.getTurn(), "b");
    }
    
    @Test
    public void testTurn2() {
        Pawn p = new Pawn(new Square(1, 2), "w");
        game.turn(p, new Square(1, 3));
        assertEquals(p.getSquare(), new Square(1, 3));        
    }
}
