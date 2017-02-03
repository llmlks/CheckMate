/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

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
}
