/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.pieces;

import checkmate.logic.game.Square;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class PawnTest {

    Pawn white;
    Pawn black;
    Square square;

    public PawnTest() {
    }

    @Before
    public void setUp() {
        square = new Square(5, 5);
        white = new Pawn(square, "w");
        black = new Pawn(square, "b");
    }

    @Test
    public void constructorSetsSquare() {
        assertEquals(white.getSquare(), new Square(5, 5));
    }

    @Test
    public void constructorSetsColour() {
        assertEquals(white.getColour(), "w");
        assertEquals(black.getColour(), "b");
    }

    @Test
    public void constructorSetsType() {
        assertEquals(white.getType(), "pawn");
    }

    @Test
    public void constructorSetsInitSquare() {
        assertTrue(white.getInitSquare().equals(white.getSquare()));
    }

    @Test
    public void constructorSetsDirection() {
        assertTrue(white.getDirection() == 1);
    }

    @Test
    public void constructorSetsDirection2() {
        assertTrue(black.getDirection() == -1);
    }

    @Test
    public void testMove() {
        Square square2 = new Square(2, 1);
        white.move(square2);
        assertEquals(square2, white.getSquare());
    }

    @Test
    public void testIsValidMoveWhite() {
        Square square2 = new Square(5, 4);
        assertTrue(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveWhite2() {
        Square square2 = new Square(5, 3);
        assertTrue(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveWhite3() {
        Square square2 = new Square(4, 4);
        assertFalse(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveWhite4() {
        Square square2 = new Square(5, 2);
        assertFalse(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveWhite5() {
        Square square2 = new Square(5, 6);
        assertFalse(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveWhite6() {
        Square square2 = new Square(5, 5);
        assertFalse(white.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack() {
        Square square2 = new Square(5, 6);
        assertTrue(black.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack2() {
        Square square2 = new Square(5, 7);
        assertTrue(black.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack3() {
        Square square2 = new Square(4, 6);
        assertFalse(black.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack4() {
        Square square2 = new Square(5, 8);
        assertFalse(black.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack5() {
        Square square2 = new Square(5, 4);
        assertFalse(black.isValidMove(square2));
    }

    @Test
    public void testIsValidMoveBlack6() {
        Square square2 = new Square(5, 5);
        assertFalse(black.isValidMove(square2));
    }

    @Test
    public void testPossibleMoves() {
        assertFalse(white.possibleMoves() == null);
    }
    
    @Test
    public void testPossibleMoves2() {
        assertTrue(black.possibleMoves().isEmpty());
    }
    
    @Test
    public void constructorSetsAvailable() {
        assertTrue(white.getAvailable());
    }
    
    @Test
    public void testSetAvailable() {
        black.setAvailable(false);
        assertFalse(black.getAvailable());
    }
}
