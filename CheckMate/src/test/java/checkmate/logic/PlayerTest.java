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
public class PlayerTest {
    
    Player player;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        player = new Player(0);
    }

    @Test
    public void testGetColour() {
        assertEquals(0, player.getColour());
    }
    
    @Test
    public void testGetColour2() {
        Player player2 = new Player(1);
        assertEquals(1, player2.getColour());
    }
}
