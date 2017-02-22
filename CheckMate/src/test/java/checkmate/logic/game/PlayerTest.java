/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import checkmate.logic.pieces.King;
import checkmate.logic.pieces.Pawn;
import checkmate.logic.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class PlayerTest {

    Player player;

    public PlayerTest() {
    }

    @Before
    public void setUp() {
        player = new Player("w");
    }

    @Test
    public void constructorCreatesArrayList() {
        assertFalse(player.getPieces() == null);
    }

    @Test
    public void testGetPieces() {
        assertTrue(player.getPieces().isEmpty());
    }

    @Test
    public void testGetColour() {
        assertTrue(player.getColour().equals("w"));
    }

    @Test
    public void testGetColour2() {
        Player player2 = new Player("b");
        assertTrue(player2.getColour().equals("b"));
    }

    @Test
    public void testHasKing() {
        assertFalse(player.hasKing());
    }

    @Test
    public void testHasKing2() {
        Piece p = new King(new Square(1, 1), "w");
        player.addPiece(p);
        assertTrue(player.hasKing());
    }
    
    @Test
    public void testHasKing3() {
        Piece p = new Pawn(new Square(1, 1), "w");
        player.addPiece(p);
        assertFalse(player.hasKing());        
    }

    @Test
    public void testAddPiece() {
        Piece p = new King(new Square(1, 1), "w");
        player.addPiece(p);
        assertEquals(player.getPieces().size(), 1);
    }

    @Test
    public void testRemovePiece() {
        Piece p = new King(new Square(1, 1), "w");
        player.addPiece(p);
        player.removePiece(p);
        assertEquals(player.getPieces().size(), 0);
    }
}
