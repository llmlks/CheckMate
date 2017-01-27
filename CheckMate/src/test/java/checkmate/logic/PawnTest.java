/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class PawnTest {
    
    Pawn piece;
    
    public PawnTest() {
    }
    
    @Before
    public void setUp() {
        piece = new Pawn(0, new int[]{1, 2});
    }

    @Test
    public void testGetColour() {
        assertEquals(0, piece.getColour());
    }
    
    @Test
    public void testGetColour2() {
        Pawn piece2 = new Pawn(1, new int[]{2, 3});
        assertEquals(piece2.getColour(), 1);
    }

    @Test
    public void testGetPosition() {
        assertEquals(piece.getPosition()[0], 1);
        assertEquals(piece.getPosition()[1], 2);        
    }
    
    @Test
    public void testGetPosition2() {
        Pawn piece2 = new Pawn(1, new int[]{2, 3});
        assertEquals(piece2.getPosition()[0], 2);
        assertEquals(piece2.getPosition()[1], 3);                
    }
    
}