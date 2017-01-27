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
public class SquareTest {
    
    Square square;
    
    public SquareTest() {
    }
    
    @Before
    public void setUp() {
        square = new Square(1, 1);
    }

    @Test
    public void testGetX() {
        assertTrue(square.getX() == 1);
    }
    
    @Test
    public void testGetX2() {
        assertTrue(new Square(3, 2).getX() == 3);
    }

    @Test
    public void testGetY() {
        assertTrue(square.getY() == 1);
    }
    
    @Test
    public void testGetY2() {
        assertTrue(new Square(3, 2).getY() == 2);
    }
    
    @Test
    public void testGetPosition() {
        assertEquals("a1", square.getPosition());
    }
    
    @Test
    public void testGetPosition2() {
        assertEquals("c2", new Square(3, 2).getPosition());
    }
}
