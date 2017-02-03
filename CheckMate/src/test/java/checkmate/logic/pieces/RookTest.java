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
public class RookTest {

    Rook piece;
    Square square;

    public RookTest() {
    }

    @Before
    public void setUp() {
        square = new Square(0, 0);
        piece = new Rook(square, "w");
    }

    @Test
    public void constructorSetsSquare() {
        assertEquals(piece.getSquare(), new Square(0, 0));
    }

    @Test
    public void constructorSetsColour() {
        assertEquals(piece.getColour(), "w");
    }

    @Test
    public void constructorSetsType() {
        assertEquals(piece.getType(), "");
    }

    @Test
    public void testMove() {
        Square square2 = new Square(2, 1);
        piece.move(square2);
        assertEquals(square2, piece.getSquare());
    }

    @Test
    public void testIsValidMove() {
        Square square2 = new Square(0, 3);
        assertTrue(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove2() {
        Square square2 = new Square(4, 0);
        assertTrue(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove3() {
        Square square2 = new Square(2, 5);
        assertFalse(piece.isValidMove(square2));
    }

    @Test
    public void testIsValidMove4() {
        Square square2 = new Square(0, 0);
        assertFalse(piece.isValidMove(square2));
    }

    @Test
    public void testPossibleMoves() {
        assertFalse(piece.possibleMoves() == null);
    }
    
    @Test
    public void testPossibleMoves2() {
        assertTrue(piece.possibleMoves().isEmpty());
    }

    @Test
    public void constructorSetsInitSquare() {
        assertEquals(piece.getInitSquare(), square);
    }
}
