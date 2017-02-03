/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

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
        game.start();
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
        assertTrue(val.getOccupiedSquares().size() == 32);
    }

    @Test
    public void testIsValidMove() {
    }

    @Test
    public void testPiecesBetween() {
    }

    @Test
    public void testPiecesBetweenHorizontally() {
    }

    @Test
    public void testPiecesBetweenVertically() {
    }

    @Test
    public void testPiecesBetweenDiagonally() {
    }

    @Test
    public void testCanBeCaptured() {
    }

    @Test
    public void testIsChecked() {
    }

    @Test
    public void testCanCastle() {
    }

    @Test
    public void testHasValidMoves() {
    }

}
