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
public class QueenTest {

    Queen piece;

    public QueenTest() {
    }

    @Before
    public void setUp() {
        piece = new Queen(new Square(5, 5), "w");
    }

    @Test
    public void constructorSetsSquare() {
        assertEquals(piece.square, new Square(5, 5));
    }

    @Test
    public void constructorSetsColour() {
        assertEquals(piece.colour, "w");
    }

    @Test
    public void constructorSetsType() {
        assertEquals(piece.type, "");
    }

    @Test
    public void testGetSquare() {
        assertEquals(piece.square, piece.getSquare());
    }

    @Test
    public void testGetType() {
        assertEquals(piece.type, piece.getType());
    }

    @Test
    public void testGetColour() {
        assertEquals(piece.colour, piece.getColour());
    }

    @Test
    public void testMove() {
        Square square = new Square(2, 1);
        piece.move(square);
        assertEquals(square, piece.square);
    }

    @Test
    public void testIsValidMove() {
        Square square = new Square(3, 3);
        assertTrue(piece.isValidMove(square));
    }

    @Test
    public void testIsValidMove2() {
        Square square = new Square(0, 5);
        assertTrue(piece.isValidMove(square));
    }

    @Test
    public void testIsValidMove3() {
        Square square = new Square(5, 0);
        assertTrue(piece.isValidMove(square));
    }

    @Test
    public void testIsValidMove4() {
        Square square = new Square(4, 2);
        assertFalse(piece.isValidMove(square));
    }

    @Test
    public void testIsValidMove5() {
        Square square = new Square(5, 5);
        assertFalse(piece.isValidMove(square));
    }
}
