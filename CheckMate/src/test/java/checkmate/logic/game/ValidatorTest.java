/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Rook;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ValidatorTest {

    Validator val;
    ChessGame game;

    public ValidatorTest() {
    }

    @Before
    public void setUp() {
        game = new ChessGame();
        val = game.getValidator();
    }

    @Test
    public void constructorSetsBoard() {
        val = new Validator(new ChessBoard());
        assertTrue(val.getBoard() != null);
    }

    @Test
    public void constructorCreatesOccupiedSquaresList() {
        val = new Validator(new ChessBoard());
        assertTrue(val.getOccupiedSquares() != null);
    }

    @Test
    public void occupiedSquaresEmptyInitially() {
        val = new Validator(new ChessBoard());
        assertTrue(val.getOccupiedSquares().isEmpty());
    }

    @Test
    public void testGameStart() {
        assertTrue(val.getBoard().getSquares().size() == 64);
    }

    @Test
    public void testSetOccupiedSquares() {
        assertEquals(val.getOccupiedSquares().size(), 32);
    }

    @Test
    public void testIsValidMove() {
        assertTrue(val.isValidMove(new Pawn(new Square(5, 2), "b"), new Square(5, 3)));
    }

    @Test
    public void testIsValidMove2() {
        assertFalse(val.isValidMove(new Pawn(new Square(5, 2), "w"), new Square(5, 3)));
    }
    
    @Test
    public void testIsValidMove3() {
        Pawn p = new Pawn(new Square(1, 1), "w");
        Pawn p2 = new Pawn(new Square(1, 2), "b");
        assertFalse(val.isValidMove(p, p2.getSquare()));
    }
    
    @Test
    public void testIsValidMove4() {
        Rook r = new Rook(new Square(3, 3), "w");
        assertTrue(val.isValidMove(r, new Square(6, 3)));
    }
    
    @Test
    public void testIsValidMove5() {
        Rook r = new Rook(new Square(3, 3), "w");
        assertTrue(val.isValidMove(r, new Square(3, 5)));
    }
    
    @Test
    public void testPiecesBetween() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(1, 5)));
    }

    @Test
    public void testPiecesBetween2() {
        assertFalse(val.piecesBetween(new Square(2, 2), new Square(3, 3)));
    }

    @Test
    public void testPiecesBetween3() {
        assertFalse(val.piecesBetween(new Square(0, 0), new Square(7, 4)));
    }

    @Test
    public void testPiecesBetweenHorizontally() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(1, 5)));
    }

    @Test
    public void testPiecesBetweenHorizontally2() {
        assertFalse(val.piecesBetween(new Square(3, 3), new Square(3, 5)));
    }

    @Test
    public void testPiecesBetweenVertically() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(8, 1)));
    }

    @Test
    public void testPiecesBetweenVertically2() {
        assertFalse(val.piecesBetween(new Square(1, 3), new Square(8, 3)));
    }

    @Test
    public void testPiecesBetweenDiagonally() {
        assertTrue(val.piecesBetween(new Square(1, 1), new Square(7, 7)));
    }

    @Test
    public void testPiecesBetweenDiagonally2() {
        assertTrue(val.piecesBetween(new Square(7, 7), new Square(1, 1)));
    }    

    @Test
    public void testPiecesBetweenDiagonally3() {
        assertFalse(val.piecesBetween(new Square(3, 3), new Square(5, 5)));
    }

    @Test
    public void testCanCastle() {
        King k = new King(new Square(1, 2), "w");
        k.move(new Square(2, 4));
        assertTrue(val.possibleCastlingSquares(k).isEmpty());
    }
    
    @Test
    public void testHasValidMoves() {
        assertTrue(val.hasValidMoves(game.getPlayers()[0]));
    }

    @Test
    public void testHasValidMoves2() {
        assertTrue(val.hasValidMoves(game.getPlayers()[1]));
    }
    
    @Test
    public void testHasValidMoves3() {
        Validator v = new Validator(new ChessBoard());
        Player p = new Player("w");
        assertFalse(v.hasValidMoves(p));
    }

    @Test
    public void testGameEnded() {
        assertFalse(val.gameEnded(game.getPlayers()));
    }
}
