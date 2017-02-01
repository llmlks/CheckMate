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
public class KnightTest {

    Knight piece;
    Square square;

    public KnightTest() {
    }

    @Before
    public void setUp() {
        square = new Square(5, 5);
        piece = new Knight(square, "w");
    }

    @Test
    public void constructorSetsSquare() {
        assertEquals(piece.getSquare(), new Square(5, 5));
    }

    @Test
    public void constructorSetsColour() {
        assertEquals(piece.getColour(), "w");
    }

    @Test
    public void constructorSetsType() {
        assertEquals(piece.getType(), "knight");
    }

    @Test
    public void testMove() {
        Square square2 = new Square(4, 3);
        piece.move(square2);
        assertEquals(square2, piece.getSquare());
    }

    @Test
    public void testIsValidMove() {
        Square square2 = new Square(4, 3);
        assertTrue(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove2() {
        Square square2 = new Square(7, 6);
        assertTrue(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove3() {
        Square square2 = new Square(6, 3);
        assertTrue(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove4() {
        Square square2 = new Square(1, 2);
        assertFalse(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove5() {
        Square square2 = new Square(5, 5);
        assertFalse(piece.isValidMove(square2));
    }
}
