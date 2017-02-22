/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.Pawn;
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
    public void testCanBeCaptured() {
        assertFalse(val.canBeCaptured(new Pawn(new Square(5, 2), "b")));
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
    public void testCanBeCaptured2() {
        assertFalse(val.canBeCaptured(game.getPlayers()[0].getPieces().get(0)));
    }

    @Test
    public void testIsChecked() {
        assertFalse(val.isChecked("b"));
    }

    @Test
    public void testIsChecked2() {
        assertFalse(val.isChecked("w"));
    }

    @Test
    public void testCanCastle() {
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
    public void testGameEnded() {
        assertFalse(val.gameEnded(game.getPlayers()));
    }
}
