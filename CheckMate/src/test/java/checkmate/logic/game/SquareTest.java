/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.King;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class SquareTest {

    Square square;

    public SquareTest() {
    }

    @Before
    public void setUp() {
        square = new Square(0, 0);
    }

    @Test
    public void testGetX() {
        assertTrue(square.getX() == 0);
    }

    @Test
    public void testGetX2() {
        Square square2 = new Square(3, 6);
        assertTrue(square2.getX() == 3);
    }

    @Test
    public void testGetY() {
        assertTrue(square.getY() == 0);
    }

    @Test
    public void testGetY2() {
        Square square2 = new Square(4, 2);
        assertEquals(square2.getY(), 2);
    }

    @Test
    public void constructorSetsNoPiece() {
        assertTrue(square.getPiece() == null);
    }

    @Test
    public void testSetPiece() {
        King king = new King(square, "w");
        square.setPiece(king);
        assertEquals(king, square.getPiece());
    }

    @Test
    public void testIsNextTo() {
        Square square2 = new Square(1, 1);
        assertTrue(square.isNextTo(square2));
    }

    @Test
    public void testIsNextTo2() {
        Square square2 = new Square(3, 6);
        assertFalse(square.isNextTo(square2));
    }

    @Test
    public void testIsNextTo3() {
        assertFalse(square.isNextTo(square));
    }

    @Test
    public void testIsSameRank() {
        Square square2 = new Square(5, 0);
        assertTrue(square.isSameRank(square2));
    }

    @Test
    public void testIsSameRank2() {
        Square square2 = new Square(5, 3);
        assertFalse(square.isSameRank(square2));
    }

    @Test
    public void testIsSameRank3() {
        assertFalse(square.isSameRank(square));
    }

    @Test
    public void testIsSameFile() {
        Square square2 = new Square(0, 3);
        assertTrue(square.isSameFile(square2));
    }

    @Test
    public void testIsSameFile2() {
        Square square2 = new Square(5, 3);
        assertFalse(square.isSameFile(square2));
    }

    @Test
    public void testIsSameFile3() {
        assertFalse(square.isSameFile(square));
    }

    @Test
    public void testIsDiagonal() {
        Square square2 = new Square(3, 3);
        assertTrue(square.isDiagonal(square2));
    }

    @Test
    public void testIsDiagonal2() {
        Square square2 = new Square(2, 3);
        assertFalse(square.isDiagonal(square2));
    }

    @Test
    public void testIsDiagonal3() {
        assertFalse(square.isDiagonal(square));
    }

    @Test
    public void testIsOccupied() {
        assertFalse(square.isOccupied());
    }

    @Test
    public void testIsOccupied2() {
        square.setPiece(new King(square, "w"));
        assertTrue(square.isOccupied());
    }

    @Test
    public void testEquals() {
        Square square2 = new Square(0, 0);
        assertTrue(square.equals(square2));
    }

    @Test
    public void testEquals2() {
        Square square2 = new Square(0, 3);
        assertFalse(square.equals(square2));
    }

    @Test
    public void testEquals3() {
        assertTrue(square.equals(square));
    }

    @Test
    public void testHashCode() {
        Square square2 = new Square(0, 0);
        assertEquals(square.hashCode(), square2.hashCode());
    }

    @Test
    public void testHashCode2() {
        Square square2 = new Square(1, 2);
        assertFalse(square.hashCode() == square2.hashCode());
    }
}
