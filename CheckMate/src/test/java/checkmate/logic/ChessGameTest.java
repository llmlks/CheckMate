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
public class ChessGameTest {
    
    ChessGame game;
    
    public ChessGameTest() {
    }
    
    @Before
    public void setUp() {
        this.game = new ChessGame();
    }

    @Test
    public void testConstructorCreatesNewBoard() {
        assertFalse(this.game.getBoard() == null);
    }
}
