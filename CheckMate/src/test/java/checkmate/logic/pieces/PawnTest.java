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

    public PawnTest() {
    }

    @Before
    public void setUp() {
        white = new Pawn(new Square(5, 5), "w");
        black = new Pawn(new Square(5, 5), "b");
    }

    @Test
    public void constructorSetsSquare() {
        assertEquals(white.square, new Square(5, 5));
    }

    @Test
    public void constructorSetsColour() {
        assertEquals(white.colour, "w");
        assertEquals(black.colour, "b");
    }

    @Test
    public void constructorSetsType() {
        assertEquals(white.type, "");
    }

    @Test
    public void constructorSetsInitSquare() {
        assertTrue(white.getInitSquare().equals(white.square));
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
    public void testGetSquare() {
        assertEquals(white.square, white.getSquare());
    }

    @Test
    public void testGetType() {
        assertEquals(white.type, white.getType());
    }

    @Test
    public void testGetColour() {
        assertEquals(white.colour, white.getColour());
    }

    @Test
    public void testMove() {
        Square square = new Square(2, 1);
        white.move(square);
        assertEquals(square, white.square);
    }

    @Test
    public void testIsValidMoveWhite() {
        Square square = new Square(5, 4);
        assertTrue(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveWhite2() {
        Square square = new Square(5, 3);
        assertTrue(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveWhite3() {
        Square square = new Square(4, 4);
        assertFalse(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveWhite4() {
        Square square = new Square(5, 2);
        assertFalse(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveWhite5() {
        Square square = new Square(5, 6);
        assertFalse(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveWhite6() {
        Square square = new Square(5, 5);
        assertFalse(white.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack() {
        Square square = new Square(5, 6);
        assertTrue(black.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack2() {
        Square square = new Square(5, 7);
        assertTrue(black.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack3() {
        Square square = new Square(4, 6);
        assertFalse(black.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack4() {
        Square square = new Square(5, 8);
        assertFalse(black.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack5() {
        Square square = new Square(5, 4);
        assertFalse(black.isValidMove(square));
    }

    @Test
    public void testIsValidMoveBlack6() {
        Square square = new Square(5, 5);
        assertFalse(black.isValidMove(square));
    }
}
