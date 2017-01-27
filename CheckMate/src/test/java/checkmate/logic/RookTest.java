package checkmate.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class RookTest {
    
    Rook piece;
    
    public RookTest() {
    }
    
    @Before
    public void setUp() {
        piece = new Rook(0, new int[]{1, 2});
    }

    @Test
    public void testGetColour() {
        assertEquals(0, piece.getColour());
    }
    
    @Test
    public void testGetColour2() {
        Rook piece2 = new Rook(1, new int[]{2, 3});
        assertEquals(piece2.getColour(), 1);
    }

    @Test
    public void testGetPosition() {
        assertEquals(piece.getPosition()[0], 1);
        assertEquals(piece.getPosition()[1], 2);        
    }
    
    @Test
    public void testGetPosition2() {
        Rook piece2 = new Rook(1, new int[]{2, 3});
        assertEquals(piece2.getPosition()[0], 2);
        assertEquals(piece2.getPosition()[1], 3);                
    }    
}